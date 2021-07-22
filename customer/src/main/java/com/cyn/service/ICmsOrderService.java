package com.cyn.service;

import com.cyn.pojo.CmsOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cyn.pojo.CmsShoppingCart;

import java.util.List;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author giegie
 * @since 2021-07-12
 */
public interface ICmsOrderService extends IService<CmsOrder> {
    List<CmsOrder> getOrderById(Long productId);
    CmsOrder updateState(Long customerId);
    Long getId();
}
