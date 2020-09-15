package com.baomidou.mybatisplus.samples.generator.generate.custome;

import com.baomidou.mybatisplus.generator.config.PackageConfig;

/**
 * 设置 包路径文件 地址
 */
public class CustomePackageConfig extends PackageConfig {
    //包名
    private String daoExt = "daoext";
    private String mapperExt = "mapper";

    // swagger 模块 yaml文件
    private String indexYaml = "swagger-spec.all";
    private String apisYaml = "swagger-spec.apis";
    private String apisModelYaml = "swagger-spec.apis.model";
    private String modelsYaml = "swagger-spec.models";
    private String modelsCommonYaml = "swagger-spec.models.common";

    // angular 前端模块 文件
    private String editAngular = "angular.edit";
    private String listAngular = "angular";
    private String serviceAngular = "angular.service";
    private String serviceModelAngular = "angular.service.model";

    public String getEditAngular() {
        return editAngular;
    }

    public void setEditAngular(String editAngular) {
        this.editAngular = editAngular;
    }

    public String getListAngular() {
        return listAngular;
    }

    public void setListAngular(String listAngular) {
        this.listAngular = listAngular;
    }

    public String getServiceAngular() {
        return serviceAngular;
    }

    public void setServiceAngular(String serviceAngular) {
        this.serviceAngular = serviceAngular;
    }

    public String getServiceModelAngular() {
        return serviceModelAngular;
    }

    public void setServiceModelAngular(String serviceModelAngular) {
        this.serviceModelAngular = serviceModelAngular;
    }

    public String getModelsCommonYaml() {
        return modelsCommonYaml;
    }

    public void setModelsCommonYaml(String modelsCommonYaml) {
        this.modelsCommonYaml = modelsCommonYaml;
    }

    public String getApisModelYaml() {
        return apisModelYaml;
    }

    public void setApisModelYaml(String apisModelYaml) {
        this.apisModelYaml = apisModelYaml;
    }

    public String getIndexYaml() {
        return indexYaml;
    }

    public void setIndexYaml(String indexYaml) {
        this.indexYaml = indexYaml;
    }

    public String getApisYaml() {
        return apisYaml;
    }

    public void setApisYaml(String apisYaml) {
        this.apisYaml = apisYaml;
    }

    public String getModelsYaml() {
        return modelsYaml;
    }

    public void setModelsYaml(String modelsYaml) {
        this.modelsYaml = modelsYaml;
    }

    public String getMapperExt() {
        return mapperExt;
    }

    public void setMapperExt(String mapperExt) {
        this.mapperExt = mapperExt;
    }

    public String getDaoExt() {
        return daoExt;
    }

    public void setDaoExt(String daoExt) {
        this.daoExt = daoExt;
    }
}
