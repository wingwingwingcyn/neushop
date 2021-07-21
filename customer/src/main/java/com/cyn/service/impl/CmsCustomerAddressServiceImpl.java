package com.cyn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cyn.pojo.CmsCustomerAddress;
import com.cyn.mapper.CmsCustomerAddressMapper;
import com.cyn.service.ICmsCustomerAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 顾客地址表 服务实现类
 * </p>
 *
 * @author YanMin zhang
 * @since 2021-07-14
 */
@Service
public class CmsCustomerAddressServiceImpl extends ServiceImpl<CmsCustomerAddressMapper, CmsCustomerAddress> implements ICmsCustomerAddressService {

    public List<CmsCustomerAddress> getAddressById(Long customerId) {
        QueryWrapper<CmsCustomerAddress> wrapper = new QueryWrapper<CmsCustomerAddress>();
        wrapper.eq("customer_id",customerId);
        return this.list(wrapper);
    }

    @Override
    public String setDefault(Long customerId) {
        QueryWrapper<CmsCustomerAddress> wrapper = new QueryWrapper<CmsCustomerAddress>();
        wrapper.eq("customer_id",customerId);
        List<CmsCustomerAddress> list = list(wrapper);
        for (CmsCustomerAddress address: list) {
            address.setIsDefault(0);
        }
        this.updateBatchById(list);
        return "设置默认收货地址成功";
    }

    @Override
    public CmsCustomerAddress getDefault(Long cutomerId) {
        QueryWrapper<CmsCustomerAddress> wrapper = new QueryWrapper<>();
        wrapper.eq("is_default",1);
        wrapper.eq("customer_id",cutomerId);
        return this.getOne(wrapper);
    }
}
