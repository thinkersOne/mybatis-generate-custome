package com.baomidou.mybatisplus.samples.generator.generate.custome;

import com.baomidou.mybatisplus.generator.config.PackageConfig;

public class CustomePackageConfig extends PackageConfig {
    //包名
    private String daoExt = "daoExt";
    private String mapperExt = "mapperExt";

    // swagger 模块 yaml文件
    private String indexYaml = "swagger-spec.all";
    private String apisYaml = "swagger-spec.apis";
    private String apisModelYaml = "swagger-spec.apis.model";
    private String modelsYaml = "swagger-spec.models";
    private String modelsCommonYaml = "swagger-spec.models.common";

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
