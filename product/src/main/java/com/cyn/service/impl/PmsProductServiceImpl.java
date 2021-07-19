package com.cyn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cyn.pojo.PmsProduct;
import com.cyn.mapper.PmsProductMapper;
import com.cyn.service.IPmsProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author giegie
 * @since 2021-07-08
 */
@Service
public class PmsProductServiceImpl extends ServiceImpl<PmsProductMapper, PmsProduct> implements IPmsProductService {
    @Override
    public List<PmsProduct> list(String name) {
        QueryWrapper<PmsProduct> wrapper=new QueryWrapper<>();
        if(StringUtils.isNotBlank(name)){
            wrapper.like("name",name);
        }
        return this.list(wrapper);
    }

    @Override
    public List<PmsProduct> list2(Long categoryId) {
        QueryWrapper<PmsProduct> wrapper=new QueryWrapper<>();
            wrapper.eq("category_id",categoryId);
        return this.list(wrapper);
    }
}
