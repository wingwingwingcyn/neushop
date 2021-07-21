package com.cyn.controller;


import com.cyn.pojo.PmsAddCart;
import com.cyn.service.IPmsAddCartService;
import com.cyn.util.ResultJson;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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





}
