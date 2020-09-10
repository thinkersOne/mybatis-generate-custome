package com.baomidou.mybatisplus.samples.generator.generate.custome;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableField;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class CustomeAutoGenerator extends AutoGenerator {
    private static final Logger logger = LoggerFactory.getLogger(CustomeAutoGenerator.class);
    protected CustomeConfigBuilder config;
    protected CustomeInjectionConfig injectionConfig;
//    private DataSourceConfig dataSource;
//    private StrategyConfig strategy;
    private CustomePackageConfig packageInfo;
    private CustomeTemplateConfig template;
//    private GlobalConfig globalConfig;
    private CustomeAbstractTemplateEngine templateEngine;

    public void execute() {
        logger.debug("==========================准备生成文件...==========================");
        if (null == this.config) {
            this.config = new CustomeConfigBuilder(this.packageInfo,
                    super.getDataSource(),super.getStrategy(),this.template,super.getGlobalConfig());
            if (null != this.injectionConfig) {
                this.injectionConfig.setConfig(this.config);
            }
        }
        if (null == this.templateEngine) {
            this.templateEngine = new CustomeAbstractTemplateEngine();
        }
        this.templateEngine.init(this.pretreatmentConfigBuilder(this.config)).mkdirs().batchOutput().open();
        logger.debug("==========================文件生成完成！！！==========================");
    }

    public CustomeAutoGenerator setTemplate(final CustomeTemplateConfig template) {
        this.template = template;
        return this;
    }

    public CustomeAutoGenerator setCustomeTemplateEngine(final CustomeAbstractTemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
        return this;
    }

    public void setConfig(CustomeConfigBuilder config) {
        this.config = config;
    }

    public CustomeInjectionConfig getInjectionConfig() {
        return injectionConfig;
    }

    public void setInjectionConfig(CustomeInjectionConfig injectionConfig) {
        this.injectionConfig = injectionConfig;
    }

    @Override
    public AbstractTemplateEngine getTemplateEngine() {
        return templateEngine;
    }

    public void setTemplateEngine(CustomeAbstractTemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    protected List<CustomeTableInfo> getAllTableInfoList(CustomeConfigBuilder config) {
        return config.getTableInfoList();
    }

    protected CustomeConfigBuilder pretreatmentConfigBuilder(CustomeConfigBuilder config) {
        if (null != this.injectionConfig) {
            this.injectionConfig.initMap();
            config.setInjectionConfig(this.injectionConfig);
        }
        List<CustomeTableInfo> tableList = this.getAllTableInfoList(config);
        Iterator var3 = tableList.iterator();
        while(var3.hasNext()) {
            CustomeTableInfo tableInfo = (CustomeTableInfo)var3.next();
            if (config.getGlobalConfig().isActiveRecord()) {
                tableInfo.setImportPackages(Model.class.getCanonicalName());
            }
            if (tableInfo.isConvert()) {
                tableInfo.setImportPackages(TableName.class.getCanonicalName());
            }

            if (config.getStrategyConfig().getLogicDeleteFieldName() != null && tableInfo.isLogicDelete(config.getStrategyConfig().getLogicDeleteFieldName())) {
                tableInfo.setImportPackages(TableLogic.class.getCanonicalName());
            }

            if (StringUtils.isNotBlank(config.getStrategyConfig().getVersionFieldName())) {
                tableInfo.setImportPackages(Version.class.getCanonicalName());
            }

            boolean importSerializable = true;
            if (StringUtils.isNotBlank(config.getSuperEntityClass())) {
                tableInfo.setImportPackages(config.getSuperEntityClass());
                importSerializable = false;
            }

            if (config.getGlobalConfig().isActiveRecord()) {
                importSerializable = true;
            }

            if (importSerializable) {
                tableInfo.setImportPackages(Serializable.class.getCanonicalName());
            }

            if (config.getStrategyConfig().isEntityBooleanColumnRemoveIsPrefix() && CollectionUtils.isNotEmpty(tableInfo.getFields())) {
                List<TableField> tableFields = (List)tableInfo.getFields().stream().filter((field) -> {
                    return "boolean".equalsIgnoreCase(field.getPropertyType());
                }).filter((field) -> {
                    return field.getPropertyName().startsWith("is");
                }).collect(Collectors.toList());
                tableFields.forEach((field) -> {
                    if (field.isKeyFlag()) {
                        tableInfo.setImportPackages(TableId.class.getCanonicalName());
                    } else {
                        tableInfo.setImportPackages(com.baomidou.mybatisplus.annotation.TableField.class.getCanonicalName());
                    }
                    field.setConvert(true);
                    field.setPropertyName(StringUtils.removePrefixAfterPrefixToLower(field.getPropertyName(), 2));
                });
            }
        }
        return config.setTableInfoList(tableList);
    }

}
