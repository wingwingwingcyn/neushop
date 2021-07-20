package com.cyn.service;

import com.cyn.pojo.PmsCategory;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 分类表 服务类
 * </p>
 *
 * @author giegie
 * @since 2021-07-07
 */
public interface IPmsCategoryService extends IService<PmsCategory> {
    List<PmsCategory> getByParentId(Long parentId);
    List<PmsCategory> getAll(Long parentId);

    List<PmsCategory> getParent();
}
