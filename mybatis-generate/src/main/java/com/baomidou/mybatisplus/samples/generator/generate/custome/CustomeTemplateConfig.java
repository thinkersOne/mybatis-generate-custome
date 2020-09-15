package com.baomidou.mybatisplus.samples.generator.generate.custome;
import com.baomidou.mybatisplus.generator.config.TemplateType;

import java.util.Objects;

public class CustomeTemplateConfig {
    // 后端代码
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
    private String index = "/templates/swagger/index.yaml";
    // apis部分
    // common.yaml
    private String common = "/templates/swagger/common.yaml";
    // exists-code.yaml
    private String existsCode = "/templates/swagger/exists-code.yaml";
    // exists-name.yaml
    private String existsName = "/templates/swagger/exists-name.yaml";
    // get-model.yaml
    private String getModel = "/templates/swagger/get-model.yaml";
    // get-page.yaml
    private String getPage = "/templates/swagger/get-page.yaml";
    // get-total.yaml
    private String getTotal = "/templates/swagger/get-total.yaml";
    // save.yaml
    private String save = "/templates/swagger/save.yaml";
    // update-status.yaml
    private String updateStatus = "/templates/swagger/update-status.yaml";
    // 设置 api  里面包含所有接口定义
    private String apis = "/templates/swagger/apis.yaml";
    // models 部分
    private String pageParam = "/templates/swagger/page-param.yaml";
    private String response = "/templates/swagger/response.yaml";

    //设置前端 angular 代码
    private String editHtml = "/templates/angular/edit.html";
    private String editTs = "/templates/angular/edit.ts";
    private String listCss = "/templates/angular/list.css";
    private String listHtml = "/templates/angular/list.html";
    private String listTs = "/templates/angular/list.ts";
    private String serviceTs = "/templates/angular/service.ts";
    private String existsCodeReqTs = "/templates/angular/model/existsCodeReq.ts";
    private String existsCodeResTs = "/templates/angular/model/existsCodeRes.ts";
    private String existsNameReqTs = "/templates/angular/model/existsNameReq.ts";
    private String existsNameResTs = "/templates/angular/model/existsNameRes.ts";
    private String getModelReqTs = "/templates/angular/model/getModelReq.ts";
    private String getModelResTs = "/templates/angular/model/getModelRes.ts";
    private String getPageReqTs = "/templates/angular/model/getPageReq.ts";
    private String getPageResTs = "/templates/angular/model/getPageRes.ts";
    private String getPageModelTs = "/templates/angular/model/getPageModel.ts";
    private String getPageParamTs = "/templates/angular/model/getPageParam.ts";
    private String getTotalReqTs = "/templates/angular/model/getTotalReq.ts";
    private String getTotalResTs = "/templates/angular/model/getTotalRes.ts";
    private String saveModelTs = "/templates/angular/model/saveModel.ts";
    private String saveReqTs = "/templates/angular/model/saveReq.ts";
    private String saveResTs = "/templates/angular/model/saveRes.ts";
    private String updateStatusReqTs = "/templates/angular/model/updateStatusReq.ts";
    private String updateStatusResTs = "/templates/angular/model/updateStatusRes.ts";

    public String getExistsCodeReqTs() {
        return existsCodeReqTs;
    }

    public void setExistsCodeReqTs(String existsCodeReqTs) {
        this.existsCodeReqTs = existsCodeReqTs;
    }

    public String getExistsCodeResTs() {
        return existsCodeResTs;
    }

    public void setExistsCodeResTs(String existsCodeResTs) {
        this.existsCodeResTs = existsCodeResTs;
    }

    public String getExistsNameReqTs() {
        return existsNameReqTs;
    }

    public void setExistsNameReqTs(String existsNameReqTs) {
        this.existsNameReqTs = existsNameReqTs;
    }

    public String getExistsNameResTs() {
        return existsNameResTs;
    }

    public void setExistsNameResTs(String existsNameResTs) {
        this.existsNameResTs = existsNameResTs;
    }

    public String getGetModelReqTs() {
        return getModelReqTs;
    }

    public void setGetModelReqTs(String getModelReqTs) {
        this.getModelReqTs = getModelReqTs;
    }

    public String getGetModelResTs() {
        return getModelResTs;
    }

    public void setGetModelResTs(String getModelResTs) {
        this.getModelResTs = getModelResTs;
    }

    public String getGetPageReqTs() {
        return getPageReqTs;
    }

    public void setGetPageReqTs(String getPageReqTs) {
        this.getPageReqTs = getPageReqTs;
    }

    public String getGetPageResTs() {
        return getPageResTs;
    }

    public void setGetPageResTs(String getPageResTs) {
        this.getPageResTs = getPageResTs;
    }

    public String getGetPageModelTs() {
        return getPageModelTs;
    }

    public void setGetPageModelTs(String getPageModelTs) {
        this.getPageModelTs = getPageModelTs;
    }

    public String getGetPageParamTs() {
        return getPageParamTs;
    }

    public void setGetPageParamTs(String getPageParamTs) {
        this.getPageParamTs = getPageParamTs;
    }

    public String getGetTotalReqTs() {
        return getTotalReqTs;
    }

    public void setGetTotalReqTs(String getTotalReqTs) {
        this.getTotalReqTs = getTotalReqTs;
    }

    public String getGetTotalResTs() {
        return getTotalResTs;
    }

    public void setGetTotalResTs(String getTotalResTs) {
        this.getTotalResTs = getTotalResTs;
    }

    public String getSaveModelTs() {
        return saveModelTs;
    }

    public void setSaveModelTs(String saveModelTs) {
        this.saveModelTs = saveModelTs;
    }

    public String getSaveReqTs() {
        return saveReqTs;
    }

    public void setSaveReqTs(String saveReqTs) {
        this.saveReqTs = saveReqTs;
    }

    public String getSaveResTs() {
        return saveResTs;
    }

    public void setSaveResTs(String saveResTs) {
        this.saveResTs = saveResTs;
    }

    public String getUpdateStatusReqTs() {
        return updateStatusReqTs;
    }

    public void setUpdateStatusReqTs(String updateStatusReqTs) {
        this.updateStatusReqTs = updateStatusReqTs;
    }

    public String getUpdateStatusResTs() {
        return updateStatusResTs;
    }

    public void setUpdateStatusResTs(String updateStatusResTs) {
        this.updateStatusResTs = updateStatusResTs;
    }

    public String getServiceTs() {
        return serviceTs;
    }

    public void setServiceTs(String serviceTs) {
        this.serviceTs = serviceTs;
    }

    public String getListCss() {
        return listCss;
    }

    public void setListCss(String listCss) {
        this.listCss = listCss;
    }

    public String getListHtml() {
        return listHtml;
    }

    public void setListHtml(String listHtml) {
        this.listHtml = listHtml;
    }

    public String getListTs() {
        return listTs;
    }

    public void setListTs(String listTs) {
        this.listTs = listTs;
    }

    public String getEditTs() {
        return editTs;
    }

    public void setEditTs(String editTs) {
        this.editTs = editTs;
    }

    public String getEditHtml() {
        return editHtml;
    }

    public void setEditHtml(String editHtml) {
        this.editHtml = editHtml;
    }

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
