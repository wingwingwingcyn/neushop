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

    @PostMapping("/updatePwd")
    ResultJson updatePwd(Long id,String password,String newPassword) throws IOException, InvalidKeyException, InvalidResponseException, InsufficientDataException, NoSuchAlgorithmException, ServerException, InternalException, XmlParserException, InvalidBucketNameException, ErrorResponseException {
        UmsUser umsUser=umsUserService.getById(id);
        String oldPwd=umsUser.getPassword();
        System.out.println(umsUser);
        System.out.println(id);
        System.out.println(oldPwd+"==========="+password+"================"+newPassword);
        if(null==newPassword  || null==password || oldPwd==passwordEncoder.encode(newPassword)){
            return ResultJson.error("新密码与原密码相同，请重新输入");
        }else if (!passwordEncoder.matches(password,oldPwd)){
            return ResultJson.error("密码不一致，请重新输入");
        }else{
            umsUser.setPassword(passwordEncoder.encode(newPassword));
            return ResultJson.success(umsUserService.updateById(umsUser),"修改用户密码成功，请重新登录");
        }
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
