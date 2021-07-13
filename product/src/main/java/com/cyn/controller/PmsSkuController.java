package com.cyn.controller;


import com.cyn.pojo.PmsSku;
import com.cyn.service.IPmsSkuService;
import com.cyn.util.ResultJson;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * sku属性表 前端控制器
 * </p>
 *
 * @author giegie
 * @since 2021-07-08
 */
@RestController
@CrossOrigin
@RequestMapping("/pms-sku")
public class PmsSkuController {
    @Resource
    IPmsSkuService skuService;
    @GetMapping("/list")
    ResultJson list(Long categoryId) {
        return ResultJson.success(skuService.list(categoryId));
    }
    @PostMapping("/add")
    ResultJson add(PmsSku pmsSku) {
        return ResultJson.success(skuService.save(pmsSku),"添加sku成功");
    }
    @GetMapping("/getone")
    ResultJson getone(Long id) {
        return ResultJson.success(skuService.getById(id));
    }
    @PostMapping("/update")
    ResultJson update(PmsSku pmsSku) {
        return ResultJson.success(skuService.updateById(pmsSku),"修改sku成功");
    }
    @PostMapping("/del")
    ResultJson del(Long id) {
        return ResultJson.success(skuService.removeById(id),"删除sku成功");
    }
}
