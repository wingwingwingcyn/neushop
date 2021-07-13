package com.cyn.controller;


import com.cyn.pojo.PmsCategory;
import com.cyn.service.IPmsCategoryService;
import com.cyn.util.ResultJson;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 分类表 前端控制器
 * </p>
 *
 * @author giegie
 * @since 2021-07-07
 */
@RestController
@CrossOrigin
@RequestMapping("/pms-category")
public class PmsCategoryController {
    @Resource
    IPmsCategoryService categoryService;
    @GetMapping("/list")
    ResultJson list() {
        return ResultJson.success(categoryService.getByParentId(0L));
    }
    @PostMapping("/add")
    ResultJson add(PmsCategory pmsCategory) {
        return ResultJson.success(categoryService.save(pmsCategory),"添加分类成功");
    }
    @GetMapping("/getone")
    ResultJson getone(Long id) {
        return ResultJson.success(categoryService.getById(id));
    }
    @PostMapping("/update")
    ResultJson update(PmsCategory pmsCategory) {
        return ResultJson.success(categoryService.updateById(pmsCategory),"修改分类成功");
    }
    @PostMapping("/del")
    ResultJson del(PmsCategory pmsCategory) {
        String message = pmsCategory.getActive() == 0 ? "删除分类成功" : "恢复分类成功";
        return ResultJson.success(categoryService.updateById(pmsCategory),message);
    }
}
