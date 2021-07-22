package com.cyn.controller;


import com.cyn.mapper.CmsFootprintMapper;
import com.cyn.service.ICmsFootprintService;
import com.cyn.service.impl.CmsFootprintServiceImpl;
import com.cyn.util.ResultJson;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
        return ResultJson.success(footprintService.getCollection(customerId));
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

}
