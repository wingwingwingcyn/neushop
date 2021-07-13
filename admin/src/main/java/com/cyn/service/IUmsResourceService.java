package com.cyn.service;

import com.cyn.pojo.UmsResource;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 资源表 服务类
 * </p>
 *
 * @author giegie
 * @since 2021-07-06
 */
public interface IUmsResourceService extends IService<UmsResource> {
    List<UmsResource> getResource(Long parentId);
    List<Long> getLast();
    List<UmsResource> getByUserId(Long userId);
}
