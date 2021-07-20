package com.cyn.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import com.cyn.pojo.CmsShoppingCart;
import com.cyn.service.ICmsShoppingCartService;
import com.cyn.util.ResultJson;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    ResultJson list(String productName ){
        return ResultJson.success(cmsShoppingCartService.list(productName));
    }
    @PostMapping("/del")
    ResultJson del(CmsShoppingCart cmsShoppingCart) {
        return ResultJson.success(cmsShoppingCartService.updateById(cmsShoppingCart),"删除商品成功！");
    }

}
