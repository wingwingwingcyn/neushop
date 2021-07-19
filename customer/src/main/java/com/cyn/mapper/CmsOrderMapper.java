package com.cyn.mapper;

import com.cyn.pojo.CmsCustomer;
import com.cyn.pojo.CmsOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cyn.pojo.OrderInformation;
import com.cyn.pojo.PmsProduct;
import feign.Param;

import java.util.List;

/**
 * <p>
 * 订单表 Mapper 接口
 * </p>
 *
 * @author giegie
 * @since 2021-07-12
 */
public interface CmsOrderMapper extends BaseMapper<CmsOrder> {
    public List<OrderInformation> getOrderList();
}
