package com.cyn.pojo;

import java.math.BigDecimal;
import com.cyn.pojo.BasePojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
@AllArgsConstructor
@NoArgsConstructor
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

    /**
     * 商品数量
     */
    private Integer productNum;

    /**
     * 商品详情
     */
    private String detail;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品图片
     */
    private String img;

}
