package com.cyn.controller;


import com.cyn.pojo.CmsCustomerAddress;
import com.cyn.service.ICmsCustomerAddressService;
import com.cyn.util.ResultJson;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 顾客地址表 前端控制器
 * </p>
 *
 * @author YanMin zhang
 * @since 2021-07-14
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
    @GetMapping("/getDefault")
    ResultJson getDefault(Long customerId){
        return ResultJson.success(addressService.getDefault(customerId));
    }
    @PostMapping("/setAllNotDefaultWhenAdd")
    ResultJson setAllNotDefaultWhenAdd(Long customerId){
        return ResultJson.success(addressService.setAllNotDefaultWhenAdd(customerId));
    }
}
