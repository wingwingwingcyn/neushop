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
public class OrderInformation extends BasePojo {
    /**
     * 客户id
     */
    private Long id;
    /**
     * 客户id
     */
    private Long customerId;

    /**
     * 账户
     */
    private String account;

    /**
     * 昵称
     */
    private String nickyName;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 标准价格
     */
    private BigDecimal price;

    /**
     * 订单状态
     */
    private Integer stateId;

    /**
     * 订单状态
     */
    private String stateName;
}
