package com.cyn.service.impl;

import com.cyn.pojo.PmsStock;
import com.cyn.mapper.PmsStockMapper;
import com.cyn.service.IPmsStockService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * sku库存表 服务实现类
 * </p>
 *
 * @author giegie
 * @since 2021-07-09
 */
@Service
public class PmsStockServiceImpl extends ServiceImpl<PmsStockMapper, PmsStock> implements IPmsStockService {

}
