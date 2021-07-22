package com.cyn.service;

import com.cyn.pojo.PmsProduct;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 商品表 服务类
 * </p>
 *
 * @author giegie
 * @since 2021-07-08
 */
public interface IPmsProductService extends IService<PmsProduct> {
    List<PmsProduct> list(String name);
    List<PmsProduct> list2(Long categoryId);
}
