package com.cyn.pojo;

import com.cyn.pojo.BasePojo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author giegie
 * @since 2021-07-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CmsCustomer extends BasePojo {

    private static final long serialVersionUID = 1L;

    /**
     * 账户
     */
    private String customer;

    /**
     * 密码
     */
    private String password;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 性别
     */
    private String sex;

    /**
     * 是否有效
     */
    private Integer active;


}
