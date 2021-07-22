package com.cyn.service;

import com.cyn.pojo.CmsFootprint;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cyn.pojo.CmsShoppingCart;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author giegie
 * @since 2021-07-21
 */
public interface ICmsFootprintService extends IService<CmsFootprint> {
    List<CmsFootprint> getFootprint(Long customerId);
    List<CmsFootprint> getCollection(Long customerId);
//    List<CmsFootprint> delAll(Integer customerId);
    List<CmsFootprint> getFootPrint(Long produId);
    Long isCollection(Long customerId, Long productId);
    CmsFootprint idExist(Long productId, Long customerId);
}
