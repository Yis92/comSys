package com.sixe.comSys.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.sixe.comSys.base.Contants;
import com.sixe.comSys.base.SessionInterceptor;
import com.sixe.comSys.base.SpringContextHolder;
import com.sixe.comSys.dto.QueryComInfo.ComInfoParam;
import com.sixe.comSys.dto.QueryComInfo.QueryComInfoParam;
import com.sixe.comSys.dto.QueryDtuInfo.QueryDTUInfoParam;
import com.sixe.comSys.dto.QueryDtuInfo.QueryDTUStatusParam;
import com.sixe.comSys.dto.QueryUserList.QueryUserListParam;
import com.sixe.comSys.dto.QueryUserList.UserParam;
import com.sixe.comSys.utils.HttpClientUtil;
import com.sixe.comSys.utils.ProperUtils;
import com.sixe.comSys.utils.Tools;
import org.apache.commons.collections.map.HashedMap;
import com.sun.istack.internal.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by wuqiang on 2017/2/24.
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
        request.setAttribute("units",SpringContextHolder.getCurrentUser().getResult().getUnits());
        if("12".equals(user_level+"")){//12.普通用户,11.高级用户，10.公司管理员
            //普通用户进入...
            return "/user/home";
        }else if("10".equals(user_level+"")){
            //管理员用户进入...
            return "/admin/adminHome";
        }else{
            //高级用户进入...
            return "/user/home";
        }
    }

    /**
     * DTU页面
     * @param id
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/goDTUPage")
    public String goDTUPage(String id,HttpServletRequest request, HttpServletResponse response){
        logger.info("DTUPage【dtu_sn】:"+id);
        request.setAttribute("dtu_sn",id);
        Map<String,String> map = new HashedMap();
        map.put("dtu_sn","1512110003000001");
        logger.info("请求参数："+map.toString());
        try {
            String result = HttpClientUtil.doHttpPost(ProperUtils.getVal("reqUrl") + Contants.Query_Dtu_Info_Url, "UTF-8", map, 10000);
            logger.info("返回结果:" + result);
            JSONObject jsonObj = JSON.parseObject(result);
            String state=jsonObj.getString("state");
            if("200".equals(state)){
                logger.info("查询成功...");
                Gson gson = new Gson();
                QueryDTUInfoParam param = gson.fromJson(result,QueryDTUInfoParam.class);
                request.setAttribute("dtuInfo",param.getResult());
            }else{
                String message=jsonObj.getString("message");
                logger.info("请求失败【message】:"+message);
                request.setAttribute("dtuInfo",null);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "/com/dtuPage";
    }

    /**
     * 进入单位信息管理
     * @return
     */
    @RequestMapping(value = "/goComInfo")
    public String goComInfo(String id,HttpServletRequest request, HttpServletResponse response){
        logger.info("进入信息管理，单位NO："+id);
        Map<String,String> map = new HashedMap();
        map.put("unit_no",id);
        logger.info("请求参数："+map.toString());
        String result = null;
        try {
            result = HttpClientUtil.doHttpPost(ProperUtils.getVal("reqUrl")+Contants.Query_Unit_Info_Url,"UTF-8",map,10000);
            logger.info("返回结果:"+result);
            JSONObject jsonObj = JSON.parseObject(result);
            String state=jsonObj.getString("state");
            if("200".equals(state)){
                Gson gson = new Gson();
                QueryComInfoParam param = gson.fromJson(result, QueryComInfoParam.class);
                ComInfoParam pam = param.getResult();
                logger.info("DTU列表长度："+pam.getDtu().size());
                request.setAttribute("comInfo",pam);
            }else{
                String message=jsonObj.getString("message");
                logger.info("请求失败【message】:"+message);
                request.setAttribute("comInfo","");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("查询公司信息异常.....");
        }
        if("10".equals(SpringContextHolder.getCurrentUser().getResult().getUser_level()+"")){
            return "/com/info";
        }
        return "/com/p_info";
    }

    /**
     *
     * @param unitNo
     * @param unitName
     * @param unitLong
     * @param unitLat
     * @param adress
     * @param tel1
     * @param tel2
     * @param tel3
     * @param tel4
     * @param tel5
     * @param tel6
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/doUpdComInfo.admin")
    public String doUpdComInfo(String unitNo,String unitName,String unitLong,String unitLat,String adress,
                               String tel1,String tel2,String tel3,String tel4,String tel5,String tel6){
        logger.info("修改单位信息："+unitNo);
        logger.info("修改单位信息："+unitName);
        Map<String,String> map = new HashedMap();
        map.put("unit_no",unitNo);
        map.put("unit_name",unitName);
        map.put("unit_long",unitLong);
        map.put("unit_lat",unitLat);
        map.put("unit_adress",adress);
        map.put("unit_tel1",tel1);
        map.put("unit_tel2",tel2);
        map.put("unit_tel3",tel3);
        map.put("unit_tel4",tel4);
        map.put("unit_tel5",tel5);
        map.put("unit_tel6",tel6);
        logger.info("请求参数："+map.toString());
        String result = null;
        try {
            result = HttpClientUtil.doHttpPost(ProperUtils.getVal("reqUrl")+Contants.Update_Unit_Info_Url,"UTF-8",map,10000);
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
     * 进入DTU管理
     * @param id  公司编号
     * @return
     */
    @RequestMapping(value = "/goDTUConfig")
    public String goDTUConfig(String id,HttpServletRequest request){
        logger.info("进入DTU管理界面【unitNo】："+id);
        Map<String,String> map = new HashedMap();
        map.put("unit_no",id);
        logger.info("请求参数："+map.toString());
        try {
            String result = HttpClientUtil.doHttpPost(ProperUtils.getVal("reqUrl")+Contants.Query_Unit_Info2_Url,"UTF-8",map,10000);
            logger.info("返回结果:"+result);
            JSONObject jsonObj = JSON.parseObject(result);
            String state=jsonObj.getString("state");
            if("200".equals(state)){
                JSONArray list = jsonObj.getJSONArray("result");
                logger.info("DTU个数="+list.size());
                request.setAttribute("dtuList",list);
            }else{
                String message=jsonObj.getString("message");
                logger.info("请求失败【message】:"+message);
                request.setAttribute("dtuList","");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/com/DTU";
    }

    /**
     * 进入DTU状态界面
     * @param dtuId
     * @return
     */
    @RequestMapping(value = "/goDTUState")
    @ResponseBody
    public String goDTUState(String dtuId,HttpServletRequest request){
        logger.info("进入DTU状态界面【dtuId】："+dtuId);
        Map<String,String> map = new HashedMap();
        map.put("dtu_sn",dtuId);
        logger.info("请求参数："+map.toString());
        try {
            String result = HttpClientUtil.doHttpPost(ProperUtils.getVal("reqUrl")+Contants.Query_Dtu_State_Url,"UTF-8",map,10000);
            logger.info("返回结果:"+result);
            JSONObject jsonObj = JSON.parseObject(result);
            String state=jsonObj.getString("state");
            if("200".equals(state)){
                JSONArray list = jsonObj.getJSONArray("result");
                logger.info("dtu状态="+list.size());
                Map<String,Object> resultMap = new HashedMap();
                resultMap.put("code","0");
                resultMap.put("list",list);
                resultMap.put("date",jsonObj.getString("dt"));
                return JSONObject.toJSONString(resultMap);
            }else{
                String message=jsonObj.getString("message");
                logger.info("请求失败【message】:"+message);
                Map<String,Object> resultMap = new HashedMap();
                resultMap.put("code","1");
                resultMap.put("list",null);
                resultMap.put("date","");
                return JSONObject.toJSONString(resultMap);
            }

        } catch (Exception e) {
            e.printStackTrace();
            Map<String,Object> resultMap = new HashedMap();
            resultMap.put("code","1");
            resultMap.put("list",null);
            resultMap.put("date","");
            return JSONObject.toJSONString(resultMap);
        }
    }

    /**
     * 进入单位用户管理
     * @return
     */
    @RequestMapping(value = "/goComUser.admin")
    public String goComUser(String id,HttpServletRequest request, HttpServletResponse response){
        logger.info("单位No:"+id);
        Map<String,String> map = new HashedMap();
        map.put("unit_no",id);
        try {
            request.setAttribute("unitNo",id);
            logger.info("请求参数："+map.toString());
            String result = HttpClientUtil.doHttpPost(ProperUtils.getVal("reqUrl")+Contants.QUERY_ALL_USERS_INFO_URL,"UTF-8",map,10000);
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
    @RequestMapping(value = "doDel.admin")
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
            result = HttpClientUtil.doHttpPost(ProperUtils.getVal("reqUrl")+Contants.DEL_USER_URL,"UTF-8",map,10000);
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
    @RequestMapping(value = "/doUpd.admin")
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
            String result = HttpClientUtil.doHttpPost(ProperUtils.getVal("reqUrl")+Contants.UPDATE_USER_INFO_BY_HOST_URL,"UTF-8",map,10000);
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
    @RequestMapping(value = "/doAdd.admin")
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
            String result = HttpClientUtil.doHttpPost(ProperUtils.getVal("reqUrl")+Contants.ADD_USER_URL,"UTF-8",map,10000);
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
    @RequestMapping(value = "/doUpwd.admin")
    public String doUpwd(String user_id,String upass){
        logger.info("修改密码user_Id:"+user_id);
        logger.info("修改密码 upass:"+upass);
        Map<String,String> map = new HashedMap();
        map.put("user_id",user_id);
        map.put("pwd_new",upass);
        map.put("host_user_id",SpringContextHolder.getCurrentUser().getResult().getUser_id());

        logger.info("请求参数："+map.toString());
        try {
            String result = HttpClientUtil.doHttpPost(ProperUtils.getVal("reqUrl")+Contants.UPDATE_USER_PWD_BY_HOST_URL,"UTF-8",map,10000);
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
