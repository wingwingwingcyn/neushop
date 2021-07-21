package com.cyn.service;

import com.cyn.pojo.PmsAddCart;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 添加购物车表 服务类
 * </p>
 *
 * @author giegie
 * @since 2021-07-20
 */
public interface IPmsAddCartService extends IService<PmsAddCart> {

    PmsAddCart getCart(Long proId, String proDetail);




}
