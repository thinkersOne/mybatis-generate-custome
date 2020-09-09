package com.baomidou.mybatisplus.samples.generator.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class ExceptionUtil {

    public static String getAllInfo(Exception ex) {
        String ret = "";
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            PrintStream pout = new PrintStream(out);
            ex.printStackTrace(pout);
            ret = new String(out.toByteArray());
            pout.close();

        } catch (Exception e) {
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }
}
