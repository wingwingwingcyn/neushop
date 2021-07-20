package com.cyn.controller;


import com.cyn.pojo.CmsCustomer;
import com.cyn.service.ICmsCustomerService;
import com.cyn.util.ResultJson;
import io.minio.errors.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author giegie
 * @since 2021-07-12
 */

@RestController
@CrossOrigin
@RequestMapping("/cms-customer")
public class CmsCustomerController {
    @Resource
    ICmsCustomerService cmsCustomerService;
    @Resource
    BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/list")
    ResultJson list() throws InterruptedException {
//        TimeUnit.SECONDS.sleep(1);
        List<CmsCustomer> cmsCustomerList=cmsCustomerService.getAll();
        System.out.println(cmsCustomerList);
        return ResultJson.success(cmsCustomerService.getAll()) ;
    }

    @RequestMapping("/login")
    ResultJson login(String account, String password) throws Exception {
        return ResultJson.success(cmsCustomerService.login(account, password),"登录成功");
    }

//    @PostMapping("/add")
//    ResultJson add(CmsCustomer cmsCustomer) throws IOException, InvalidKeyException, InvalidResponseException, InsufficientDataException, NoSuchAlgorithmException, ServerException, InternalException, XmlParserException, InvalidBucketNameException, ErrorResponseException{
//        cmsCustomer.setPassword(passwordEncoder.encode(cmsCustomer.getRawPassword()));
//        return ResultJson.success(cmsCustomerService.save(cmsCustomer),"添加用户成功");
//    }

    @RequestMapping("/add")
    ResultJson add(String account,String nickyName,String sex,String password,String phone) throws IOException, InvalidKeyException, InvalidResponseException, InsufficientDataException, NoSuchAlgorithmException, ServerException, InternalException, XmlParserException, InvalidBucketNameException, ErrorResponseException{
        CmsCustomer cmsCustomer=new CmsCustomer();
        cmsCustomer.setAccount(account);
        cmsCustomer.setPhone(phone);
        cmsCustomer.setSex(sex);
        cmsCustomer.setNickyName(nickyName);
        cmsCustomer.setPassword(passwordEncoder.encode(password));
        System.out.println(cmsCustomer);
        return ResultJson.success(cmsCustomerService.save(cmsCustomer),"添加用户成功");
    }

    @GetMapping("/getone")
    ResultJson getOne(Long id) {
        return ResultJson.success(cmsCustomerService.getById(id));
    }

    @RequestMapping("/update")
    ResultJson update(Long id,String account,String nickyName,String sex,String password,String phone){
        CmsCustomer cmsCustomer=cmsCustomerService.getById(id);
        cmsCustomer.setAccount(account);
        cmsCustomer.setPhone(phone);
        cmsCustomer.setSex(sex);
        cmsCustomer.setNickyName(nickyName);
        return ResultJson.success(cmsCustomerService.updateById(cmsCustomer),"修改用户成功");
    }

    @RequestMapping("/editPwd")
    ResultJson update(Long id,String password,String password1){
        CmsCustomer cmsCustomer=cmsCustomerService.getById(id);
        System.out.println("===--------------------------==="+password);
        System.out.println("===--------------------------==="+password1);

        if(null==password1  || null==password || cmsCustomer.getPassword()==passwordEncoder.encode(password1)){
            return ResultJson.error("新密码不正确");
        }else if (!passwordEncoder.matches(password,cmsCustomer.getPassword())){
            return ResultJson.error("密码错误");
        }else{
            cmsCustomer.setPassword(passwordEncoder.encode(password1));
            return ResultJson.success(cmsCustomerService.updateById(cmsCustomer),"修改用户密码成功");
        }
    }

    @PostMapping("/del")
    ResultJson del(CmsCustomer cmsCustomer) {
        String message = cmsCustomer.getActive() == 0 ? "删除用户成功" : "恢复用户成功";
        return ResultJson.success(cmsCustomerService.updateById(cmsCustomer),message);
    }
}
