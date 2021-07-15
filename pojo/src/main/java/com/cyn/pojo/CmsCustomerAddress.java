package com.cyn.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.cyn.pojo.BasePojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 顾客地址表
 * </p>
 *
 * @author YanMin zhang
 * @since 2021-07-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class CmsCustomerAddress extends BasePojo {

    private static final long serialVersionUID = 1L;

    /**
     * 客户id
     */
    private Long customerId;

    /**
     * 地址
     */
    private String address;

    /**
     * 收件人
     */
    private String name;

    /**
     * 收件电话
     */
    private String tel;

    /**
     * 邮政编码
     */
    private String postalCode;

    /**
     * 是否为默认
     */
    private Integer isDefault;
}
