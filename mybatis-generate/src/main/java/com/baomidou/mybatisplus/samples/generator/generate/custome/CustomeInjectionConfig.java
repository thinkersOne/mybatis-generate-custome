package com.baomidou.mybatisplus.samples.generator.generate.custome;

import com.baomidou.mybatisplus.generator.InjectionConfig;

public class CustomeInjectionConfig extends InjectionConfig {
    private CustomeConfigBuilder config;
    private CustomeIFileCreate fileCreate;

    @Override
    public void initMap() {

    }

    public InjectionConfig setConfig(final CustomeConfigBuilder config) {
        this.config = config;
        return this;
    }

    public CustomeIFileCreate getFileCreate() {
        return this.fileCreate;
    }

}
