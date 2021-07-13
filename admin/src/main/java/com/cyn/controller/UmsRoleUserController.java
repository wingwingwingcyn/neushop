package com.cyn.controller;


import com.cyn.service.IUmsRoleUserService;
import com.cyn.service.IUmsUserService;
import com.cyn.util.ResultJson;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 角色与用户关联表 前端控制器
 * </p>
 *
 * @author giegie
 * @since 2021-07-02
 */
@RestController
@CrossOrigin
@RequestMapping("/ums-role-user")
public class UmsRoleUserController {
    @Resource
    IUmsUserService umsUserService;
    @Resource
    IUmsRoleUserService roleUserService;
    @GetMapping("/getData")
    ResultJson getData(Long roleId){
        Map<String, Object> map=new HashMap<>();
        map.put("users",umsUserService.getAll());
        map.put("values",roleUserService.getUsersByRoleId(roleId));
        return ResultJson.success(map);
    }

    @PostMapping("/save")
    ResultJson save(Long roleId ,Long[] userIds){
        return ResultJson.success(roleUserService.save(roleId,userIds),"角色与用户关联成功");
    }
}
