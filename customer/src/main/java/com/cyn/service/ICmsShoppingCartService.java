package com.cyn.service;

import com.cyn.pojo.CmsShoppingCart;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 顾客购物车表 服务类
 * </p>
 *
 * @author giegie
 * @since 2021-07-12
 */
public interface ICmsShoppingCartService extends IService<CmsShoppingCart> {
    List<CmsShoppingCart> list(String productName);
    String delAll();
}
