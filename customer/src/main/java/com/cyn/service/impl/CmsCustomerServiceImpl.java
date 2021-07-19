package com.cyn.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cyn.pojo.CmsCustomer;
import com.cyn.mapper.CmsCustomerMapper;
import com.cyn.pojo.UmsResource;
import com.cyn.pojo.UmsUser;
import com.cyn.service.ICmsCustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author giegie
 * @since 2021-07-12
 */
@Service
public class CmsCustomerServiceImpl extends ServiceImpl<CmsCustomerMapper, CmsCustomer> implements ICmsCustomerService {
    @Resource
    BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<CmsCustomer> getAll() {
        QueryWrapper<CmsCustomer> wrapper=new QueryWrapper<>();
        wrapper.eq("active",1);
        return this.list(wrapper);
    }

    @Override
    public Map<String,Object> login(String account, String password) throws Exception {
        // 验证用户名和密码
        QueryWrapper<CmsCustomer> wrapper = new QueryWrapper<>();
        wrapper.eq("account",account);
        CmsCustomer customer = this.getOne(wrapper);
        if(customer == null) {
            throw new Exception("用户名或密码错误");
        }
        if(customer.getActive() == 0) {
            throw new Exception("该用户已经失效,无法登录");
        }
        if(!passwordEncoder.matches(password,customer.getPassword())) {
            throw new Exception("用户名或密码错误");
        }

        //用户登录成功
        Map<String,Object> reslut = new HashMap<>();
        reslut.put("customer",customer);
        return reslut;
    }

}
