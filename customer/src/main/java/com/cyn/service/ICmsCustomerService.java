package com.cyn.service;

import com.cyn.pojo.CmsCustomer;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author giegie
 * @since 2021-07-12
 */
public interface ICmsCustomerService extends IService<CmsCustomer> {
    Map<String,Object> login(String account, String password) throws Exception;
    List<CmsCustomer> getAll();
}
