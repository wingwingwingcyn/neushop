package com.cyn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cyn.pojo.CmsFootprint;
import com.cyn.mapper.CmsFootprintMapper;
import com.cyn.service.ICmsFootprintService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author giegie
 * @since 2021-07-21
 */
@Service
public class CmsFootprintServiceImpl extends ServiceImpl<CmsFootprintMapper, CmsFootprint> implements ICmsFootprintService {

    @Override
    public List<CmsFootprint> getFootprint(Integer customerId) {
        QueryWrapper<CmsFootprint> wrapper = new QueryWrapper<>();
        wrapper.eq("customer_id",customerId);
        wrapper.eq("is_fc",0);
        List<CmsFootprint> list = this.list(wrapper);
        List<CmsFootprint> result = new ArrayList<>();
        list.forEach(CmsFootprint -> {
            result.add(CmsFootprint);
        });
        return result;
    }
//    @Override
//    public List<CmsFootprint> delAll(Integer customerId) {
//        QueryWrapper<CmsFootprint> wrapper = new QueryWrapper<>();
//        wrapper.eq("customer_id",customerId);
//        wrapper.eq("is_fc",0);
//        return null;
//    }

    @Override
    public List<CmsFootprint> getCollection(Integer customerId) {
        QueryWrapper<CmsFootprint> wrapper = new QueryWrapper<>();
        wrapper.eq("customer_id",customerId);
        wrapper.eq("is_fc",1);
        List<CmsFootprint> list = this.list(wrapper);
        List<CmsFootprint> result = new ArrayList<>();
        list.forEach(CmsFootprint -> {
            result.add(CmsFootprint);
        });
        return result;
    }
}
