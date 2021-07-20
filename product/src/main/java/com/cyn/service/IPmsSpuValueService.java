package com.cyn.service;

import com.cyn.pojo.PmsSpuValue;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 商品spu值 服务类
 * </p>
 *
 * @author giegie
 * @since 2021-07-09
 */
public interface IPmsSpuValueService extends IService<PmsSpuValue> {
    List<PmsSpuValue> spuValueList(Long productId);
}
