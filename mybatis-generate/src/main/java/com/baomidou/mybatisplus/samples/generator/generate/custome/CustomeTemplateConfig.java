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
