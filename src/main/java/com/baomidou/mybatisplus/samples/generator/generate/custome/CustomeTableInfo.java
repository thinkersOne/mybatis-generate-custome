package com.baomidou.mybatisplus.samples.generator.generate.custome;

import com.baomidou.mybatisplus.generator.config.po.TableInfo;

public class CustomeTableInfo extends TableInfo {
    private String daoExtName;

    public String getDaoExtName() {
        return daoExtName;
    }

    public TableInfo setDaoExtName(final String daoExtName) {
        this.daoExtName = daoExtName;
        return this;
    }
}
