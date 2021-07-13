package com.cyn.service;

import com.cyn.pojo.UmsRoleResource;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 角色关联资源 服务类
 * </p>
 *
 * @author giegie
 * @since 2021-07-06
 */
public interface IUmsRoleResourceService extends IService<UmsRoleResource> {
    boolean save(Long roleId, Long[] resourceIds);
    List<Long> getByRoleId(Long roleId);
}
