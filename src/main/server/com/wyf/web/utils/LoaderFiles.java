package com.wyf.web.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class LoaderFiles {
    private static Log log = LogFactory.getLog(LoaderFiles.class);

    public static String loadFile(String fileName, String key) {
        Properties pro = new Properties();
        InputStream input = LoaderFiles.class.getClassLoader().getResourceAsStream(fileName);
        String value = "";
        try {
            pro.load(input);
            value = pro.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                log.error("读取配置文件出错" + e.getMessage());
            }
        }
        return value;
    }
}
