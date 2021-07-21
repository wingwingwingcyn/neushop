package com.cyn.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cyn.pojo.PmsProduct;
import com.cyn.pojo.PmsSkuValue;
import com.cyn.pojo.PmsSpuValue;
import com.cyn.pojo.PmsStock;
import com.cyn.service.*;
import com.cyn.util.ResultJson;
import org.apache.commons.lang3.StringUtils;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品表 前端控制器
 * </p>
 *
 * @author giegie
 * @since 2021-07-08
 */
@RestController
@CrossOrigin
@RequestMapping("/pms-product")
public class PmsProductController {
    @Resource
    IPmsProductService productService;
    @Resource
    IPmsBrandService brandService;
    @Resource
    IPmsCategoryService categoryService;
    @Resource
    IPmsSpuService spuService;
    @Resource
    IPmsSkuService skuService;
    @Resource
    AdminService adminService;
    @Resource
    IPmsSpuValueService spuValueService;
    @Resource
    IPmsSkuValueService skuValueService;
    @Resource
    IPmsStockService stockService;

    @GetMapping("/list")
    ResultJson list(Integer pageNo, Integer pageSize) {
        return ResultJson.success(productService.page(new Page<>(pageNo,pageSize)));
    }

    @GetMapping("/getall")
    ResultJson getall(){
        return ResultJson.success(productService.list());
    }

    @GetMapping("/getProductByName")
    ResultJson getpbyname(String name){
        return ResultJson.success(productService.list(name));
    }

    @GetMapping("/getData")
    ResultJson getData() {
        Map<String, List> map = new HashMap<>();
        map.put("brands",brandService.getAll());
        map.put("categorys",categoryService.getAll(0L));
        return ResultJson.success(map);
    }

    @GetMapping("/getByCategory")
    ResultJson getcate(Long categoryId){
        return ResultJson.success(productService.list2(categoryId));
    }

    @GetMapping("/getAttr")
    ResultJson getAttr(Long[] categoryIds) {
        Map<String,List> map = new HashMap<>();
        map.put("spus",spuService.getByCategory(categoryIds));
        map.put("skus",skuService.getByCategory(categoryIds));
        return ResultJson.success(map);
    }


    @GetMapping("/getProductById")
    ResultJson getProductById(Long productId){
        return ResultJson.success(productService.getById(productId));
    }

    @GetMapping("/getSkuValueByProductId")
    ResultJson getSkuValueByProductId(Long productId){
        return ResultJson.success(skuValueService.skuValueList(productId));
    }

    @GetMapping("/getSpuValueByProductId")
    ResultJson getSpuValueByProductId(Long productId){
        return ResultJson.success(spuValueService.spuValueList(productId));
    }

    @GetMapping("/getStockByProductId")
    ResultJson getStockByProductId(Long productId){
        return ResultJson.success(stockService.stockList(productId));
    }


    //把skuValue里面的value由字符串转化为数组
    @GetMapping("/getSkuValueAsList")
    ResultJson getSkuValueAsList(Long productId){
        List<PmsSkuValue> pmsList = skuValueService.skuValueList(productId);
        List<String> string0 = new ArrayList<>();
        List<String> string1 = new ArrayList<>();
        String[] string = null;
        List<String> strings = new ArrayList<>();
        List<List> finalList = new ArrayList<>();

        //把value转化为数组存放,下面的步骤都是去除掉双引号、方框之类的
        for (int i = 0; i < pmsList.size(); i++){
            strings.add(StringUtils.strip(pmsList.get(i).getValue(),"[]"));
            string = strings.get(i).split(",");
            if (i == 0){
                for (int j = 0 ; j < string.length ; j++){
                    String s = string[j].replaceAll("\"","");
                    string0.add(s);
                }
            }else {
                for (int j = 0 ; j < string.length ; j++){
                    String s = string[j].replaceAll("\"","");
                    string1.add(s);
                }
            }
        }
        finalList.add(string0);
        finalList.add(string1);
        return ResultJson.success(finalList);
    }


    @PostMapping("/add")
    @Transactional
    ResultJson add(PmsProduct pmsProduct, MultipartFile file, MultipartFile[] files, String[] spus, String[] skus, String[] stocks) throws IOException {
        pmsProduct.setImg(adminService.upload(file));
        List<String> piclist = new ArrayList<>();
        for(MultipartFile f : files) {
            MultipartFile file2=new MockMultipartFile("file",f.getOriginalFilename(),f.getContentType(),f.getBytes());
            piclist.add(adminService.upload(file2));
        }
        pmsProduct.setPics(piclist.toString().replaceAll("\\[","").replaceAll("\\]",""));

        productService.save(pmsProduct);
        List<PmsSpuValue> spuValueList = new ArrayList<>();
        for(String spu : spus) {
            PmsSpuValue pmsSpuValue = JSONObject.parseObject(spu, PmsSpuValue.class);
            pmsSpuValue.setProductId(pmsProduct.getId());
            spuValueList.add(pmsSpuValue);
        }
        spuValueService.saveBatch(spuValueList);

        List<PmsSkuValue> skuValueList = new ArrayList<>();
        for(String sku : skus) {
            PmsSkuValue pmsSkuValue = JSONObject.parseObject(sku,PmsSkuValue.class);
            pmsSkuValue.setProductId(pmsProduct.getId());
            skuValueList.add(pmsSkuValue);
        }
        skuValueService.saveBatch(skuValueList);

        List<PmsStock> stockList = new ArrayList<>();
        for(String stock : stocks) {
            System.out.println(stock);
            PmsStock pmsStock = JSON.parseObject(stock, PmsStock.class);
            pmsStock.setProductId(pmsProduct.getId());
            stockList.add(pmsStock);
        }
        stockService.saveBatch(stockList);
        return ResultJson.success("","添加成功");
    }



}
