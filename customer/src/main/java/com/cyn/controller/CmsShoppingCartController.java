package com.cyn.controller;


import com.cyn.service.ICmsCustomerAddressService;
import com.cyn.service.ICmsShoppingCartService;
import com.cyn.util.ResultJson;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 顾客购物车表 前端控制器
 * </p>
 *
 * @author giegie
 * @since 2021-07-12
 */
@RestController
@CrossOrigin
@RequestMapping("/cms-shopping-cart")
public class CmsShoppingCartController {
    @Resource
    ICmsShoppingCartService cmsShoppingCartService;
    @GetMapping("/list")
    ResultJson list(Long productId){
        return ResultJson.success(cmsShoppingCartService.getShoppingCartById(productId));
    }
}
