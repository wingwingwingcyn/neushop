package com.cyn.service.impl;

import com.cyn.pojo.PmsProduct;
import com.cyn.mapper.PmsProductMapper;
import com.cyn.service.IPmsProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
