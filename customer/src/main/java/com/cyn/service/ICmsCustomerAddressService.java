package com.cyn.service;

import com.cyn.pojo.CmsCustomerAddress;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 顾客地址表 服务类
 * </p>
 *
 * @author YanMin zhang
 * @since 2021-07-14
 */
public interface ICmsCustomerAddressService extends IService<CmsCustomerAddress> {
    List<CmsCustomerAddress> getAddressById(Long customerId);
    String setDefault(Long customerId);
}
