package com.baomidou.mybatisplus.samples.generator.generate.custome;

import com.baomidou.mybatisplus.generator.config.ConstVal;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Map;

public class CustomeFreemarkerTemplateEngine extends CustomeAbstractTemplateEngine{

    public CustomeFreemarkerTemplateEngine() {
    }
    private Configuration configuration;

    public CustomeFreemarkerTemplateEngine init(CustomeConfigBuilder configBuilder) {
        super.init(configBuilder);
        this.configuration = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        this.configuration.setDefaultEncoding(ConstVal.UTF8);
        this.configuration.setClassForTemplateLoading(FreemarkerTemplateEngine.class, "/");
        return this;
    }

    public void writer(Map<String, Object> objectMap, String templatePath, String outputFile) throws Exception {
        Template template = this.configuration.getTemplate(templatePath);
        FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
        Throwable var6 = null;

        try {
            template.process(objectMap, new OutputStreamWriter(fileOutputStream, ConstVal.UTF8));
        } catch (Throwable var15) {
            var6 = var15;
            throw var15;
        } finally {
            if (fileOutputStream != null) {
                if (var6 != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable var14) {
                        var6.addSuppressed(var14);
                    }
                } else {
                    fileOutputStream.close();
                }
            }
        }
        logger.debug("模板:" + templatePath + ";  文件:" + outputFile);
    }

    public String templateFilePath(String filePath) {
        return filePath + ".ftl";
    }
}
