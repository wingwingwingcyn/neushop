package com.cyn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cyn.pojo.UmsRole;
import com.cyn.mapper.UmsRoleMapper;
import com.cyn.service.IUmsRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author giegie
 * @since 2021-07-02
 */
@Service
public class UmsRoleServiceImpl extends ServiceImpl<UmsRoleMapper, UmsRole> implements IUmsRoleService {
    @Override
    public List<UmsRole> list(String name) {
        QueryWrapper<UmsRole> wrapper=new QueryWrapper<>();
        if(StringUtils.isNotBlank(name)){
            wrapper.like("name",name);
        }
        return this.list(wrapper);
    }
}
