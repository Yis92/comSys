package com.sixe.comSys.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import com.google.gson.Gson;
import com.sixe.comSys.utils.InterfaceUtil;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by wuqiang on 2017/4/24-0024.
 */

@Controller
@RequestMapping(value = "/app")
public class AppUpdateController {
    /**
     * app版本
     * @return
     */
    @ResponseBody
    @RequestMapping(value="version")
    public String getversion(){
        String appName= InterfaceUtil.getValue("config/common.properties","appName");
        String verCode= InterfaceUtil.getValue("config/common.properties","verCode");
        String verName= InterfaceUtil.getValue("config/common.properties","verName");
        String appUrl= InterfaceUtil.getValue("config/common.properties","appUrl");
        System.out.println("app版本");
        Map<String,Object> dataMap =new HashedMap();
        dataMap.put("appName",appName);
        dataMap.put("verCode",verCode);
        dataMap.put("verName",verName);
        dataMap.put("appUrl",appUrl);
        Map<String,Object>  resultMap =new HashedMap();
        resultMap.put("code","0");
        resultMap.put("message","获取成功");
        resultMap.putAll(dataMap);
        Gson gson = new Gson();
        String result = gson.toJson(resultMap);
        return result;
    }
    /**
     * app版本界面
     * @return
     */
    @RequestMapping(value="setVersionView")
    public String setVersionView(){

        return "/update/updateApp";
    }
    @RequestMapping(value = "fileUpload")
    @ResponseBody
    public String upload(HttpServletRequest request, String applyId) throws IOException{
        MultipartFile file = ((MultipartHttpServletRequest)request).getFile("uploadfile");
        String tempPath = request.getSession().getServletContext().getRealPath("/apk");
        if (StringUtils.isBlank(tempPath)) {
            return "false";
        }
        if(file.getBytes().length >2097152){
            return "false";
        }
        String fileName = "test_."+file.getOriginalFilename().substring(file.getOriginalFilename().indexOf(".")+1);
        System.out.print(tempPath);
        System.out.print(fileName);
        File out = new File(tempPath+"/"+fileName);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(out);
            fos.write(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            out = null;
        } finally {
            fos.flush();
            fos.close();
        }
        System.out.print("返回值："+out.getAbsolutePath());
        return out.getAbsolutePath();
    }

    /**
     * 更新app版本
     * @param request
     * @param versionCode
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "updateAppVersion")
    @ResponseBody
    public String updateAppVersion(HttpServletRequest request, String versionCode){
       System.out.print("上传更新成功:verCode="+versionCode);
        InterfaceUtil.setValue("config/common.properties","verCode",versionCode);
        Map<String,Object> dataMap =new HashedMap();
        dataMap.put("code","0");
        dataMap.put("message","更新成功");
        Gson gson = new Gson();
        String result = gson.toJson(dataMap);
        return result;
    }
}
