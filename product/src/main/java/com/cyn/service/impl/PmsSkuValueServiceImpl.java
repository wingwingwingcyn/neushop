package com.cyn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cyn.pojo.PmsSkuValue;
import com.cyn.mapper.PmsSkuValueMapper;
import com.cyn.service.IPmsSkuValueService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品sku值 服务实现类
 * </p>
 *
 * @author giegie
 * @since 2021-07-09
 */
@Service
public class PmsSkuValueServiceImpl extends ServiceImpl<PmsSkuValueMapper, PmsSkuValue> implements IPmsSkuValueService {

    @Override
    public List<PmsSkuValue> skuValueList(Long productId) {
        QueryWrapper<PmsSkuValue> wrapper = new QueryWrapper<>();
        wrapper.eq("product_id", productId);
        return this.list(wrapper);
    }
}
