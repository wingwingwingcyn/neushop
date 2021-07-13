package com.cyn.pojo;

import java.math.BigDecimal;
import com.cyn.pojo.BasePojo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author giegie
 * @since 2021-07-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CmsOrder extends BasePojo {

    private static final long serialVersionUID = 1L;

    /**
     * 客户id
     */
    private Long customerId;

    /**
     * 地址id
     */
    private Long addressId;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 订单状态
     */
    private Integer stateId;


}
