package com.cyn.pojo;

import com.cyn.pojo.BasePojo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * <p>
 * 顾客购物车表
 * </p>
 *
 * @author giegie
 * @since 2021-07-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CmsShoppingCart extends BasePojo {

    private static final long serialVersionUID = 1L;

    /**
     * 客户id
     */
    private Long customerId;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品数量
     */
    private Integer productNum;

    /**
     * 商品详情
     */
    private String detail;

    /**
     * 商品图片
     */
    private String img;

    /**
     * 是否有效
     */
    private Integer active;


}
