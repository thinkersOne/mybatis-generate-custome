package com.baomidou.mybatisplus.samples.generator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.samples.generator.generate.custome.CustomeAutoGenerator;
import com.baomidou.mybatisplus.samples.generator.generate.custome.CustomeFreemarkerTemplateEngine;
import com.baomidou.mybatisplus.samples.generator.generate.custome.CustomePackageConfig;
import com.baomidou.mybatisplus.samples.generator.generate.custome.CustomeTemplateConfig;
import com.baomidou.mybatisplus.samples.generator.generate.model.GenerateModel;

/**
 * <p>
 * mysql 代码生成器演示例子
 * </p>
 *
 * @author jobob
 * @since 2018-09-12
 */
public class MysqlGenerator {
    /**
     * 生成 service 和 controller 代码
     * @param generateModel
     */
    public static void generate(GenerateModel generateModel){
        // 代码生成器
//        AutoGenerator mpg = new AutoGenerator();
        CustomeAutoGenerator mpg = new CustomeAutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(generateModel.getOutputDir());
        gc.setAuthor(generateModel.getAuthor());
        gc.setOpen(false);
        mpg.setGlobalConfig(gc);
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/springboot?useUnicode=true&serverTimezone=GMT&useSSL=false&characterEncoding=utf8");
        // dsc.setSchemaName("public");
//        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        mpg.setDataSource(dsc);

        // 包配置
        CustomePackageConfig pc = new CustomePackageConfig();
        pc.setEntity(generateModel.getEntityParentPackageName());
        pc.setModuleName(generateModel.getModuleName());
        pc.setParent(generateModel.getParentPackage());
        pc.setDaoExt(generateModel.getDaoExtPackageName());
        pc.setMapperExt(generateModel.getMapperExtPath());
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        // mapper.xml文件
//        List<FileOutConfig> focList = new ArrayList<>();
//        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输入文件名称
//                return generateModel.getMapperPath() + pc.getModuleName()
//                        + "/" + tableInfo.getEntityName() + "MapperExt" + StringPool.DOT_XML;
//            }
//        });
//        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        //配置自定义模板
        TemplateConfig templateConfig = new TemplateConfig();
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategy.setSuperEntityClass("com.baomidou.mybatisplus.samples.generator.common.BaseEntity");
        strategy.setEntityLombokModel(true);
//        strategy.setSuperControllerClass("com.baomidou.mybatisplus.samples.generator.common.BaseController");
        strategy.setInclude(generateModel.getTableNames());//表名，多个用逗号分割
        strategy.setSuperEntityColumns("id");
        strategy.setRestControllerStyle(true);
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        // 选择 freemarker 引擎需要指定如下加，注意 pom 依赖必须有！
        mpg.setCustomeTemplateEngine(new CustomeFreemarkerTemplateEngine());
        mpg.execute();
    }

    /**
     * RUN THIS
     */
    public static void main(String[] args) {
        GenerateModel generateModel = new GenerateModel();
        String projectPath = System.getProperty("user.dir");
        generateModel.setOutputDir(projectPath + "/src/main/java");
        generateModel.setAuthor("lizhihao");
        generateModel.setModuleName("user");
        generateModel.setParentPackage("com.baomidou.mybatisplus.samples.generator");
        generateModel.setMapperPath(projectPath + "/src/main/resources/mapper/");
        generateModel.setTableNames("user_log");
        //生成 mapperExt 地址
        generateModel.setMapperExtPath("mapperExt");
        // entity 所在包的名称
        generateModel.setEntityParentPackageName("model");
        // daoExt 所在包名
        generateModel.setDaoExtPackageName("daoExt");
//        generateModel.setServiceTemplateName("/templates/service.java");
        generate(generateModel);
    }

}
