package com.cyn.pojo;

import com.cyn.pojo.BasePojo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 状态表
 * </p>
 *
 * @author giegie
 * @since 2021-07-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CmsState extends BasePojo {

    private static final long serialVersionUID = 1L;

    /**
     * 状态名
     */
    private String stateName;


}
