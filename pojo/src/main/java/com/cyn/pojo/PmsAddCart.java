package com.cyn.pojo;

import java.math.BigDecimal;
import com.cyn.pojo.BasePojo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 添加购物车表
 * </p>
 *
 * @author giegie
 * @since 2021-07-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PmsAddCart extends BasePojo {

    private static final long serialVersionUID = 1L;

    /**
     * 顾客ID
     */
    private Long customerId;

    /**
     * 商品ID
     */
    private Long productId;

    /**
     * 单价
     */
    private BigDecimal price;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 购买数量
     */
    private Integer productNum;

    /**
     * 商品图片
     */
    private String img;

    /**
     * 商品信息
     */
    private String detail;

    /**
     * 是否有效
     */
    private Integer active;


}
