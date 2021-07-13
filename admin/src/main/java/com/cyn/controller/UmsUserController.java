package com.cyn.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cyn.pojo.UmsUser;
import com.cyn.service.IImgService;
import com.cyn.service.IUmsUserService;
import com.cyn.util.ResultJson;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.*;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.validation.constraints.Min;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author giegeie
 * @since 2021-06-29
 */
@RestController
@CrossOrigin
@RequestMapping("/ums-user")
public class UmsUserController {
    @Resource
    BCryptPasswordEncoder passwordEncoder;
    @Resource
    IUmsUserService umsUserService;
    @Resource
    IImgService imgService;
    @GetMapping("/list")
    ResultJson list(Integer pageNo, Integer pageSize ,String name) throws InterruptedException {
//        TimeUnit.SECONDS.sleep(1);
        return ResultJson.success(umsUserService.page(pageNo,pageSize,name)) ;
    }

    @PostMapping("/add")
    ResultJson add(UmsUser umsUser ,MultipartFile file) throws IOException , InvalidKeyException, InvalidResponseException, InsufficientDataException, NoSuchAlgorithmException, ServerException, InternalException, XmlParserException, InvalidBucketNameException, ErrorResponseException{
        umsUser.setPassword(passwordEncoder.encode(umsUser.getRawPassword()));
        umsUser.setIcon(imgService.upload(file));
        return ResultJson.success(umsUserService.save(umsUser),"添加用户成功");
    }

    @GetMapping("/getone")
    ResultJson getOne(Long id) {
        return ResultJson.success(umsUserService.getById(id));
    }

    @PostMapping("/update")
    ResultJson update(UmsUser umsUser, MultipartFile file) throws IOException, InvalidKeyException, InvalidResponseException, InsufficientDataException, NoSuchAlgorithmException, ServerException, InternalException, XmlParserException, InvalidBucketNameException, ErrorResponseException {
        if(file != null && file.getSize() > 0) {
            umsUser.setIcon(imgService.upload(file));
        }
        return ResultJson.success(umsUserService.updateById(umsUser),"修改用户成功");
    }

    @PostMapping("/del")
    ResultJson del(UmsUser umsUser) {
        String message = umsUser.getActive() == 0 ? "删除用户成功" : "恢复用户成功";
        return ResultJson.success(umsUserService.updateById(umsUser),message);
    }

    @PostMapping("/login")
    ResultJson login(String username, String password) throws Exception {
        return ResultJson.success(umsUserService.login(username, password),"登录成功");
    }

}
