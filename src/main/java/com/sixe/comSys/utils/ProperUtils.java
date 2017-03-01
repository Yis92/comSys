package com.sixe.comSys.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by wuqiang on 2017/3/1.
 */
public class ProperUtils {

    public static String getVal(String key){
        Properties p = new Properties();
        String url="";
        try {
            InputStream inStream = ProperUtils.class.getClassLoader().getResourceAsStream("/config/common.properties"); //这里有人用new FileInputStream(fileName),不过这种方式找不到配置文件。有人说是在classes下，我调过了，不行。
            p.load(inStream);
            url = p.getProperty(key);
            inStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return url;
    }
}
