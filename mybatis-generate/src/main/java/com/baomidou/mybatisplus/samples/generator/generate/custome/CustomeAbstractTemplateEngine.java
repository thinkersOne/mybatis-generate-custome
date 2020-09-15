package com.baomidou.mybatisplus.samples.generator.generate.custome;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.FileType;
import com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine;
import com.baomidou.mybatisplus.samples.generator.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CustomeAbstractTemplateEngine extends AbstractTemplateEngine {
    protected static final Logger logger = LoggerFactory.getLogger(CustomeAbstractTemplateEngine.class);
    private CustomeConfigBuilder configBuilder;

    public CustomeAbstractTemplateEngine init(CustomeConfigBuilder configBuilder) {
        this.configBuilder = configBuilder;
        return this;
    }


    @Override
    public void writer(Map<String, Object> objectMap, String templatePath, String outputFile) throws Exception {

    }

    @Override
    public String templateFilePath(String filePath) {
        return null;
    }

    public CustomeAbstractTemplateEngine mkdirs() {
        this.getCustomeConfigBuilder().getPathInfo().forEach((key, value) -> {
            File dir = new File(value);
            if (!dir.exists()) {
                boolean result = dir.mkdirs();
                if (result) {
                    logger.debug("创建目录： [" + value + "]");
                }
            }
        });
        return this;
    }

    public Map<String, Object> getObjectMap(TableInfo tableInfo) {
        CustomeConfigBuilder config = this.getCustomeConfigBuilder();
        HashMap objectMap;
        if (config.getStrategyConfig().isControllerMappingHyphenStyle()) {
            objectMap = CollectionUtils.newHashMapWithExpectedSize(33);
            objectMap.put("controllerMappingHyphenStyle", config.getStrategyConfig().isControllerMappingHyphenStyle());
            objectMap.put("controllerMappingHyphen", StringUtils.camelToHyphen(tableInfo.getEntityPath()));
        } else {
            objectMap = CollectionUtils.newHashMapWithExpectedSize(31);
        }
        objectMap.put("restControllerStyle", config.getStrategyConfig().isRestControllerStyle());
        objectMap.put("config", config);
        objectMap.put("package", config.getPackageInfo());
        GlobalConfig globalConfig = config.getGlobalConfig();
        objectMap.put("author", globalConfig.getAuthor());
        objectMap.put("idType", globalConfig.getIdType() == null ? null : globalConfig.getIdType().toString());
        objectMap.put("logicDeleteFieldName", config.getStrategyConfig().getLogicDeleteFieldName());
        objectMap.put("versionFieldName", config.getStrategyConfig().getVersionFieldName());
        objectMap.put("activeRecord", globalConfig.isActiveRecord());
        objectMap.put("kotlin", globalConfig.isKotlin());
        objectMap.put("swagger2", globalConfig.isSwagger2());
        objectMap.put("date", (new SimpleDateFormat("yyyy-MM-dd")).format(new Date()));
        objectMap.put("table", tableInfo);
        objectMap.put("enableCache", globalConfig.isEnableCache());
        objectMap.put("baseResultMap", globalConfig.isBaseResultMap());
        objectMap.put("baseColumnList", globalConfig.isBaseColumnList());
        objectMap.put("entity", tableInfo.getEntityName());
        objectMap.put("entitySerialVersionUID", config.getStrategyConfig().isEntitySerialVersionUID());
        objectMap.put("entityColumnConstant", config.getStrategyConfig().isEntityColumnConstant());
        objectMap.put("entityBuilderModel", config.getStrategyConfig().isEntityBuilderModel());
        objectMap.put("chainModel", config.getStrategyConfig().isChainModel());
        objectMap.put("entityLombokModel", config.getStrategyConfig().isEntityLombokModel());
        objectMap.put("entityBooleanColumnRemoveIsPrefix", config.getStrategyConfig().isEntityBooleanColumnRemoveIsPrefix());
        objectMap.put("superEntityClass", this.getSuperClassName(config.getSuperEntityClass()));
        objectMap.put("superMapperClassPackage", config.getSuperMapperClass());
        objectMap.put("superMapperClass", this.getSuperClassName(config.getSuperMapperClass()));
        objectMap.put("superServiceClassPackage", config.getSuperServiceClass());
        objectMap.put("superServiceClass", this.getSuperClassName(config.getSuperServiceClass()));
        objectMap.put("superServiceImplClassPackage", config.getSuperServiceImplClass());
        objectMap.put("superServiceImplClass", this.getSuperClassName(config.getSuperServiceImplClass()));
        objectMap.put("superControllerClassPackage", this.verifyClassPacket(config.getSuperControllerClass()));
        objectMap.put("superControllerClass", this.getSuperClassName(config.getSuperControllerClass()));
        return (Map)(Objects.isNull(config.getInjectionConfig()) ? objectMap : config.getInjectionConfig().prepareObjectMap(objectMap));
    }

    private String verifyClassPacket(String classPacket) {
        return StringUtils.isBlank(classPacket) ? null : classPacket;
    }

    private String getSuperClassName(String classPath) {
        return StringUtils.isBlank(classPath) ? null : classPath.substring(classPath.lastIndexOf(".") + 1);
    }

    public AbstractTemplateEngine batchOutput() {
        try {
            List<CustomeTableInfo> tableInfoList = this.getCustomeConfigBuilder().getTableInfoList();
            Iterator var2 = tableInfoList.iterator();
            while(var2.hasNext()) {
                CustomeTableInfo tableInfo = (CustomeTableInfo)var2.next();
                Map<String, Object> objectMap = this.getObjectMap(tableInfo);
                Map<String, String> pathInfo = this.getCustomeConfigBuilder().getPathInfo();
                CustomeTemplateConfig template = this.getCustomeConfigBuilder().getTemplate();
                CustomeInjectionConfig injectionConfig = this.getCustomeConfigBuilder().getInjectionConfig();
                if (null != injectionConfig) {
                    injectionConfig.initTableMap(tableInfo);
                    objectMap.put("cfg", injectionConfig.getMap());
                    List<FileOutConfig> focList = injectionConfig.getFileOutConfigList();
                    if (CollectionUtils.isNotEmpty(focList)) {
                        Iterator var9 = focList.iterator();
                        while(var9.hasNext()) {
                            FileOutConfig foc = (FileOutConfig)var9.next();
                            if (this.isCreate(FileType.OTHER, foc.outputFile(tableInfo))) {
                                this.writerFile(objectMap, foc.getTemplatePath(), foc.outputFile(tableInfo));
                            }
                        }
                    }
                }
                String entityName = tableInfo.getEntityName();
                String controllerFile;
                if (null != entityName && null != pathInfo.get("entity_path")) {
                    controllerFile = String.format((String)pathInfo.get("entity_path") + File.separator + "%s" + this.suffixJavaOrKt(), entityName);
                    if (this.isCreate(FileType.ENTITY, controllerFile)) {
                        this.writerFile(objectMap, this.templateFilePath(template.getEntity(this.getCustomeConfigBuilder().getGlobalConfig().isKotlin())), controllerFile);
                    }
                }
//                if (null != tableInfo.getMapperName() && null != pathInfo.get("mapper_path")) {
//                    controllerFile = String.format((String)pathInfo.get("mapper_path") + File.separator + tableInfo.getMapperName() + this.suffixJavaOrKt(), entityName);
//                    if (this.isCreate(FileType.MAPPER, controllerFile)) {
//                        this.writerFile(objectMap, this.templateFilePath(template.getMapper()), controllerFile);
//                    }
//                }
//                if (null != tableInfo.getXmlName() && null != pathInfo.get("xml_path")) {
//                    controllerFile = String.format((String)pathInfo.get("xml_path") + File.separator + tableInfo.getXmlName() + ".xml", entityName);
//                    if (this.isCreate(FileType.XML, controllerFile)) {
//                        this.writerFile(objectMap, this.templateFilePath(template.getXml()), controllerFile);
//                    }
//                }
                if (null != tableInfo.getServiceName() && null != pathInfo.get("service_path")) {
                    controllerFile = String.format((String)pathInfo.get("service_path") + File.separator + tableInfo.getServiceName() + this.suffixJavaOrKt(), entityName);
                    if (this.isCreate(FileType.SERVICE, controllerFile)) {
                        this.writerFile(objectMap, this.templateFilePath(template.getService()), controllerFile);
                    }
                }
//                if (null != tableInfo.getServiceImplName() && null != pathInfo.get("service_impl_path")) {
//                    controllerFile = String.format((String)pathInfo.get("service_impl_path") + File.separator + tableInfo.getServiceImplName() + this.suffixJavaOrKt(), entityName);
//                    if (this.isCreate(FileType.SERVICE_IMPL, controllerFile)) {
//                        this.writerFile(objectMap, this.templateFilePath(template.getServiceImpl()), controllerFile);
//                    }
//                }
                if (null != tableInfo.getControllerName() && null != pathInfo.get("controller_path")) {
                    controllerFile = String.format((String)pathInfo.get("controller_path") + File.separator + tableInfo.getControllerName() + this.suffixJavaOrKt(), entityName);
                    if (this.isCreate(FileType.CONTROLLER, controllerFile)) {
                        this.writerFile(objectMap, this.templateFilePath(template.getController()), controllerFile);
                    }
                }
                if (null != tableInfo.getControllerName() && null != pathInfo.get("daoExt_path")) {
                    controllerFile = String.format((String)pathInfo.get("daoExt_path") + File.separator + tableInfo.getDaoExtName() + this.suffixJavaOrKt(), entityName);
                    if (this.isCreate(FileType.OTHER, controllerFile)) {
                        this.writerFile(objectMap, this.templateFilePath(template.getDaoExt()), controllerFile);
                    }
                }
                if (null != tableInfo.getControllerName() && null != pathInfo.get("mapperExt_path")) {
                    controllerFile = String.format((String)pathInfo.get("mapperExt_path") + File.separator + tableInfo.getMapperExtName()  + ".xml", entityName);
                    if (this.isCreate(FileType.OTHER, controllerFile)) {
                        this.writerFile(objectMap, this.templateFilePath(template.getMapperExt()), controllerFile);
                    }
                }
                if (null != tableInfo.getControllerName() && null != pathInfo.get("enumErrorCode_path")) {
                    controllerFile = String.format((String)pathInfo.get("enumErrorCode_path") + File.separator +
                           "Enum" + tableInfo.getEntityName() + "ErrorCode" + ".java", entityName);
                    if (this.isCreate(FileType.OTHER, controllerFile)) {
                        this.writerFile(objectMap, this.templateFilePath(template.getEnumErrorCode()), controllerFile);
                    }
                }
                //设置swagger并生成swagger文件
                generateSwaggerFile(tableInfo, objectMap, pathInfo, template, entityName);
                // 生成angular文件
                generateAngularFile(tableInfo, objectMap, pathInfo, template, entityName);
            }
        } catch (Exception var11) {
            logger.error("无法创建文件，请检查配置信息！", var11);
        }
        return this;
    }

    private void generateAngularFile(CustomeTableInfo tableInfo, Map<String, Object> objectMap, Map<String, String> pathInfo, CustomeTemplateConfig template, String entityName) throws Exception {
        String controllerFile;
        if (null != tableInfo.getControllerName() && null != pathInfo.get("editHtml_path")) {
            controllerFile = String.format((String)pathInfo.get("editHtml_path") + File.separator
                    + StringUtil.getMiddleLineName(tableInfo.getName()) + "-edit.component"  + ".html", entityName);
            if (this.isCreate(FileType.OTHER, controllerFile)) {
                this.writerFile(objectMap, this.templateFilePath(template.getEditHtml()), controllerFile);
            }
        }
        if (null != tableInfo.getControllerName() && null != pathInfo.get("editTs_path")) {
            controllerFile = String.format((String)pathInfo.get("editTs_path") + File.separator
                    + StringUtil.getMiddleLineName(tableInfo.getName()) + "-edit.component"  + ".ts", entityName);
            if (this.isCreate(FileType.OTHER, controllerFile)) {
                this.writerFile(objectMap, this.templateFilePath(template.getEditTs()), controllerFile);
            }
        }
        if (null != tableInfo.getControllerName() && null != pathInfo.get("listCss_path")) {
            controllerFile = String.format((String)pathInfo.get("listCss_path") + File.separator
                    + StringUtil.getMiddleLineName(tableInfo.getName()) + ".component"  + ".css", entityName);
            if (this.isCreate(FileType.OTHER, controllerFile)) {
                this.writerFile(objectMap, this.templateFilePath(template.getListCss()), controllerFile);
            }
        }
        if (null != tableInfo.getControllerName() && null != pathInfo.get("listHtml_path")) {
            controllerFile = String.format((String)pathInfo.get("listHtml_path") + File.separator
                    + StringUtil.getMiddleLineName(tableInfo.getName()) + ".component"  + ".html", entityName);
            if (this.isCreate(FileType.OTHER, controllerFile)) {
                this.writerFile(objectMap, this.templateFilePath(template.getListHtml()), controllerFile);
            }
        }
        if (null != tableInfo.getControllerName() && null != pathInfo.get("listTs_path")) {
            controllerFile = String.format((String)pathInfo.get("listTs_path") + File.separator
                    + StringUtil.getMiddleLineName(tableInfo.getName()) + ".component"  + ".ts", entityName);
            if (this.isCreate(FileType.OTHER, controllerFile)) {
                this.writerFile(objectMap, this.templateFilePath(template.getListTs()), controllerFile);
            }
        }
        if (null != tableInfo.getControllerName() && null != pathInfo.get("serviceTs_path")) {
            controllerFile = String.format((String)pathInfo.get("serviceTs_path") + File.separator
                    + StringUtil.getMiddleLineName(tableInfo.getName()) + ".service"  + ".ts", entityName);
            if (this.isCreate(FileType.OTHER, controllerFile)) {
                this.writerFile(objectMap, this.templateFilePath(template.getServiceTs()), controllerFile);
            }
        }
        if (null != tableInfo.getControllerName() && null != pathInfo.get("existsCodeReqTs_path")) {
            controllerFile = String.format((String)pathInfo.get("existsCodeReqTs_path") + File.separator
                    + StringUtil.removeUnderLineName(tableInfo.getName()) + "ExistsCodeRequest"  + ".ts", entityName);
            if (this.isCreate(FileType.OTHER, controllerFile)) {
                this.writerFile(objectMap, this.templateFilePath(template.getExistsCodeReqTs()), controllerFile);
            }
        }
        if (null != tableInfo.getControllerName() && null != pathInfo.get("existsCodeResTs_path")) {
            controllerFile = String.format((String)pathInfo.get("existsCodeResTs_path") + File.separator
                    + StringUtil.removeUnderLineName(tableInfo.getName()) + "ExistsCodeResponse"  + ".ts", entityName);
            if (this.isCreate(FileType.OTHER, controllerFile)) {
                this.writerFile(objectMap, this.templateFilePath(template.getExistsCodeResTs()), controllerFile);
            }
        }
        if (null != tableInfo.getControllerName() && null != pathInfo.get("existsNameReqTs_path")) {
            controllerFile = String.format((String)pathInfo.get("existsNameReqTs_path") + File.separator
                    + StringUtil.removeUnderLineName(tableInfo.getName()) + "ExistsNameRequest"  + ".ts", entityName);
            if (this.isCreate(FileType.OTHER, controllerFile)) {
                this.writerFile(objectMap, this.templateFilePath(template.getExistsNameReqTs()), controllerFile);
            }
        }
        if (null != tableInfo.getControllerName() && null != pathInfo.get("existsNameResTs_path")) {
            controllerFile = String.format((String)pathInfo.get("existsNameResTs_path") + File.separator
                    + StringUtil.removeUnderLineName(tableInfo.getName()) + "ExistsNameResponse"  + ".ts", entityName);
            if (this.isCreate(FileType.OTHER, controllerFile)) {
                this.writerFile(objectMap, this.templateFilePath(template.getExistsNameResTs()), controllerFile);
            }
        }
        if (null != tableInfo.getControllerName() && null != pathInfo.get("getModelReqTs_path")) {
            controllerFile = String.format((String)pathInfo.get("getModelReqTs_path") + File.separator
                    + StringUtil.removeUnderLineName(tableInfo.getName()) + "GetModelRequest"  + ".ts", entityName);
            if (this.isCreate(FileType.OTHER, controllerFile)) {
                this.writerFile(objectMap, this.templateFilePath(template.getGetModelReqTs()), controllerFile);
            }
        }
        if (null != tableInfo.getControllerName() && null != pathInfo.get("getModelResTs_path")) {
            controllerFile = String.format((String)pathInfo.get("getModelResTs_path") + File.separator
                    + StringUtil.removeUnderLineName(tableInfo.getName()) + "GetModelResponse"  + ".ts", entityName);
            if (this.isCreate(FileType.OTHER, controllerFile)) {
                this.writerFile(objectMap, this.templateFilePath(template.getGetModelResTs()), controllerFile);
            }
        }
        if (null != tableInfo.getControllerName() && null != pathInfo.get("getPageReqTs_path")) {
            controllerFile = String.format((String)pathInfo.get("getPageReqTs_path") + File.separator
                    + StringUtil.removeUnderLineName(tableInfo.getName()) + "GetPageRequest"  + ".ts", entityName);
            if (this.isCreate(FileType.OTHER, controllerFile)) {
                this.writerFile(objectMap, this.templateFilePath(template.getGetPageReqTs()), controllerFile);
            }
        }
        if (null != tableInfo.getControllerName() && null != pathInfo.get("getPageResTs_path")) {
            controllerFile = String.format((String)pathInfo.get("getPageResTs_path") + File.separator
                    + StringUtil.removeUnderLineName(tableInfo.getName()) + "GetPageResponse"  + ".ts", entityName);
            if (this.isCreate(FileType.OTHER, controllerFile)) {
                this.writerFile(objectMap, this.templateFilePath(template.getGetPageResTs()), controllerFile);
            }
        }
        if (null != tableInfo.getControllerName() && null != pathInfo.get("getPageModelTs_path")) {
            controllerFile = String.format((String)pathInfo.get("getPageModelTs_path") + File.separator
                    + StringUtil.removeUnderLineName(tableInfo.getName()) + "GetPageModel"  + ".ts", entityName);
            if (this.isCreate(FileType.OTHER, controllerFile)) {
                this.writerFile(objectMap, this.templateFilePath(template.getGetPageModelTs()), controllerFile);
            }
        }
        if (null != tableInfo.getControllerName() && null != pathInfo.get("getPageParamTs_path")) {
            controllerFile = String.format((String)pathInfo.get("getPageParamTs_path") + File.separator
                    + StringUtil.removeUnderLineName(tableInfo.getName()) + "GetPageParam"  + ".ts", entityName);
            if (this.isCreate(FileType.OTHER, controllerFile)) {
                this.writerFile(objectMap, this.templateFilePath(template.getGetPageParamTs()), controllerFile);
            }
        }
        if (null != tableInfo.getControllerName() && null != pathInfo.get("getTotalReqTs_path")) {
            controllerFile = String.format((String)pathInfo.get("getTotalReqTs_path") + File.separator
                    + StringUtil.removeUnderLineName(tableInfo.getName()) + "GetTotalRequest"  + ".ts", entityName);
            if (this.isCreate(FileType.OTHER, controllerFile)) {
                this.writerFile(objectMap, this.templateFilePath(template.getGetTotalReqTs()), controllerFile);
            }
        }
        if (null != tableInfo.getControllerName() && null != pathInfo.get("getTotalResTs_path")) {
            controllerFile = String.format((String)pathInfo.get("getTotalResTs_path") + File.separator
                    + StringUtil.removeUnderLineName(tableInfo.getName()) + "GetTotalResponse"  + ".ts", entityName);
            if (this.isCreate(FileType.OTHER, controllerFile)) {
                this.writerFile(objectMap, this.templateFilePath(template.getGetTotalResTs()), controllerFile);
            }
        }
        if (null != tableInfo.getControllerName() && null != pathInfo.get("saveModelTs_path")) {
            controllerFile = String.format((String)pathInfo.get("saveModelTs_path") + File.separator
                    + StringUtil.removeUnderLineName(tableInfo.getName()) + "SaveModel"  + ".ts", entityName);
            if (this.isCreate(FileType.OTHER, controllerFile)) {
                this.writerFile(objectMap, this.templateFilePath(template.getSaveModelTs()), controllerFile);
            }
        }
        if (null != tableInfo.getControllerName() && null != pathInfo.get("saveReqTs_path")) {
            controllerFile = String.format((String)pathInfo.get("saveReqTs_path") + File.separator
                    + StringUtil.removeUnderLineName(tableInfo.getName()) + "SaveRequest"  + ".ts", entityName);
            if (this.isCreate(FileType.OTHER, controllerFile)) {
                this.writerFile(objectMap, this.templateFilePath(template.getSaveReqTs()), controllerFile);
            }
        }
        if (null != tableInfo.getControllerName() && null != pathInfo.get("saveResTs_path")) {
            controllerFile = String.format((String)pathInfo.get("saveResTs_path") + File.separator
                    + StringUtil.removeUnderLineName(tableInfo.getName()) + "SaveResponse"  + ".ts", entityName);
            if (this.isCreate(FileType.OTHER, controllerFile)) {
                this.writerFile(objectMap, this.templateFilePath(template.getSaveResTs()), controllerFile);
            }
        }
        if (null != tableInfo.getControllerName() && null != pathInfo.get("updateStatusReqTs_path")) {
            controllerFile = String.format((String)pathInfo.get("updateStatusReqTs_path") + File.separator
                    + StringUtil.removeUnderLineName(tableInfo.getName()) + "UpdateStatusRequest"  + ".ts", entityName);
            if (this.isCreate(FileType.OTHER, controllerFile)) {
                this.writerFile(objectMap, this.templateFilePath(template.getUpdateStatusReqTs()), controllerFile);
            }
        }
        if (null != tableInfo.getControllerName() && null != pathInfo.get("updateStatusResTs_path")) {
            controllerFile = String.format((String)pathInfo.get("updateStatusResTs_path") + File.separator
                    + StringUtil.removeUnderLineName(tableInfo.getName()) + "UpdateStatusResponse"  + ".ts", entityName);
            if (this.isCreate(FileType.OTHER, controllerFile)) {
                this.writerFile(objectMap, this.templateFilePath(template.getUpdateStatusResTs()), controllerFile);
            }
        }
        if (null != tableInfo.getControllerName() && null != pathInfo.get("modelsTs_path")) {
            controllerFile = String.format((String)pathInfo.get("modelsTs_path") + File.separator
                    + "models"  + ".ts", entityName);
            if (this.isCreate(FileType.OTHER, controllerFile)) {
                this.writerFile(objectMap, this.templateFilePath(template.getModelsTs()), controllerFile);
            }
        }
        if (null != tableInfo.getControllerName() && null != pathInfo.get("pageParamTs_path")) {
            controllerFile = String.format((String)pathInfo.get("pageParamTs_path") + File.separator
                    + "pageParam"  + ".ts", entityName);
            if (this.isCreate(FileType.OTHER, controllerFile)) {
                this.writerFile(objectMap, this.templateFilePath(template.getPageParamTs()), controllerFile);
            }
        }
        if (null != tableInfo.getControllerName() && null != pathInfo.get("responseTs_path")) {
            controllerFile = String.format((String)pathInfo.get("responseTs_path") + File.separator
                    + "response"  + ".ts", entityName);
            if (this.isCreate(FileType.OTHER, controllerFile)) {
                this.writerFile(objectMap, this.templateFilePath(template.getResponseTs()), controllerFile);
            }
        }
    }

    private void generateSwaggerFile(CustomeTableInfo tableInfo, Map<String, Object> objectMap,
                                     Map<String, String> pathInfo, CustomeTemplateConfig template, String entityName) throws Exception {
        String controllerFile;
        if (null != tableInfo.getControllerName() && null != pathInfo.get("indexYaml_path")) {
            controllerFile = String.format((String)pathInfo.get("indexYaml_path") + File.separator + "index"  + ".yaml", entityName);
            if (this.isCreate(FileType.OTHER, controllerFile)) {
                this.writerFile(objectMap, this.templateFilePath(template.getIndex()), controllerFile);
            }
        }
        if (null != tableInfo.getControllerName() && null != pathInfo.get("apisYaml_path")) {
            controllerFile = String.format((String)pathInfo.get("apisYaml_path") + File.separator
                    + StringUtil.getMiddleLineName(tableInfo.getName()) + "-api"  + ".yaml", entityName);
            if (this.isCreate(FileType.OTHER, controllerFile)) {
                this.writerFile(objectMap, this.templateFilePath(template.getApis()), controllerFile);
            }
        }
        if (null != tableInfo.getControllerName() && null != pathInfo.get("common_path")) {
            controllerFile = String.format((String)pathInfo.get("common_path") + File.separator
                    + "common"  + ".yaml", entityName);
            if (this.isCreate(FileType.OTHER, controllerFile)) {
                this.writerFile(objectMap, this.templateFilePath(template.getCommon()), controllerFile);
            }
        }
        if (null != tableInfo.getControllerName() && null != pathInfo.get("existsCode_path")) {
            controllerFile = String.format((String)pathInfo.get("existsCode_path") + File.separator
                    + "exists-code"  + ".yaml", entityName);
            if (this.isCreate(FileType.OTHER, controllerFile)) {
                this.writerFile(objectMap, this.templateFilePath(template.getExistsCode()), controllerFile);
            }
        }
        if (null != tableInfo.getControllerName() && null != pathInfo.get("existsName_path")) {
            controllerFile = String.format((String)pathInfo.get("existsName_path") + File.separator
                    + "exists-name"  + ".yaml", entityName);
            if (this.isCreate(FileType.OTHER, controllerFile)) {
                this.writerFile(objectMap, this.templateFilePath(template.getExistsName()), controllerFile);
            }
        }
        if (null != tableInfo.getControllerName() && null != pathInfo.get("getModel_path")) {
            controllerFile = String.format((String)pathInfo.get("getModel_path") + File.separator
                    + "get-model"  + ".yaml", entityName);
            if (this.isCreate(FileType.OTHER, controllerFile)) {
                this.writerFile(objectMap, this.templateFilePath(template.getGetModel()), controllerFile);
            }
        }
        if (null != tableInfo.getControllerName() && null != pathInfo.get("getPage_path")) {
            controllerFile = String.format((String)pathInfo.get("getPage_path") + File.separator
                    + "get-page"  + ".yaml", entityName);
            if (this.isCreate(FileType.OTHER, controllerFile)) {
                this.writerFile(objectMap, this.templateFilePath(template.getGetPage()), controllerFile);
            }
        }
        if (null != tableInfo.getControllerName() && null != pathInfo.get("getTotal_path")) {
            controllerFile = String.format((String)pathInfo.get("getTotal_path") + File.separator
                    + "get-total"  + ".yaml", entityName);
            if (this.isCreate(FileType.OTHER, controllerFile)) {
                this.writerFile(objectMap, this.templateFilePath(template.getGetTotal()), controllerFile);
            }
        }
        if (null != tableInfo.getControllerName() && null != pathInfo.get("save_path")) {
            controllerFile = String.format((String)pathInfo.get("save_path") + File.separator
                    + "save"  + ".yaml", entityName);
            if (this.isCreate(FileType.OTHER, controllerFile)) {
                this.writerFile(objectMap, this.templateFilePath(template.getSave()), controllerFile);
            }
        }
        if (null != tableInfo.getControllerName() && null != pathInfo.get("updateStatus_path")) {
            controllerFile = String.format((String)pathInfo.get("updateStatus_path") + File.separator
                    + "update-status"  + ".yaml", entityName);
            if (this.isCreate(FileType.OTHER, controllerFile)) {
                this.writerFile(objectMap, this.templateFilePath(template.getUpdateStatus()), controllerFile);
            }
        }
        if (null != tableInfo.getControllerName() && null != pathInfo.get("pageParam_path")) {
            controllerFile = String.format((String)pathInfo.get("pageParam_path") + File.separator
                    + "page-param"  + ".yaml", entityName);
            if (this.isCreate(FileType.OTHER, controllerFile)) {
                this.writerFile(objectMap, this.templateFilePath(template.getPageParam()), controllerFile);
            }
        }
        if (null != tableInfo.getControllerName() && null != pathInfo.get("response_path")) {
            controllerFile = String.format((String)pathInfo.get("response_path") + File.separator
                    + "response"  + ".yaml", entityName);
            if (this.isCreate(FileType.OTHER, controllerFile)) {
                this.writerFile(objectMap, this.templateFilePath(template.getResponse()), controllerFile);
            }
        }
    }

    protected void writerFile(Map<String, Object> objectMap, String templatePath, String outputFile) throws Exception {
        if (StringUtils.isNotBlank(templatePath)) {
            this.writer(objectMap, templatePath, outputFile);
        }
    }

    public void open() {
        String outDir = this.getCustomeConfigBuilder().getGlobalConfig().getOutputDir();
        if (this.getCustomeConfigBuilder().getGlobalConfig().isOpen() && StringUtils.isNotBlank(outDir)) {
            try {
                String osName = System.getProperty("os.name");
                if (osName != null) {
                    if (osName.contains("Mac")) {
                        Runtime.getRuntime().exec("open " + outDir);
                    } else if (osName.contains("Windows")) {
                        Runtime.getRuntime().exec("cmd /c start " + outDir);
                    } else {
                        logger.debug("文件输出目录:" + outDir);
                    }
                }
            } catch (IOException var3) {
                var3.printStackTrace();
            }
        }
    }

    protected boolean isCreate(FileType fileType, String filePath) {
        CustomeConfigBuilder cb = this.getCustomeConfigBuilder();
        CustomeInjectionConfig ic = cb.getInjectionConfig();
        if (null != ic && null != ic.getFileCreate()) {
            return ic.getFileCreate().isCreate(cb, fileType, filePath);
        } else {
            File file = new File(filePath);
            boolean exist = file.exists();
            if (!exist) {
                file.getParentFile().mkdirs();
            }

            return !exist || this.getCustomeConfigBuilder().getGlobalConfig().isFileOverride();
        }
    }

    protected String suffixJavaOrKt() {
        return this.getCustomeConfigBuilder().getGlobalConfig().isKotlin() ? ".kt" : ".java";
    }

    public CustomeConfigBuilder getCustomeConfigBuilder() {
        return this.configBuilder;
    }

}
