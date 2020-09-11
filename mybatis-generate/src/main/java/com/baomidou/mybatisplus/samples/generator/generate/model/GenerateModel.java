package com.baomidou.mybatisplus.samples.generator.generate.model;

/**
 * 生成对象
 */
public class GenerateModel {
    /**
     * 生成文件位置
     */
    private String outputDir;
    /**
     * 作者
     */
    private String author;
    /**
     * 当前文件所属 包路径
     */
    private String parentPackage;
    /**
     * 模块名 即生成文件的文件夹
     */
    private String moduleName;
    /**
     * 生成的mapper文件地址
     */
    private String mapperPath;

    private String mapperExtPath;
    /**
     * 表名 多个用逗号隔开
     */
    private String tableNames;
    /**
     * service 的模板文件
     */
    private String serviceTemplateName;
    /**
     * entity 所在包 的名称
     */
    private String entityParentPackageName;
    /**
     * daoExt 所在包名
     */
    private String daoExtPackageName;

    // swagger 相关设置
    private String indexYamlPackageName;
    private String apisYamlPackageName;
    private String modelsYamlPackageName;

    public String getIndexYamlPackageName() {
        return indexYamlPackageName;
    }

    public void setIndexYamlPackageName(String indexYamlPackageName) {
        this.indexYamlPackageName = indexYamlPackageName;
    }

    public String getApisYamlPackageName() {
        return apisYamlPackageName;
    }

    public void setApisYamlPackageName(String apisYamlPackageName) {
        this.apisYamlPackageName = apisYamlPackageName;
    }

    public String getModelsYamlPackageName() {
        return modelsYamlPackageName;
    }

    public void setModelsYamlPackageName(String modelsYamlPackageName) {
        this.modelsYamlPackageName = modelsYamlPackageName;
    }

    public String getDaoExtPackageName() {
        return daoExtPackageName;
    }

    public void setDaoExtPackageName(String daoExtPackageName) {
        this.daoExtPackageName = daoExtPackageName;
    }

    public String getEntityParentPackageName() {
        return entityParentPackageName;
    }

    public void setEntityParentPackageName(String entityParentPackageName) {
        this.entityParentPackageName = entityParentPackageName;
    }

    public String getMapperExtPath() {
        return mapperExtPath;
    }

    public void setMapperExtPath(String mapperExtPath) {
        this.mapperExtPath = mapperExtPath;
    }

    public String getServiceTemplateName() {
        return serviceTemplateName;
    }

    public void setServiceTemplateName(String serviceTemplateName) {
        this.serviceTemplateName = serviceTemplateName;
    }

    public String getOutputDir() {
        return outputDir;
    }

    public void setOutputDir(String outputDir) {
        this.outputDir = outputDir;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getParentPackage() {
        return parentPackage;
    }

    public void setParentPackage(String parentPackage) {
        this.parentPackage = parentPackage;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getMapperPath() {
        return mapperPath;
    }

    public void setMapperPath(String mapperPath) {
        this.mapperPath = mapperPath;
    }

    public String getTableNames() {
        return tableNames;
    }

    public void setTableNames(String tableNames) {
        this.tableNames = tableNames;
    }
}
