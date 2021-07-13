package com.cyn.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cyn.pojo.UmsUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author giegeie
 * @since 2021-06-29
 */
public interface IUmsUserService extends IService<UmsUser> {
    IPage<UmsUser> page(Integer pageNo, Integer pageSize, String name);
    List<UmsUser> getAll();
    Map<String,Object> login(String username, String password) throws Exception;
}
