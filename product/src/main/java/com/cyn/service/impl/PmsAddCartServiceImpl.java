package com.cyn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cyn.pojo.PmsAddCart;
import com.cyn.mapper.PmsAddCartMapper;
import com.cyn.service.IPmsAddCartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 添加购物车表 服务实现类
 * </p>
 *
 * @author giegie
 * @since 2021-07-20
 */
@Service
public class PmsAddCartServiceImpl extends ServiceImpl<PmsAddCartMapper, PmsAddCart> implements IPmsAddCartService {


    @Override
    public PmsAddCart getCart(Long proId, String proDetail) {
        QueryWrapper<PmsAddCart> wrapper = new QueryWrapper<>();
        wrapper.eq("product_id",proId);
        wrapper.eq("detail",proDetail);
        return this.getOne(wrapper);

    }
}
