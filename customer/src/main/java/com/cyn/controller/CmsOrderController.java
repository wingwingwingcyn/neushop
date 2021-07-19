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
        }
        return ResultJson.success(orderList) ;
    }

    @GetMapping("/find")
    ResultJson find(String name) throws InterruptedException {
        List<OrderInformation> orderList=cmsOrderService.getOrders();
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
        }
        List<OrderInformation> orderList2=new ArrayList<>();
        System.out.println("=======name========"+name);
        for(OrderInformation value:orderList){
            if (value.getNickyName().contains(name)){
                orderList2.add(value);
            }
        }
        return ResultJson.success(orderList2) ;
    }

    @GetMapping("/getone")
    ResultJson getOne(Long id) {
        return ResultJson.success(cmsOrderService.getById(id));
    }

}
