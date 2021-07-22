package com.cyn.mapper;

import com.cyn.pojo.CmsFootprint;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author giegie
 * @since 2021-07-21
 */
public interface CmsFootprintMapper extends BaseMapper<CmsFootprint> {
    void delAll(Integer customerId);
    void delAllCollection(Integer customerId);
}
