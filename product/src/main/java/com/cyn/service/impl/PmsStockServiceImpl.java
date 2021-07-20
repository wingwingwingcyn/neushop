package com.cyn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cyn.pojo.PmsStock;
import com.cyn.mapper.PmsStockMapper;
import com.cyn.service.IPmsStockService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * sku库存表 服务实现类
 * </p>
 *
 * @author giegie
 * @since 2021-07-09
 */
@Service
public class PmsStockServiceImpl extends ServiceImpl<PmsStockMapper, PmsStock> implements IPmsStockService {

    @Override
    public List<PmsStock> stockList(Long productId) {
        QueryWrapper<PmsStock> wrapper = new QueryWrapper<>();
        wrapper.eq("product_id", productId);
        return this.list(wrapper);
    }
}
