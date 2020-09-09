package com.baomidou.mybatisplus.samples.generator.generate.custome;

import com.baomidou.mybatisplus.generator.config.PackageConfig;

public class CustomePackageConfig extends PackageConfig {
    private String daoExt = "daoExt";

    public String getDaoExt() {
        return daoExt;
    }

    public void setDaoExt(String daoExt) {
        this.daoExt = daoExt;
    }
}
