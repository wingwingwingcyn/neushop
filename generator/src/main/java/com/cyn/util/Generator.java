package com.cyn.util;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.cyn.pojo.BasePojo;

import java.util.HashMap;
import java.util.Map;

public class Generator {
    public static void main(String[] args) {
        // 构建代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 构建配置器
        GlobalConfig gc = new GlobalConfig();
        gc.setAuthor("giegie");
        // 定义项目路径
        String path = System.getProperty("user.dir");
        mpg.setGlobalConfig(gc);
        // 定义pojo路径
        String pojopath = path + "/pojo";
        String othenpath = path + "/product";
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://192.168.80.128:3306/shop?useUnicode=true&useSSL=false&characterEncoding=utf8");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        mpg.setDataSource(dsc);
        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.cyn");
        pc.setEntity("pojo");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setController("controller");
        Map<String,String> pathInfo = new HashMap<>();
        pathInfo.put("xml_path",othenpath + "/src/main/resources/com/cyn/mapper");
        pathInfo.put("entity_path",pojopath + "/src/main/java/com/cyn/pojo");
        pathInfo.put("mapper_path",othenpath + "/src/main/java/com/cyn/mapper");
        pathInfo.put("service_path",othenpath + "/src/main/java/com/cyn/service");
        pathInfo.put("service_impl_path",othenpath + "/src/main/java/com/cyn/service/impl");
        pathInfo.put("controller_path",othenpath + "/src/main/java/com/cyn/controller");
        pc.setPathInfo(pathInfo);
        mpg.setPackageInfo(pc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass(BasePojo.class);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // 公共父类

        // 写于父类中的公共字段
        strategy.setSuperEntityColumns("id");
        strategy.setInclude("pms_add_cart");
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        // 生成代码
        mpg.execute();
    }
}
