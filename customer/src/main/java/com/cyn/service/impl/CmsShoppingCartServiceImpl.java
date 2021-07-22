package com.cyn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cyn.pojo.CmsShoppingCart;
import com.cyn.mapper.CmsShoppingCartMapper;
import com.cyn.service.ICmsShoppingCartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 顾客购物车表 服务实现类
 * </p>
 *
 * @author giegie
 * @since 2021-07-12
 */
@Service
public class CmsShoppingCartServiceImpl extends ServiceImpl<CmsShoppingCartMapper, CmsShoppingCart> implements ICmsShoppingCartService {
    @Override
    public List<CmsShoppingCart> list(Long customerId) {
        QueryWrapper<CmsShoppingCart> wrapper=new QueryWrapper<>();
            wrapper.like("customer_id",customerId);
        return this.list(wrapper);
    }

    @Override
    public String delAll() {
        QueryWrapper<CmsShoppingCart> wrapper=new QueryWrapper<>();
        wrapper.eq("active",1);
        List<CmsShoppingCart> cmsShoppingCarts = this.list(wrapper);
        cmsShoppingCarts.forEach(cmsShoppingCart -> {
            cmsShoppingCart.setActive(0);
        });
        this.updateBatchById(cmsShoppingCarts);
        return "";
    }
}
