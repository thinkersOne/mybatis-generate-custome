package com.baomidou.mybatisplus.samples.generator.generate.custome;

import com.baomidou.mybatisplus.generator.config.IFileCreate;
import com.baomidou.mybatisplus.generator.config.rules.FileType;

import java.io.File;

public interface CustomeIFileCreate extends IFileCreate {
    boolean isCreate(CustomeConfigBuilder configBuilder, FileType fileType, String filePath);

    default void checkDir(String filePath) {
        File file = new File(filePath);
        boolean exist = file.exists();
        if (!exist) {
            file.getParentFile().mkdir();
        }

    }

}
