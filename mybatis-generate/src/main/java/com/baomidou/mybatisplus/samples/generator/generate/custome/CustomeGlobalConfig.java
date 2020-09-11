package com.baomidou.mybatisplus.samples.generator.generate.custome;

import com.baomidou.mybatisplus.generator.config.GlobalConfig;

public class CustomeGlobalConfig extends GlobalConfig {
    // swagger 文件
    private String yamlName;

    public CustomeGlobalConfig() {
    }

    public String getYamlName() {
        return yamlName;
    }

    public void setYamlName(String yamlName) {
        this.yamlName = yamlName;
    }
}
