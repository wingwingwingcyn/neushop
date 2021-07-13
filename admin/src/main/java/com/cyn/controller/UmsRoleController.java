package com.cyn.controller;


import com.cyn.pojo.UmsRole;
import com.cyn.pojo.UmsUser;
import com.cyn.service.IUmsRoleService;
import com.cyn.util.ResultJson;
import io.minio.errors.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author giegie
 * @since 2021-07-02
 */
@RestController
@CrossOrigin
@RequestMapping("/ums-role")
public class UmsRoleController {
    @Resource
    IUmsRoleService roleService;

    @GetMapping("/list")
    ResultJson list(String name){
        return ResultJson.success(roleService.list(name));
    }

    @PostMapping("/add")
    ResultJson add(UmsRole umsRole){
        return ResultJson.success(roleService.save(umsRole),"添加用户成功");
    }

    @GetMapping("/getone")
    ResultJson getOne(Long id) {
        return ResultJson.success(roleService.getById(id));
    }

    @PostMapping("/update")
    ResultJson update(UmsRole umsRole){
        return ResultJson.success(roleService.updateById(umsRole),"修改角色成功");
    }

    @PostMapping("/del")
    ResultJson del(UmsRole umsRole) {
        String message = umsRole.getActive() == 0 ? "删除用户成功" : "恢复用户成功";
        return ResultJson.success(roleService.updateById(umsRole),message);
    }


}
