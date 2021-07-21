package com.cyn.controller;


import com.cyn.pojo.CmsCustomer;
import com.cyn.pojo.CmsOrder;
import com.cyn.pojo.OrderInformation;
import com.cyn.pojo.PmsProduct;
import com.cyn.service.ICmsOrderService;
import com.cyn.util.ResultJson;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    ResultJson list() throws InterruptedException {
        List<OrderInformation> orderList=cmsOrderService.getOrders();
        return ResultJson.success(orderList) ;
    }

    @GetMapping("/find")
    ResultJson find(String name) throws InterruptedException {
        List<OrderInformation> orderList=cmsOrderService.getOrders();
        List<OrderInformation> orderList2=new ArrayList<>();
        for(OrderInformation value:orderList){
            if (value.getNickyName().contains(name)){
                orderList2.add(value);
            }
        }
        return ResultJson.success(orderList2) ;
    }

    @GetMapping("/deliver")
    ResultJson deliver(Long id) throws InterruptedException {
        CmsOrder cmsOrder=cmsOrderService.getById(id);
        cmsOrder.setStateId(3);
        cmsOrderService.updateById(cmsOrder);
        List<OrderInformation> orderList=cmsOrderService.getOrders();
        return ResultJson.success(orderList) ;
    }

    @GetMapping("/getone")
    ResultJson getOne(Long id) {
        return ResultJson.success(cmsOrderService.getById(id));
    }

}
