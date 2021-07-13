package com.cyn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cyn.pojo.UmsResource;
import com.cyn.pojo.UmsUser;
import com.cyn.mapper.UmsUserMapper;
import com.cyn.service.IUmsResourceService;
import com.cyn.service.IUmsUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author giegeie
 * @since 2021-06-29
 */
@Service
public class UmsUserServiceImpl extends ServiceImpl<UmsUserMapper, UmsUser> implements IUmsUserService {
    @Resource
    BCryptPasswordEncoder passwordEncoder;
    @Resource
    IUmsResourceService resourceService;
    @Override
    public IPage<UmsUser> page(Integer pageNo, Integer pageSize, String name) {
        QueryWrapper<UmsUser> wrapper=new QueryWrapper<>();
        if(StringUtils.isNotBlank(name)){
            wrapper.like("nicky_name",name);
        }
        return this.page(new Page<>(pageNo,pageSize),wrapper);
    }

    @Override
    public List<UmsUser> getAll() {
        QueryWrapper<UmsUser> wrapper=new QueryWrapper<>();
        wrapper.eq("active",1);
        return this.list(wrapper);
    }

    @Override
    public Map<String,Object> login(String username, String password) throws Exception {
        // 验证用户名和密码
        QueryWrapper<UmsUser> wrapper = new QueryWrapper<>();
        wrapper.eq("login_name",username);
        UmsUser user = this.getOne(wrapper);
        if(user == null) {
            throw new Exception("用户名或密码错误");
        }
        if(user.getActive() == 0) {
            throw new Exception("该用户已经失效,无法登录");
        }
        if(!passwordEncoder.matches(password,user.getPassword())) {
            throw new Exception("用户名或密码错误");
        }
        // 如果登录成功 获取到用户权限
        List<UmsResource> resources = resourceService.getByUserId(user.getId());
        Map<String, Object> split = split(resources);

        Map<String,Object> reslut = new HashMap<>();
        reslut.put("front",split.get("front"));
        String token = JWT.create().withClaim("username",username)
                .withClaim("backurls",(List<String>)split.get("back"))
                .sign(Algorithm.HMAC256("wangyu"));
        reslut.put("token",token);
        return reslut;
    }

    private Map<String,Object> split(List<UmsResource> resources) {
        Map<String,Object> map = new HashMap<>();
        List<String> backurls = new ArrayList<>();
        List<UmsResource> front = getByParentId(resources,0L);
        for(UmsResource resource : resources) {
            if(StringUtils.isNotBlank(resource.getBackUrl())) {
                backurls.add(resource.getBackUrl());
            }
        }
        System.out.println(front);
        map.put("back",backurls);
        map.put("front",front);
        return map;
    }
    private List<UmsResource> getByParentId(List<UmsResource> list, Long parentId) {
        List<UmsResource> result = new ArrayList<>();
        for(UmsResource resource : list) {
            if(resource.getParentId().longValue() == parentId.longValue() && resource.getType().intValue() == 0) {
                resource.setChildren(getByParentId(list, resource.getId()));
                result.add(resource);
            }
        }
        return result;
    }

}
