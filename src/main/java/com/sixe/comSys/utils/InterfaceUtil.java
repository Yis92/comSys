package com.sixe.comSys.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 * Created by dev3 on 2017/4/24-0024.
 */
public class InterfaceUtil {


    private static InterfaceUtil instance = null;
    private Properties props = null ;
    private static String FILEPATH = "";

    private static InterfaceUtil getInstatance(String filePath){
        instance = new InterfaceUtil("/"+filePath);
        return instance;
    }

    private InterfaceUtil(String filePath){
        loadProps(filePath);
    }

    private void loadProps(String filePath) {
        props = new Properties();
        InputStream in = null;
        try {
            in = getClass().getResourceAsStream(filePath);
            props.load(in);
        }
        catch (Exception e) {
            //此处可根据你的日志框架进行记录
            System.err.println("Error idn conf properties in PropertyManager.loadProps() " + e);
            e.printStackTrace();
        }
        finally {
            try {
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
                //此处可根据你的日志框架进行记录
            }
        }
    }
    
    private String getProp(String key) {
        String value = props.getProperty(key);
        return value == null ? "" : value.trim();
    }

    /**
     * 根据key获取对应value
     * @param filePath 文件路径
     * @param key
     * @return
     */
    public static String getValue(String filePath,String key){
        return getInstatance(filePath).getProp(key);
    }
    /**
     * 根据key设置对应value
     * @param filePath 文件路径
     * @param key
     * @return
     */
    public static void setValue(String filePath,String key,String value){
    	instance = getInstatance(filePath);
        // 以适合使用 load 方法加载到 Properties 表中的格式，
        // 将此 Properties 表中的属性列表（键和元素对）写入输出流
    	FileOutputStream fos = null;
    	try {
    		fos = new FileOutputStream(InterfaceUtil.class.getResource("/"+filePath).getPath());
    		instance.props.setProperty(key, value);
			instance.props.store(fos, "Update '" + "" + "' value");
			fos.close();
		} catch (IOException e) {
			System.out.println("失败了");
			e.printStackTrace();
		} finally {
             try {
            	 fos.close();
             } catch (Exception e) {
                 e.printStackTrace();
                 //此处可根据你的日志框架进行记录
             }
         }
    }

    /**
     * 根据key获取对应value，如果为空则返回默认的value
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getValue(String filePath,String key,String defaultValue){
        String value = getInstatance(filePath).getProp(key);
        return "".equals(value) ? defaultValue : value;
    }

    public static void main(String[] args) {
        InterfaceUtil.setValue("errors.properties","SYS-0003","未知错误，请联系系统管理员。测试");
        System.out.println(InterfaceUtil.getValue("errors.properties", "SYS-0003"));
    }
}
