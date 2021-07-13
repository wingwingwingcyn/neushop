package com.cyn.pojo;

import com.cyn.pojo.BasePojo;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
     * 商品数量
     */
    private Integer productNum;

    /**
     * 是否有效
     */
    private Integer active;


}
