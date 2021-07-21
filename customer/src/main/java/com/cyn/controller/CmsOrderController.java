package com.cyn.controller;


import com.cyn.pojo.CmsOrder;
import com.cyn.service.ICmsOrderService;
import com.cyn.util.ResultJson;
import org.springframework.core.Ordered;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 订单表 前端控制器
 * </p>
 *
 * @author giegie
 * @since 2021-07-12
 */
@RestController
@CrossOrigin
@RequestMapping("/cms-order")
public class CmsOrderController {
    @Resource
    ICmsOrderService cmsOrderService;

    @GetMapping("/list")
    ResultJson list(Long customerId){
        return ResultJson.success(cmsOrderService.getOrderById(customerId));
    }

    @GetMapping("/getone")
    ResultJson getone(Long orderId){
        return ResultJson.success(cmsOrderService.getById(orderId),"获取订单成功");
    }

    @GetMapping("/addorder")
    ResultJson add(Long productId,Long cutomerId,
                   Long addressId,
                   BigDecimal price ,
                   String detail ,
                   String img ,
                   String productName,
                   Integer productNum ){
        CmsOrder order = new CmsOrder();
        order.setProductId(productId);
        order.setAddressId(addressId);
        order.setCustomerId(cutomerId);
        order.setPrice(price);
        order.setStateId(1);
        order.setImg(img);
        order.setProductName(productName);
        order.setProductNum(productNum);
        order.setDetail(detail);
        return ResultJson.success(cmsOrderService.save(order));
    }

    @GetMapping("/pay")
    ResultJson pay(Long orderId){
        CmsOrder o = cmsOrderService.getById(orderId);
        o.setStateId(2);
        cmsOrderService.updateById(o);
        return ResultJson.success(o,"支付成功");
    }
    @GetMapping("/take")
    ResultJson take(Long orderId){
        CmsOrder o = cmsOrderService.getById(orderId);
        o.setStateId(4);
        cmsOrderService.updateById(o);
        return ResultJson.success(o,"已成功收货");
    }

}
