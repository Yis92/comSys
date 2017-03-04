package com.sixe.comSys.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.sixe.comSys.base.SessionInterceptor;
import com.sixe.comSys.base.SpringContextHolder;
import com.sixe.comSys.dto.QueryUserList.QueryUserListParam;
import com.sixe.comSys.dto.QueryUserList.UserParam;
import com.sixe.comSys.utils.HttpClientUtil;
import com.sixe.comSys.utils.ProperUtils;
import com.sixe.comSys.utils.Tools;
import org.apache.commons.collections.map.HashedMap;
import com.sun.istack.internal.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/24.
 */

@Controller
@RequestMapping(value = "myHome")
public class MyHomeController {

    private static Logger logger = Logger.getLogger(MyHomeController.class);

    /**
     * 用户登录成功跳转中心
     * @return
     */
    @RequestMapping(value = "/goMyHome")
    public String goMyHome(HttpServletRequest request, HttpServletResponse response){
        //判断用户角色
        int user_level = SpringContextHolder.getCurrentUser().getResult().getUser_level();
        if("12".equals(user_level+"")){//12.普通用户,11.高级用户，10.公司管理员
            //普通用户进入...
            return "/user/home";
        }else{
            //管理员用户进入...
            request.setAttribute("units",SpringContextHolder.getCurrentUser().getResult().getUnits());
            return "/admin/adminHome";
        }
    }

    /**
     * 进入单位信息管理
     * @return
     */
    @RequestMapping(value = "/goComInfo")
    public String goComInfo(String id){

        return "/com/info";
    }

    /**
     * 进入DTU管理
     * @return
     */
    @RequestMapping(value = "/goDTUConfig")
    public String goDTUConfig(String id){

        return "/com/DTU";
    }

    /**
     * 进入单位用户管理
     * @return
     */
    @RequestMapping(value = "/goComUser")
    public String goComUser(String id,HttpServletRequest request, HttpServletResponse response){
        logger.info("单位No:"+id);
        Map<String,String> map = new HashedMap();
        map.put("unit_no",id);
        try {
            request.setAttribute("unitNo",id);
            logger.info("请求参数："+map.toString());
            String result = HttpClientUtil.doHttpPost(ProperUtils.getVal("reqUrl")+"querry_all_users_info.php","UTF-8",map,10000);
            logger.info("返回结果:"+result);

            JSONObject jsonObj = JSON.parseObject(result);
            String state=jsonObj.getString("state");
            if("200".equals(state)){
                Gson gson = new Gson();
                QueryUserListParam param = gson.fromJson(result, QueryUserListParam.class);
                List<UserParam> list = param.getResult();
                logger.info("用户列表长度："+list.size());
                request.setAttribute("userList",list);
            }else{
                String message=jsonObj.getString("message");
                logger.info("请求失败【message】:"+message);
                request.setAttribute("userList","");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("请求异常");
            request.setAttribute("userList","");
        }
        return "/com/comUser";
    }

    /**
     * 删除用户
     * @param userId
     * @param unitNo
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "doDel")
    public String doDel(String userId,String unitNo){
        logger.info("删除User_Id:"+userId);
        logger.info("所属公司NO："+unitNo);
        Map<String,String> map = new HashedMap();
        map.put("unit_no",unitNo);
        map.put("user_id",userId);
        map.put("host_user_id",SpringContextHolder.getCurrentUser().getResult().getUser_id());
        logger.info("请求参数："+map.toString());
        String result = null;
        try {
            result = HttpClientUtil.doHttpPost(ProperUtils.getVal("reqUrl")+"del_user.php","UTF-8",map,10000);
            logger.info("返回结果:"+result);
            JSONObject jsonObj = JSON.parseObject(result);
            String state=jsonObj.getString("state");
            if("200".equals(state)){
                return Tools.sendJson("SUC");
            }else{
                String message=jsonObj.getString("message");
                logger.info("请求失败【message】:"+message);
                return Tools.sendJson(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("请求失败......");
            return Tools.sendJson("系统异常");
        }
    }

    /**
     * 保存修改用户
     * @param id
     * @param level
     * @param fullName
     * @param desc
     * @param phone1
     * @param phone2
     * @param unitNo
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/doUpd")
    public String doUpd(String id,String level,
                        String fullName,String desc,
                        String phone1,String phone2,
                        String unitNo){
        logger.info("修改User_Id:"+id);
        logger.info("所属公司NO："+unitNo);
        Map<String,String> map = new HashedMap();
       // map.put("unit_no",unitNo);
        map.put("user_id",id);
        map.put("user_level",level);
        map.put("user_full_name",fullName);
        map.put("user_describ",desc);
        map.put("user_tel1",phone1);
        map.put("user_tel2",phone2);
        map.put("host_user_id",SpringContextHolder.getCurrentUser().getResult().getUser_id());
        logger.info("请求参数："+map.toString());
        try {
            String result = HttpClientUtil.doHttpPost(ProperUtils.getVal("reqUrl")+"update_user_info_by_host.php","UTF-8",map,10000);
            logger.info("返回结果:"+result);
            JSONObject jsonObj = JSON.parseObject(result);
            String state=jsonObj.getString("state");
            if("200".equals(state)){
                return Tools.sendJson("SUC");
            }else{
                String message=jsonObj.getString("message");
                logger.info("请求失败【message】:"+message);
                return Tools.sendJson(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Tools.sendJson("系统异常");
        }
    }

    /**
     * 添加用户
     * @param user_id
     * @param password
     * @param level
     * @param desc
     * @param unitNo
     * @param fullName
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/doAdd")
    public String doAdd(String user_id,String password,
                            String level,String desc,String unitNo,String fullName){
        logger.info("新增User_Id:"+user_id);
        logger.info("所属公司NO："+unitNo);
        logger.info("密码："+password);
        Map<String,String> map = new HashedMap();
        map.put("user_id",user_id);
        map.put("pwd",password);
        map.put("user_level",level);
        map.put("user_describ",desc);
        map.put("unit_no",unitNo);
        map.put("user_full_name",fullName);
        map.put("host_user_id",SpringContextHolder.getCurrentUser().getResult().getUser_id());
        logger.info("请求参数："+map.toString());
        try {
            String result = HttpClientUtil.doHttpPost(ProperUtils.getVal("reqUrl")+"add_user.php","UTF-8",map,10000);
            logger.info("返回结果:"+result);
            JSONObject jsonObj = JSON.parseObject(result);
            String state=jsonObj.getString("state");
            if("200".equals(state)){
                return Tools.sendJson("SUC");
            }else{
                String message=jsonObj.getString("message");
                logger.info("请求失败【message】:"+message);
                return Tools.sendJson(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Tools.sendJson("系统异常");
        }
    }

    /**
     * 修改密码（管理员修改员工密码）
     * @param user_id
     * @param upass
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/doUpwd")
    public String doUpwd(String user_id,String upass){
        logger.info("修改密码user_Id:"+user_id);
        logger.info("修改密码 upass:"+upass);
        Map<String,String> map = new HashedMap();
        map.put("user_id",user_id);
        map.put("pwd_new",upass);
        map.put("host_user_id",SpringContextHolder.getCurrentUser().getResult().getUser_id());

        logger.info("请求参数："+map.toString());
        try {
            String result = HttpClientUtil.doHttpPost(ProperUtils.getVal("reqUrl")+"update_user_pwd_by_host.php","UTF-8",map,10000);
            logger.info("返回结果:"+result);
            JSONObject jsonObj = JSON.parseObject(result);
            String state=jsonObj.getString("state");
            if("200".equals(state)){
                return Tools.sendJson("SUC");
            }else{
                String message=jsonObj.getString("message");
                logger.info("请求失败【message】:"+message);
                return Tools.sendJson(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Tools.sendJson("系统异常");
        }
    }


}
