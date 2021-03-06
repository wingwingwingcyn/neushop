package com.cyn.pojo;

import com.cyn.pojo.BasePojo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * sku属性表
 * </p>
 *
 * @author giegie
 * @since 2021-07-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PmsSku extends BasePojo {

    private static final long serialVersionUID = 1L;

    /**
     * 关联类别
     */
    private Long categoryId;

    /**
     * 属性名称
     */
    private String name;

    /**
     * 选择列表
     */
    private String inputList;

    /**
     * 是否允许手动添加
     */
    private Integer addType;


}
