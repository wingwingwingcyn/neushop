package com.cyn.service;

import com.cyn.pojo.PmsStock;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * sku库存表 服务类
 * </p>
 *
 * @author giegie
 * @since 2021-07-09
 */
public interface IPmsStockService extends IService<PmsStock> {
    List<PmsStock> stockList(Long productId);
}
