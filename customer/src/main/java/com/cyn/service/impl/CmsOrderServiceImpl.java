package com.cyn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cyn.pojo.CmsOrder;
import com.cyn.mapper.CmsOrderMapper;
import com.cyn.pojo.CmsShoppingCart;
import com.cyn.service.ICmsOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.nio.file.Watchable;
import java.util.List;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author giegie
 * @since 2021-07-12
 */
@Service
public class CmsOrderServiceImpl extends ServiceImpl<CmsOrderMapper, CmsOrder> implements ICmsOrderService {

    @Override
    public List<CmsOrder> getOrderById(Long customerId) {
        QueryWrapper<CmsOrder> wrapper = new QueryWrapper<>();
        wrapper.eq("customer_id",customerId);
        return this.list(wrapper);
    }
    @Override
    public CmsOrder updateState(Long customerId) {
        QueryWrapper<CmsOrder> wrapper = new QueryWrapper<>();
        wrapper.eq("customer_id",customerId);
        this.update(wrapper);
        return this.getById(customerId);
    }

    @Override
    public Long getId() {
        QueryWrapper<CmsOrder> wrapper = new QueryWrapper<>();
        wrapper.like("detail","");
        List<CmsOrder> list = this.list(wrapper);
        CmsOrder cmsOrder = list.get(list.size()-1);
        return cmsOrder.getId();
    }
}
