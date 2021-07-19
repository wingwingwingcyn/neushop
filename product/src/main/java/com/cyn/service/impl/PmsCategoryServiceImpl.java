package com.cyn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cyn.pojo.PmsCategory;
import com.cyn.mapper.PmsCategoryMapper;
import com.cyn.service.IPmsCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 分类表 服务实现类
 * </p>
 *
 * @author giegie
 * @since 2021-07-07
 */
@Service
public class PmsCategoryServiceImpl extends ServiceImpl<PmsCategoryMapper, PmsCategory> implements IPmsCategoryService {
    public List<PmsCategory> getByParentId(Long parentId, Integer active) {
        QueryWrapper<PmsCategory> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id",parentId);
        if(active != null) {
            wrapper.eq("active",active);
        }
        List<PmsCategory> list = this.list(wrapper);
        for(PmsCategory category : list) {
            if(category.getActive() == 1) {
                category.setChildren(getByParentId(category.getId(),active));
            }
        }
        return list;
    }

    @Override
    public List<PmsCategory> getParent() {
        QueryWrapper<PmsCategory> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id",0);
        wrapper.eq("active",1);
        return this.list(wrapper);
    }

    @Override
    public List<PmsCategory> getByParentId(Long parentId) {
        return this.getByParentId(parentId,null);
    }

    @Override
    public List<PmsCategory> getAll(Long parentId) {
        return this.getByParentId(parentId,1);
    }

}
