package com.cyn.controller;


import com.cyn.mapper.CmsFootprintMapper;
import com.cyn.pojo.CmsFootprint;
import com.cyn.service.ICmsFootprintService;
import com.cyn.service.impl.CmsFootprintServiceImpl;
import com.cyn.util.ResultJson;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author giegie
 * @since 2021-07-21
 */
@RestController
@CrossOrigin
@RequestMapping("/cms-footprint")
public class CmsFootprintController {
    @Resource
    ICmsFootprintService footprintService;
    @Resource
    CmsFootprintMapper footprintMapper;


    @GetMapping("/list")
    ResultJson list(Long customerId){
        return ResultJson.success(footprintService.getFootprint(customerId));
    }

    @GetMapping("/listCollection")
    ResultJson listCollection(Long customerId){
        return ResultJson.success(footprintService.getCollection(customerId));
    }

    @RequestMapping("/delAll")
    ResultJson delAll(Long customerId) {
        footprintMapper.delAll(customerId);
        return ResultJson.success("删除所有商品足迹成功");
    }

    @RequestMapping("/delAllCollection")
    ResultJson delAllCollection(Long customerId) {
        footprintMapper.delAllCollection(customerId);
        return ResultJson.success("删除所有收藏商品成功");
    }
    @GetMapping("/addfootprint")
    ResultJson add(Long productId, Long customerId, String img, BigDecimal price){
        CmsFootprint cmsFootprint = footprintService.idExist(productId, customerId);
        if (cmsFootprint == null){
            CmsFootprint fp = new CmsFootprint();
            fp.setProductId(productId);
            fp.setCustomerId(customerId);
            fp.setImg(img);
            fp.setPrice(price);
            footprintService.save(fp);
        }else {
            System.out.println(productId);
        }

        return ResultJson.success(1);
    }
    @GetMapping("/getCollection")
    ResultJson getCollection(Long customerId){
        return ResultJson.success(footprintService.getCollection(customerId));
    }
    @GetMapping("/isCollection")
    ResultJson isCollection(Long customerId,Long productId){
        return ResultJson.success(footprintService.isCollection(customerId, productId));
    }
    @GetMapping("/getFootPrint")
    ResultJson getFootPrint(Long produId){
        return ResultJson.success(footprintService.getFootPrint(produId));
    }
    @PostMapping("/setCollection")
    ResultJson setCollection(Long customerId,Long productId,Long isFc){
        CmsFootprint cmsFootprint = footprintService.idExist(productId, customerId);
        System.out.println(cmsFootprint);
        if (isFc == 0){
            cmsFootprint.setIsFc(1L);
        }else if (isFc == 1){
            cmsFootprint.setIsFc(0L);
        }
        return ResultJson.success(footprintService.updateById(cmsFootprint), "修改收藏成功");
    }
}
