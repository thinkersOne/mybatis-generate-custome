package com.baomidou.mybatisplus.samples.generator.generate.custome;

import com.baomidou.mybatisplus.generator.config.PackageConfig;

public class CustomePackageConfig extends PackageConfig {
    private String daoExt = "daoExt";
    private String mapperExt = "mapperExt";

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
