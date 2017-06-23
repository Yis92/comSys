package com.sixe.comSys.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.sixe.comSys.base.Contants;
import com.sixe.comSys.base.SpringContextHolder;
import com.sixe.comSys.base.imgCode.ValidateCode;
import com.sixe.comSys.dto.DoLogin.DoLoginParam;
import com.sixe.comSys.dto.QueryDtuGroupDataInfo.QueryDtuGroupDataParm;
import com.sixe.comSys.dto.QueryDtuGroupingInfo.QueryDtuGroupingInfoParam;
import com.sixe.comSys.dto.QueryDtuHisData.HisDataParm2;
import com.sixe.comSys.dto.QueryDtuHisData.QueryDtuHisDataParm;
import com.sixe.comSys.dto.QueryDtuHisData.QueryDtuHisDataParm2;
import com.sixe.comSys.service.DtuQueryService;
import com.sixe.comSys.utils.HttpTools;
import com.sixe.comSys.utils.ProperUtils;
import com.sixe.comSys.utils.Tools;
import com.sun.istack.internal.logging.Logger;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;


/**
 * Created by labiStronger on 2017/2/24.
 */
@Controller
@RequestMapping(value = "/home")
public class HomeController {

    private static final Logger logger = Logger.getLogger(HomeController.class);

    @Autowired
    private DtuQueryService dtuQueryService;
    /**
     * 进入登录页...
     * @return
     */
    @RequestMapping(value="login")
    public String login(){
        logger.info("进入登录页...");
        System.out.println("进入登录页...");
        return "/login";
    }
    
    /**
     * 图片验证码
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/randomImg")
    public void randomImg(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 设置响应的类型格式为图片格式
        response.setContentType("image/jpeg");
        //禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        ValidateCode vCode = new ValidateCode(120,40,4,60,response);
        vCode.write(response.getOutputStream());
        System.out.println("Code::"+vCode.getCode());
        request.getSession().setAttribute("code", vCode.getCode());
    }

    /**
     * 验证图片验证码
     * @param code
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/checkCode")
    public String checkCode(String code,HttpServletRequest request, HttpServletResponse response){
        String sessionCode = (String) request.getSession().getAttribute("code");
		/*设置不区分大小写  全部转为大写比较*/
        String newSessionCode = sessionCode.toUpperCase();
        String newCode = code.toUpperCase();
        if(newSessionCode.equals(newCode)){
            return Tools.sendJson("SUC");
        }
        return Tools.sendJson("FIL");
    }

    /**
     * 执行登录操作
     * @param user_id
     * @param pwd
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/doLogin")
    public String doLogin(String user_id,String pwd){
        logger.info("登录名【userId】:"+user_id);
        logger.info("密码【pwd】:"+pwd);
        Map<String,Object> map = new HashedMap();
        map.put("user_id",user_id);
        map.put("pwd",pwd);
        logger.info("请求参数："+map.toString());
        String result = HttpTools.sendPost(ProperUtils.getVal("reqUrl")+Contants.Do_Login_Url,map);
        logger.info("返回结果："+result);

        JSONObject jsonObj = JSON.parseObject(result);
        String state=jsonObj.getString("state");

        if("200".equals(state)){
            //登录成功...
            logger.info("登录成功...");
            Gson gson = new Gson();
            DoLoginParam param = gson.fromJson(result,DoLoginParam.class);
            logger.info("user_level:"+param.getResult().getUser_level());
            logger.info("units的长度："+param.getResult().getUnits().size());
            logger.info("dtus的长度："+param.getResult().getUnits().get(0).getDtu().size());
            //登录成功 保存Session
            SpringContextHolder.getSession().setAttribute(Contants.USER_SESSION_INFO,param);
            return Tools.sendJson("SUC");
        }
        String message = jsonObj.getString("message");
        logger.info("登录失败【message】:"+message);
        return Tools.sendJson(message);
    }

    @RequestMapping(value = "/exit")
    public String exit(HttpServletRequest request,
                       HttpServletResponse response){
        Enumeration e = SpringContextHolder.getSession().getAttributeNames();
        while (e.hasMoreElements()){
            SpringContextHolder.getRequest().getSession().removeAttribute(e.nextElement().toString());
        }
        return "redirect:/home/login";
    }

    @RequestMapping(value = "/permissionDenied")
    public String permissionDenied(){
        logger.info("用户权限不足.....");
        return "/err/permissionDenied";
    }


    /**
     * 进入历史数据页面
     * @param nodeId
     * @param pId
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/goHisPage")
    public String goHisPage(String nodeId,String pId,String groupId,HttpServletRequest request, HttpServletResponse response){
        logger.info("goHisPage【nodeId】:"+nodeId);
        logger.info("goHisPage【pId】:"+pId);
        if("".equals(groupId) || groupId == null){
            return "";
        }

        Map<String,String> map = new HashedMap();
        map.put("dtu_sn",nodeId);
        map.put("group_id",groupId);
        logger.info("请求参数："+map.toString());
        QueryDtuGroupingInfoParam odata = dtuQueryService.QueryDtuGroupingDataDisplay(map);
        //QueryDtuGroupDataParm odata = dtuQueryService.QueryDtuGroupDataInfo(map);
        request.setAttribute("groupDataList",odata.getResult().getGroupdata());
        request.setAttribute("dtu_sn",nodeId);
        request.setAttribute("pId",pId);
        return "/dtu/data/m2hisData";
    }

    @RequestMapping(value = "/hisTest")
    public String hisTest(String nodeId,String pId,HttpServletRequest request, HttpServletResponse response){
        logger.info("hisTest【nodeId】:"+nodeId);
        logger.info("hisTest【pId】:"+pId);
        Map<String,String> map = new HashedMap();
        map.put("dtu_sn",nodeId);
        logger.info("请求参数："+map.toString());
        QueryDtuGroupDataParm odata = dtuQueryService.QueryDtuGroupDataInfo(map);
        request.setAttribute("groupDataList",odata.getResult());
        request.setAttribute("dtu_sn",nodeId);
        request.setAttribute("pId",pId);
        return "/dtu/data/hisTest";
    }

    /**
     * 历史数据查询
     * @param dtu_sn
     * @param pId
     * @param startDate
     * @param endDate
     * @param dataType
     * @return
     */
   /* @ResponseBody
    @RequestMapping(value = "/getHisData",method = RequestMethod.POST)
    public String getHisData(String dtu_sn,String pId,String startDate,String endDate,String dataType){
        System.out.println("选择要素【pId】:"+pId);

        Map<String,Object> rtMap = new HashedMap();
        if("".equals(pId)||pId == null){
            rtMap.put("seriesList",new ArrayList<Map<String, Object>>());
            rtMap.put("timeData",new ArrayList<String>());

            rtMap.put("legendData",new String[0]);
            rtMap.put("yAxisName","");
            rtMap.put("yMax","");
            rtMap.put("yMin","");
            rtMap.put("suc","SUC");
            return Tools.sendJson(rtMap);
        }

        String [] arr = pId.split(",");
        int arrSize = arr.length;
        //请求参数
        Map<String,String> map = new HashedMap();
        map.put("dtu_sn",dtu_sn);
        for(int i = 1 ;i<=arr.length; i++){
            map.put("data_no"+i,arr[i-1]);
        }
        map.put("data_num",arrSize+"");
        map.put("start_dt",startDate);
        map.put("end_dt",endDate);
        map.put("data_type",dataType);
        map.put("disp_type","1");
        logger.info("请求参数："+map.toString());
        QueryDtuHisDataParm2 parm = dtuQueryService.QueryDtuHisDataDisplay2(map);

        if("200".equals(parm.getState())){
            List<String> timeData = new ArrayList<String>();//时间x轴
            List<List<String>> dataList = new ArrayList<List<String>>();
            String yAxisName ="("+parm.getResult().getUnitName()+")";//y轴单位    parm.getResult().getyAxisName();
            String yMax = parm.getResult().getMax();    //最大值
            String yMin = parm.getResult().getMin();    //最小值
            List<Map<String,Object>> mapList = new ArrayList<Map<String, Object>>();

            for(int i=0;i<arrSize;i++){
                dataList.add(new ArrayList<String>());
            }

            for(int n=0;n<parm.getResult().getResult().size();n++){
                timeData.add(parm.getResult().getResult().get(n).getDate());
                for(int i=0;i<parm.getResult().getResult().get(n).getValue().size();i++){
                    dataList.get(i).add(parm.getResult().getResult().get(n).getValue().get(i));
                }
            }

            String [] legendData = new String[arrSize];
            for(int i=0;i<parm.getResult().getyAxisName().size();i++){
                Map<String,Object> seriesMap = new HashedMap();
                legendData[i]=parm.getResult().getyAxisName().get(i);
                seriesMap.put("name",parm.getResult().getyAxisName().get(i));
                seriesMap.put("type","line");
                seriesMap.put("symbolSize",8);//hoverAnimation
                seriesMap.put("hoverAnimation",false);
                seriesMap.put("data",dataList.get(i));
                mapList.add(seriesMap);
            }

            rtMap.put("seriesList",mapList);
            rtMap.put("timeData",timeData);

            rtMap.put("legendData",legendData);
            rtMap.put("yAxisName",yAxisName);

            rtMap.put("yMax",yMax);
            rtMap.put("yMin",yMin);
            rtMap.put("suc","SUC");
            return Tools.sendJson(rtMap);
        }

        rtMap.put("seriesList",new ArrayList<Map<String, Object>>());
        rtMap.put("timeData",new ArrayList<String>());

        rtMap.put("legendData",new String[0]);
        rtMap.put("yAxisName","");
        rtMap.put("yMax","");
        rtMap.put("yMin","");
        rtMap.put("suc","SUC");
        return Tools.sendJson(rtMap);
    }*/

    @ResponseBody
    @RequestMapping(value = "/getHisData",method = RequestMethod.POST)
    public String getHisData(String dtu_sn,String pId,String startDate,String endDate,String dataType){
        //String [] timeData = {};
        List<String> timeData = new ArrayList<String>();

        List<String> data = new ArrayList<String>();
        //String [] data = {};
        String [] legendData = new String[1];
        String yAxisName = "";
        String seriesName = "";
        String yMax = "";
        String yMin = "";
        System.out.println("手机端请求....");
        Map<String,Object> rtMap = new HashedMap();
        Map<String,String> map = new HashedMap();
        map.put("dtu_sn",dtu_sn);
        map.put("data_no",pId);
        map.put("start_dt",startDate);
        map.put("end_dt",endDate);
        map.put("data_type",dataType);
        map.put("disp_type","1");
        logger.info("请求参数："+map.toString());
        QueryDtuHisDataParm parm = dtuQueryService.QueryDtuHisDataDisplay(map);

        if("200".equals(parm.getState())){
            System.out.println("手机端请求成功...");
            yAxisName = parm.getResult().getyAxisName();
            seriesName = yAxisName +"("+parm.getResult().getUnitName()+")";
            legendData[0] = parm.getResult().getTitle();
            yMax = parm.getResult().getMax();
            yMin = parm.getResult().getMin();
            for(int i = 0;i<parm.getResult().getResult().size();i++){
                timeData.add(parm.getResult().getResult().get(i).getDate());
                data.add(parm.getResult().getResult().get(i).getValue());
            }
        }

        rtMap.put("timeData",timeData);
        rtMap.put("data",data);

        rtMap.put("legendData",legendData);
        rtMap.put("yAxisName",yAxisName);

        rtMap.put("seriesName",seriesName);
        rtMap.put("yMax",yMax);
        rtMap.put("yMin",yMin);
        rtMap.put("suc","SUC");

        System.out.println(rtMap.toString());
        return Tools.sendJson(rtMap);
    }



    @ResponseBody
    @RequestMapping(value = "/getHisData2",method = RequestMethod.POST)
    public String getHisData2(String dtu_sn,String pId,String startDate,String endDate,String dataType){
        System.out.println("选择要素【pId】:"+pId);

        Map<String,Object> rtMap = new HashedMap();
        if("".equals(pId)||pId == null){
            List<Map<String,Object>> mapList = new ArrayList<Map<String, Object>>();
            Map<String,Object> seriesMap = new HashedMap();
            seriesMap.put("name","");
            seriesMap.put("type","line");
            seriesMap.put("symbolSize",8);//hoverAnimation
            seriesMap.put("hoverAnimation",false);
            seriesMap.put("data",new ArrayList<String>());
            mapList.add(seriesMap);
            rtMap.put("seriesList",mapList);
            rtMap.put("timeData",new ArrayList<String>());

            rtMap.put("legendData",new String[0]);
            rtMap.put("yAxisName","");
            rtMap.put("yMax","");
            rtMap.put("yMin","");
            rtMap.put("suc","SUC");
            return Tools.sendJson(rtMap);
        }

        String [] arr = pId.split(",");
        int arrSize = arr.length;
        //请求参数
        Map<String,String> map = new HashedMap();
        map.put("dtu_sn",dtu_sn);
        for(int i = 1 ;i<=arr.length; i++){
            map.put("data_no"+i,arr[i-1]);
        }
        map.put("data_num",arrSize+"");
        map.put("start_dt",startDate);
        map.put("end_dt",endDate);
        map.put("data_type",dataType);
        map.put("disp_type","1");
        logger.info("请求参数："+map.toString());
        QueryDtuHisDataParm2 parm = dtuQueryService.QueryDtuHisDataDisplay2(map);

        if(parm == null){
           // System.out.println("######系统异常");
            rtMap.put("suc","FIL");
            return Tools.sendJson(rtMap);
        }

        // Map<String,Object> rtMap = new HashedMap();
        if("200".equals(parm.getState())){
            List<String> timeData = new ArrayList<String>();//时间x轴
            List<List<String>> dataList = new ArrayList<List<String>>();
            // String yAxisName ="("+parm.getResult().getUnitName()+")";//y轴单位    parm.getResult().getyAxisName();
            String yMax = parm.getResult().getMax();    //最大值
            String yMin = parm.getResult().getMin();    //最小值
            List<Map<String,Object>> mapList = new ArrayList<Map<String, Object>>();

            for(int i=0;i<arrSize;i++){
                dataList.add(new ArrayList<String>());
            }

            for(int n=0;n<parm.getResult().getResult().size();n++){
                timeData.add(parm.getResult().getResult().get(n).getDate());
                for(int i=0;i<parm.getResult().getResult().get(n).getValue().size();i++){
                    dataList.get(i).add(parm.getResult().getResult().get(n).getValue().get(i));
                }
            }
            System.out.println();
            String [] legendData = new String[arrSize];
            for(int i=0;i<parm.getResult().getyAxisName().size();i++){
                Map<String,Object> seriesMap = new HashedMap();
                legendData[i]=parm.getResult().getyAxisName().get(i)+"("+parm.getResult().getUnitName().get(i)+")";
                seriesMap.put("name",parm.getResult().getyAxisName().get(i)+"("+parm.getResult().getUnitName().get(i)+")");
                seriesMap.put("type","line");
                seriesMap.put("symbolSize",8);//hoverAnimation
                seriesMap.put("hoverAnimation",false);
                seriesMap.put("data",dataList.get(i));
                System.out.println();
                mapList.add(seriesMap);
            }

            rtMap.put("seriesList",mapList);
            rtMap.put("timeData",timeData);

            rtMap.put("legendData",legendData);
            rtMap.put("yAxisName","");

            rtMap.put("yMax",yMax);
            rtMap.put("yMin",yMin);
            rtMap.put("suc","SUC");
            return Tools.sendJson(rtMap);

        }

        rtMap.put("seriesList",new ArrayList<Map<String, Object>>());
        rtMap.put("timeData",new ArrayList<String>());

        rtMap.put("legendData",new String[0]);
        rtMap.put("yAxisName","");
        rtMap.put("yMax","");
        rtMap.put("yMin","");
        rtMap.put("suc","SUC");
        return Tools.sendJson(rtMap);
    }
}
