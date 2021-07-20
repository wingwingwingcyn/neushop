package com.cyn.service.impl;

import com.alibaba.nacos.client.utils.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cyn.pojo.CmsShoppingCart;
import com.cyn.mapper.CmsShoppingCartMapper;
import com.cyn.service.ICmsShoppingCartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
    public List<CmsShoppingCart> list(String productName) {
        QueryWrapper<CmsShoppingCart> wrapper=new QueryWrapper<>();
        if(StringUtils.isNotBlank(productName)){
            wrapper.like("product_name",productName);
        }
        return this.list(wrapper);
    }

}

