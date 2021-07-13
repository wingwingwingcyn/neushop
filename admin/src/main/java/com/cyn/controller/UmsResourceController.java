package com.cyn.controller;


import com.cyn.service.IUmsResourceService;
import com.cyn.util.ResultJson;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 资源表 前端控制器
 * </p>
 *
 * @author giegie
 * @since 2021-07-06
 */
@RestController
@CrossOrigin
@RequestMapping("/ums-resource")
public class UmsResourceController {
    @Resource
    IUmsResourceService resourceService;
    @GetMapping("/list")
    ResultJson list() {
        return ResultJson.success(resourceService.getResource(0L));
    }
}
