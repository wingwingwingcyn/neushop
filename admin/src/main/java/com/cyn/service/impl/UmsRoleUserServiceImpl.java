package com.cyn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cyn.pojo.UmsRoleUser;
import com.cyn.mapper.UmsRoleUserMapper;
import com.cyn.service.IUmsRoleUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 角色与用户关联表 服务实现类
 * </p>
 *
 * @author giegie
 * @since 2021-07-02
 */
@Service
public class UmsRoleUserServiceImpl extends ServiceImpl<UmsRoleUserMapper, UmsRoleUser> implements IUmsRoleUserService {

    @Override
    @Transactional
    public boolean save(Long roleId, Long[] userIds) {
        QueryWrapper<UmsRoleUser> wrapper=new QueryWrapper<>();
        wrapper.eq("role_id",roleId);
        this.remove(wrapper);

        List<UmsRoleUser> list = new ArrayList<>();
        for (Long userId : userIds){
            list.add(new UmsRoleUser(roleId ,userId));
        }
        return this.saveBatch(list);
    }

    @Override
    public List<UmsRoleUser> getUsersByRoleId(Long roleId) {
        QueryWrapper<UmsRoleUser> wrapper=new QueryWrapper<>();
        wrapper.eq("role_id",roleId);
        return this.list(wrapper);
    }


}
