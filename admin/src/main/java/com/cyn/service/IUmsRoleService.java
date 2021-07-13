package com.cyn.service;

import com.cyn.pojo.UmsRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author giegie
 * @since 2021-07-02
 */
public interface IUmsRoleService extends IService<UmsRole> {
    List<UmsRole> list(String name);

}
