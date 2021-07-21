package com.cyn.controller;


import com.cyn.mapper.PmsAddCartMapper;
import com.cyn.pojo.PmsAddCart;
import com.cyn.service.IPmsAddCartService;
import com.cyn.util.ResultJson;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 添加购物车表 前端控制器
 * </p>
 *
 * @author giegie
 * @since 2021-07-20
 */
@RestController
@RequestMapping("/pms-add-cart")
public class PmsAddCartController {


    @Resource
    IPmsAddCartService addCartService;


    @PostMapping("/addOrUpdateCart")
    ResultJson addOrUpdateCart(PmsAddCart pmsAddCart){
        Integer newNum = 0;
        PmsAddCart cart = addCartService.getCart(pmsAddCart.getProductId(), pmsAddCart.getDetail());
        if (cart == null){
            return ResultJson.success(addCartService.save(pmsAddCart), "添加购物车成功");
        }else {
            if (pmsAddCart.getProductId() == cart.getProductId() && pmsAddCart.getDetail().equals(cart.getDetail())){
                newNum = pmsAddCart.getProductNum() + cart.getProductNum();
                cart.setProductNum(newNum);
                return ResultJson.success(addCartService.updateById(cart), "添加购物车成功");
            }else {
                return ResultJson.success(addCartService.save(pmsAddCart), "添加购物车成功");
            }
        }
    }


}
