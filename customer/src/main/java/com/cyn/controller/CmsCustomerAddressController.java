package com.cyn.controller;


import com.cyn.pojo.CmsCustomerAddress;
import com.cyn.service.ICmsCustomerAddressService;
import com.cyn.util.ResultJson;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 顾客地址表 前端控制器
 * </p>
 *
 * @author giegie
 * @since 2021-07-12
 */
@RestController
@CrossOrigin
@RequestMapping("/cms-customer-address")
public class CmsCustomerAddressController {
    @Resource
    ICmsCustomerAddressService addressService;
    @GetMapping("/list")
    ResultJson list(Long customerId){
        return ResultJson.success(addressService.getAddressById(customerId));
    }
    @PostMapping("/del")
    ResultJson del(Long chosenAddressId) {
        return ResultJson.success(addressService.removeById(chosenAddressId),"删除收货地址成功");
    }
    @PostMapping("/add")
    ResultJson add(CmsCustomerAddress customerAddress){
        return ResultJson.success(addressService.save(customerAddress),"保存地址成功");
    }
    @PostMapping("/update")
    ResultJson update(CmsCustomerAddress customerAddress){
        System.out.println(customerAddress);
        return ResultJson.success(addressService.updateById(customerAddress),"修改地址成功");
    }
    @GetMapping("/setDefault")
    ResultJson setDefault(Long customerId){
        return ResultJson.success(addressService.setDefault(customerId));
    }
    @GetMapping("/getone")
    ResultJson getone(Long chosenAddressId){
        return ResultJson.success(addressService.getById(chosenAddressId));
    }
}
