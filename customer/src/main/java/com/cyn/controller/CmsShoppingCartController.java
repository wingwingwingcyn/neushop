package com.cyn.controller;


import com.cyn.pojo.CmsShoppingCart;
import com.cyn.pojo.PmsAddCart;
import com.cyn.service.ICmsShoppingCartService;
import com.cyn.util.ResultJson;
import org.springframework.web.bind.annotation.*;

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
        System.out.println(cmsShoppingCart);
        return ResultJson.success(cmsShoppingCartService.updateById(cmsShoppingCart),"删除商品成功！");
    }
    @PostMapping("/delAll")
    ResultJson  delAll(){
        return ResultJson.success(cmsShoppingCartService.delAll());
    }
    @PostMapping("/add")
    ResultJson add(CmsShoppingCart pmsAddCart){
        return ResultJson.success(cmsShoppingCartService.save(pmsAddCart), "添加购物车成功");
    }

}
