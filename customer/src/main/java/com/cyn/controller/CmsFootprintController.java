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
    ResultJson list(Integer customerId){
        return ResultJson.success(footprintService.getFootprint(customerId));
    }

    @GetMapping("/listCollection")
    ResultJson listCollection(Integer customerId){
        return ResultJson.success(footprintService.getCollections(customerId));
    }

    @RequestMapping("/delAll")
    ResultJson delAll(Integer customerId) {
        footprintMapper.delAll(customerId);
        return ResultJson.success("删除所有商品足迹成功");
    }

    @RequestMapping("/delAllCollection")
    ResultJson delAllCollection(Integer customerId) {
        footprintMapper.delAllCollection(customerId);
        return ResultJson.success("删除所有收藏商品成功");
    }
    @GetMapping("/addfootprint")
    ResultJson add(Integer productId, Integer customerId, String img, BigDecimal price){
        CmsFootprint fp = new CmsFootprint();
        fp.setProductId(productId);
        fp.setCustomerId(customerId);
        fp.setImg(img);
        fp.setPrice(price);
        return ResultJson.success(footprintService.save(fp));
    }
    @GetMapping("/getCollection")
    ResultJson getCollection(Integer proID, Long isFP){
        return ResultJson.success(footprintService.getCollection(proID,isFP));
    }
    @GetMapping("/getFootPrint")
    ResultJson getFootPrint(Integer produId){
        return ResultJson.success(footprintService.getFootPrint(produId));
    }


    @PostMapping("/setCollection")
    ResultJson setCollection(Long collOneId, Long collTwoId){
        if (collOneId != 0){
            System.out.println(collOneId);
            return ResultJson.success(footprintService.removeById(collOneId), "取消收藏成功");
        }else {
            CmsFootprint co = footprintService.getById(collTwoId);
            co.setIsFc(1L);
            return ResultJson.success(footprintService.save(co), "添加收藏成功");
        }
    }
}
