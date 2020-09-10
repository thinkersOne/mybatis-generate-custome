package com.baomidou.mybatisplus.samples.generator.generate.custome;

import com.baomidou.mybatisplus.generator.config.po.TableInfo;

public class CustomeTableInfo extends TableInfo {
    private String daoExtName;
    private String mapperExtName;

    public String getMapperExtName() {
        return mapperExtName;
    }

    public CustomeTableInfo setMapperExtName(String mapperExtName) {
        this.mapperExtName = mapperExtName;
        return this;
    }

    public String getDaoExtName() {
        return daoExtName;
    }

    public CustomeTableInfo setDaoExtName(final String daoExtName) {
        this.daoExtName = daoExtName;
        return this;
    }
}
