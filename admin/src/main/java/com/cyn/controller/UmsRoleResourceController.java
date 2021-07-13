package com.cyn.controller;


import com.cyn.service.IUmsResourceService;
import com.cyn.service.IUmsRoleResourceService;
import com.cyn.util.ResultJson;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 角色关联资源 前端控制器
 * </p>
 *
 * @author giegie
 * @since 2021-07-06
 */
@RestController
@CrossOrigin
@RequestMapping("/ums-role-resource")
public class UmsRoleResourceController {
    @Resource
    IUmsResourceService resourceService;
    @Resource
    IUmsRoleResourceService roleResourceService;
    @GetMapping("/getData")
    ResultJson getData(Long roleId) {
        Map<String,Object> map = new HashMap<>();
        map.put("resources",resourceService.getResource(0L));
        map.put("values",roleResourceService.getByRoleId(roleId));
        map.put("last",resourceService.getLast());
        return ResultJson.success(map);
    }
    @PostMapping("/save")
    ResultJson save(Long roleId, Long[] resourceIds) {
        return ResultJson.success(roleResourceService.save(roleId,resourceIds),"关联资源成功");
    }
}
