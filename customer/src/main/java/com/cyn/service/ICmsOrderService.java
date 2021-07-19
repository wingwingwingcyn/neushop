package com.cyn.service;

import com.cyn.pojo.CmsCustomer;
import com.cyn.pojo.CmsOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cyn.pojo.OrderInformation;
import com.cyn.pojo.PmsProduct;
import feign.Param;

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
    List<OrderInformation> getOrders();
}
