package com.cyn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cyn.pojo.CmsCustomer;
import com.cyn.pojo.CmsOrder;
import com.cyn.mapper.CmsOrderMapper;
import com.cyn.pojo.OrderInformation;
import com.cyn.pojo.PmsProduct;
import com.cyn.service.ICmsOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import feign.Param;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    @Resource
    CmsOrderMapper orderMapper;
    @Override
    public List<OrderInformation> getOrders(String name) {
        QueryWrapper<OrderInformation> wrapper=new QueryWrapper<>();
        if(StringUtils.isNotBlank(name)){
            wrapper.like("nicky_name",name);
        }
        return orderMapper.getOrderList();
    }

}
