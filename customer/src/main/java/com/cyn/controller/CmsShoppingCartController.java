package com.cyn.controller;


import com.cyn.pojo.CmsShoppingCart;
import com.cyn.pojo.PmsAddCart;
import com.cyn.service.ICmsShoppingCartService;
import com.cyn.util.ResultJson;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
    ResultJson list(Long customerId){
        return ResultJson.success(cmsShoppingCartService.list(customerId));
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
    @PostMapping("/addOrUpdateCart")
    ResultJson addOrUpdateCart(CmsShoppingCart pmsAddCart){
        Integer newNum = 0;
        CmsShoppingCart cart = cmsShoppingCartService.getCart(pmsAddCart.getProductId(), pmsAddCart.getDetail());
        if (cart == null){
            return ResultJson.success(cmsShoppingCartService.save(pmsAddCart), "添加购物车成功");
        }else {
            if (pmsAddCart.getProductId() == cart.getProductId() && pmsAddCart.getDetail().equals(cart.getDetail())){
                newNum = pmsAddCart.getProductNum() + cart.getProductNum();
                cart.setProductNum(newNum);
                return ResultJson.success(cmsShoppingCartService.updateById(cart), "添加购物车成功");
            }else {
                return ResultJson.success(cmsShoppingCartService.save(pmsAddCart), "添加购物车成功");
            }
        }
    }

}
