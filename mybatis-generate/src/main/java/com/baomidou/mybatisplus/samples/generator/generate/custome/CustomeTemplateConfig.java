package com.baomidou.mybatisplus.samples.generator.generate.custome;
import com.baomidou.mybatisplus.generator.config.TemplateType;

import java.util.Objects;

public class CustomeTemplateConfig {
    private String entity = "/templates/entity.java";
    private String entityKt = "/templates/entity.kt";
    private String service = "/templates/service.java";
    private String serviceImpl = "/templates/serviceImpl.java";
    private String mapper = "/templates/mapper.java";
    private String xml = "/templates/mapper.xml";
    private String controller = "/templates/controller.java";
    private String mapperExt = "/templates/mapperExt.xml";
    private String daoExt = "/templates/daoExt.java";

    //设置 swagger yaml文件
    // index.yaml
    private String index = "/templates/index.yaml";
    // apis部分
    // common.yaml
    private String common = "/templates/common.yaml";
    // exists-code.yaml
    private String existsCode = "/templates/exists-code.yaml";
    // exists-name.yaml
    private String existsName = "/templates/exists-name.yaml";
    // get-model.yaml
    private String getModel = "/templates/get-model.yaml";
    // get-page.yaml
    private String getPage = "/templates/get-page.yaml";
    // get-total.yaml
    private String getTotal = "/templates/get-total.yaml";
    // save.yaml
    private String save = "/templates/save.yaml";
    // update-status.yaml
    private String updateStatus = "/templates/update-status.yaml";
    // 设置 api  里面包含所有接口定义
    private String apis = "/templates/apis.yaml";
    // models 部分
    private String pageParam = "/templates/page-param.yaml";
    private String response = "/templates/response.yaml";

    public String getPageParam() {
        return pageParam;
    }

    public void setPageParam(String pageParam) {
        this.pageParam = pageParam;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getEntity() {
        return entity;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getCommon() {
        return common;
    }

    public void setCommon(String common) {
        this.common = common;
    }

    public String getExistsCode() {
        return existsCode;
    }

    public void setExistsCode(String existsCode) {
        this.existsCode = existsCode;
    }

    public String getExistsName() {
        return existsName;
    }

    public void setExistsName(String existsName) {
        this.existsName = existsName;
    }

    public String getGetModel() {
        return getModel;
    }

    public void setGetModel(String getModel) {
        this.getModel = getModel;
    }

    public String getGetPage() {
        return getPage;
    }

    public void setGetPage(String getPage) {
        this.getPage = getPage;
    }

    public String getGetTotal() {
        return getTotal;
    }

    public void setGetTotal(String getTotal) {
        this.getTotal = getTotal;
    }

    public String getSave() {
        return save;
    }

    public void setSave(String save) {
        this.save = save;
    }

    public String getUpdateStatus() {
        return updateStatus;
    }

    public void setUpdateStatus(String updateStatus) {
        this.updateStatus = updateStatus;
    }

    public String getApis() {
        return apis;
    }

    public void setApis(String apis) {
        this.apis = apis;
    }

    public String getEntity(boolean kotlin) {
        return kotlin ? this.entityKt : this.entity;
    }

    public CustomeTemplateConfig disable(TemplateType... templateTypes) {
        if (templateTypes != null && templateTypes.length > 0) {
            TemplateType[] var2 = templateTypes;
            int var3 = templateTypes.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                TemplateType templateType = var2[var4];
                switch(templateType) {
                    case XML:
                        this.setXml((String)null);
                        break;
                    case ENTITY:
                        this.setEntity((String)null).setEntityKt((String)null);
                        break;
                    case MAPPER:
                        this.setMapper((String)null);
                        break;
                    case SERVICE:
                        this.setService((String)null).setServiceImpl((String)null);
                        break;
                    case CONTROLLER:
                        this.setController((String)null);
                }
            }
        }
        return this;
    }

    public CustomeTemplateConfig() {
    }

    public String getDaoExt() {
        return daoExt;
    }

    public void setDaoExt(String daoExt) {
        this.daoExt = daoExt;
    }

    public String getMapperExt() {
        return mapperExt;
    }

    public void setMapperExt(String mapperExt) {
        this.mapperExt = mapperExt;
    }

    public String getEntityKt() {
        return this.entityKt;
    }

    public String getService() {
        return this.service;
    }

    public String getServiceImpl() {
        return this.serviceImpl;
    }

    public String getMapper() {
        return this.mapper;
    }

    public String getXml() {
        return this.xml;
    }

    public String getController() {
        return this.controller;
    }

    public CustomeTemplateConfig setEntity(final String entity) {
        this.entity = entity;
        return this;
    }

    public CustomeTemplateConfig setEntityKt(final String entityKt) {
        this.entityKt = entityKt;
        return this;
    }

    public CustomeTemplateConfig setService(final String service) {
        this.service = service;
        return this;
    }

    public CustomeTemplateConfig setServiceImpl(final String serviceImpl) {
        this.serviceImpl = serviceImpl;
        return this;
    }

    public CustomeTemplateConfig setMapper(final String mapper) {
        this.mapper = mapper;
        return this;
    }

    public CustomeTemplateConfig setXml(final String xml) {
        this.xml = xml;
        return this;
    }

    public CustomeTemplateConfig setController(final String controller) {
        this.controller = controller;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomeTemplateConfig)) return false;
        CustomeTemplateConfig that = (CustomeTemplateConfig) o;
        return entity.equals(that.entity) &&
                getEntityKt().equals(that.getEntityKt()) &&
                getService().equals(that.getService()) &&
                getServiceImpl().equals(that.getServiceImpl()) &&
                getMapper().equals(that.getMapper()) &&
                getXml().equals(that.getXml()) &&
                getController().equals(that.getController());
    }

    @Override
    public int hashCode() {
        return Objects.hash(entity, getEntityKt(), getService(), getServiceImpl(), getMapper(), getXml(), getController());
    }

    @Override
    public String toString() {
        return "CustomeTemplateConfig{" +
                "entity='" + entity + '\'' +
                ", entityKt='" + entityKt + '\'' +
                ", service='" + service + '\'' +
                ", serviceImpl='" + serviceImpl + '\'' +
                ", mapper='" + mapper + '\'' +
                ", xml='" + xml + '\'' +
                ", controller='" + controller + '\'' +
                '}';
    }
}
