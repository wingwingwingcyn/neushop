package com.cyn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cyn.pojo.PmsSpuValue;
import com.cyn.mapper.PmsSpuValueMapper;
import com.cyn.service.IPmsSpuValueService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品spu值 服务实现类
 * </p>
 *
 * @author giegie
 * @since 2021-07-09
 */
@Service
public class PmsSpuValueServiceImpl extends ServiceImpl<PmsSpuValueMapper, PmsSpuValue> implements IPmsSpuValueService {

    @Override
    public List<PmsSpuValue> spuValueList(Long productId) {
        QueryWrapper<PmsSpuValue> wrapper = new QueryWrapper<>();
        wrapper.eq("product_id", productId);
        return this.list(wrapper);
    }
}
