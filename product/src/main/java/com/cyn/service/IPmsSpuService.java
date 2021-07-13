package com.cyn.service;

import com.cyn.pojo.PmsSpu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * spu属性表 服务类
 * </p>
 *
 * @author giegie
 * @since 2021-07-08
 */
public interface IPmsSpuService extends IService<PmsSpu> {
    List<PmsSpu> list(Long categoryId);
    List<PmsSpu> getByCategory(Long[] categoryIds);
}
