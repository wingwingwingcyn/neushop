package com.cyn.service;

import com.cyn.pojo.PmsSkuValue;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 商品sku值 服务类
 * </p>
 *
 * @author giegie
 * @since 2021-07-09
 */
public interface IPmsSkuValueService extends IService<PmsSkuValue> {
    List<PmsSkuValue> skuValueList(Long productId);
}
