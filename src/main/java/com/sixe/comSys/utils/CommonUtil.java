package com.sixe.comSys.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
*******************************************************************
*<p>模块名称：获取配置参数模块
*<p>类名：CommonUtil.java
*<p>功能详细描述：获取common里面的参数
*<p>备注：例如：项目请求URL，照片保存URL等基本常量值
*******************************************************************
* @Package weixinServer.base 
* @ClassName: CommonUtil
* @Description: TODO(这里用一句话描述这个类的作用)
* @author wuqiang
* @date 2015-11-23 下午4:43:32
*/
public class CommonUtil {
	
	/**   
	*******************************************************************
	*<p><b>根据在common配置中的名称获取参数</b><br/>
	*<p><b>备注：</b>特殊情况说明<br/>
	*******************************************************************
	* @Title: getCommonValue    
	* @Description: TODO(这里用一句话描述这个方法的作用)    
	* @param @param Key
	* @param @return    设定文件    
	* @return String    返回类型  
	* @author wuqiang 
	* @date 2015-11-23 下午4:47:36 
	* @throws    
	*/
	public static String getCommonValue(String Key){
		Properties p = new Properties(); 
		String url="";
        try {
        	InputStream inStream = CommonUtil.class.getClassLoader().getResourceAsStream("/config/common.properties"); //这里有人用new FileInputStream(fileName),不过这种方式找不到配置文件。有人说是在classes下，我调过了，不行。  
			p.load(inStream);
			url = p.getProperty(Key);
		    inStream.close();  
        } catch (IOException e) {
			e.printStackTrace();
		} 
        return url;
	}
	
	public static List<String> getCoureseView(){
		System.out.println("getCoureseView");
		Properties p = new Properties(); 
		List<String> list = new ArrayList<String>();
		try {
        	InputStream inStream = CommonUtil.class.getClassLoader().getResourceAsStream("/config/courseViews.properties"); //这里有人用new FileInputStream(fileName),不过这种方式找不到配置文件。有人说是在classes下，我调过了，不行。  
			p.load(inStream);
			String key = "course_";
			for(int i=0;i<10;i++){
				String view = p.getProperty(key+i);
				list.add(view);
			}
		    inStream.close();  
        } catch (IOException e) {
			e.printStackTrace();
		} 
		return list;
	}
	
	public static void setCoureseView(String num){
		System.out.println("setCoureseView");
		Properties p = new Properties(); 
		try {
        	InputStream inStream = CommonUtil.class.getClassLoader().getResourceAsStream("/config/courseViews.properties"); //这里有人用new FileInputStream(fileName),不过这种方式找不到配置文件。有人说是在classes下，我调过了，不行。  
			p.load(inStream);
			String key = "course_";
			String view = p.getProperty(key+num);
			int newView = Integer.parseInt(view);
			newView++;
			updHot("/config/courseViews.properties",key+num,String.valueOf(newView));
			System.out.println(key+num+">>>>>>>>>课程加一次点击量");
			inStream.close();  
        } catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public static void updHot(String filePath,String key,String value){
		filePath = CommonUtil.class.getResource("/" + filePath).toString();  
        //截掉路径的”file:/“前缀  
		System.out.println("截取前"+filePath);
        filePath = filePath.substring(6); 
        filePath="/"+filePath;
        System.out.println("截取后"+filePath);
        Properties prop = new Properties();  
        try {  
            File file = new File(filePath);  
            if (!file.exists())  
                file.createNewFile();  
            InputStream fis = new FileInputStream(file);  
            prop.load(fis);  
            //一定要在修改值之前关闭fis  
            fis.close();  
            OutputStream fos = new FileOutputStream(filePath);  
            prop.setProperty(key, value);  
            //保存，并加入注释  
            prop.store(fos, "Update '" + key + "' value");  
            fos.close();  
        } catch (IOException e) {  
            System.err.println("Visit " + filePath + " for updating " + value + " value error");  
        }  
	}
	public static void main(String[] args) {
	}
}
