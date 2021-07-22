package com.cyn.pojo;

import java.math.BigDecimal;
import com.cyn.pojo.BasePojo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author giegie
 * @since 2021-07-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CmsFootprint extends BasePojo {

    private static final long serialVersionUID = 1L;

    private Long productId;

    private Long customerId;

    private String img;

    private BigDecimal price;

    private Long isFc;


}
