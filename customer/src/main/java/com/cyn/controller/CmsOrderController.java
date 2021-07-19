package com.cyn.controller;


import com.cyn.pojo.CmsCustomer;
import com.cyn.pojo.OrderInformation;
import com.cyn.pojo.PmsProduct;
import com.cyn.service.ICmsOrderService;
import com.cyn.util.ResultJson;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
    ResultJson list(String name) throws InterruptedException {
//        List<CmsCustomer> cmsCustomerList=cmsOrderService.getCustomers();
        List<OrderInformation> orderList=cmsOrderService.getOrders(name);
        for(OrderInformation value:orderList){
            if (value.getStateId()==1){
                value.setStateName("待付款");
            }else if (value.getStateId()==2){
                value.setStateName("待发货");
            }else if (value.getStateId()==3){
                value.setStateName("待收货");
            }else if (value.getStateId()==4){
                value.setStateName("待评价");
            }else if (value.getStateId()==5){
                value.setStateName("售后/退款");
            }else{
                value.setStateName("已结束");
            }
            System.out.println(value);
        }
        return ResultJson.success(orderList) ;
    }

    @GetMapping("/getone")
    ResultJson getOne(Long id) {
        return ResultJson.success(cmsOrderService.getById(id));
    }

}
