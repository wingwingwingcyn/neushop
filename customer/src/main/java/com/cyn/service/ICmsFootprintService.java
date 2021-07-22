package com.cyn.service;

import com.cyn.pojo.CmsFootprint;
import com.baomidou.mybatisplus.extension.service.IService;

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
    List<CmsFootprint> getFootprint(Integer customerId);
    List<CmsFootprint> getCollections(Integer customerId);
//    List<CmsFootprint> delAll(Integer customerId);
    CmsFootprint getCollection(Integer proID, Long isFP);
    List<CmsFootprint> getFootPrint(Integer produId);
}
