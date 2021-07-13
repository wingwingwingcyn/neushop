package com.cyn.service.impl;

import com.cyn.pojo.CmsOrder;
import com.cyn.mapper.CmsOrderMapper;
import com.cyn.service.ICmsOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author giegie
 * @since 2021-07-12
 */
@Service
public class CmsOrderServiceImpl extends ServiceImpl<CmsOrderMapper, CmsOrder> implements ICmsOrderService {

}
