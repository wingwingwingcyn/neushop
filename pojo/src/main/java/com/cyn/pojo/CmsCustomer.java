package com.cyn.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.cyn.pojo.BasePojo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
@NoArgsConstructor
@AllArgsConstructor
public class CmsCustomer extends BasePojo {

    private static final long serialVersionUID = 1L;

    /**
     * 账户
     */
    private String account;

    /**
     * 昵称
     */
    private String nickyName;

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

    /**
     * 密码明文
     * */
    @TableField(exist = false)
    @JsonIgnore
    private String rawPassword;
}
