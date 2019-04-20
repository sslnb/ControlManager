package com.arshiner.controller;


import com.alibaba.fastjson.JSONArray;
import com.arshiner.model.UserDomain;
import com.arshiner.service.UserService;
import com.arshiner.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mdk
 * @Date: ${TIME} ${DATE}
 * @Description: 用户信息的后台处理
 */
@Controller
@RequestMapping(value = "/userController")
public class UserController {
 
    @Autowired
    private UserService userService;
    /*
    * 登陆
    * */
    @ResponseBody
    @RequestMapping("/loginUser")
    public Object loginUser(UserDomain userDomain,HttpSession session){
        Map<String,Object> userMap = new HashMap<String,Object>();
        UserDomain userInfo = userService.loginUser(userDomain.getUserCode());
        if (userInfo==null){
            userMap.put("login","false");
        }else{
        	String pass = userInfo.getUserPass();     //该用户密码
        	String mdpass =MD5.getMD5(userDomain.getUserPass());       //输入密码
            if (pass.equals(mdpass)){
                //意为登陆成功，将用户信息存入session
                session.setAttribute("userInfo",userInfo);
                session.setAttribute("pd","value11121");
                userMap.put("login","true");
            }else{
                userMap.put("login","false");
            }
        }
        /*System.out.println(session.getAttribute("userInfo"));
        System.out.println(session.getAttribute("pd"));
        System.out.println(session.getAttribute("userInfo"));

        System.out.println("****");*/
        return JSONArray.toJSONString(userMap);
    }

    /*
    * 判定是否为管理员
    * */
    @ResponseBody
    @RequestMapping("/judgeAdmin")
    public Object judgeAdmin(@RequestParam(value="inUserCode") String userCode,HttpSession session){
        //可用
        Object obj = session.getAttribute("userInfo");
        Map<String,Object> judgeMap = new HashMap<String,Object>();
        UserDomain userDomain = userService.judgeAdmin(userCode);
        if (userCode==""){
            judgeMap.put("judge","false");
        }else {
            if (userDomain.equals(null)){
                judgeMap.put("judge","false");
            }else{
                if (userDomain.getUserRole().equals("1")){
                    judgeMap.put("judge","true");
                }else{
                    judgeMap.put("judge","false");
                }
            }
        }

        return JSONArray.toJSONString(judgeMap);
    }

    /*
    * 创建用户(userRole为管理员时可进行此操作(即"1"))
    * */
    @ResponseBody
    @RequestMapping("/addUser")
    public Object addUser(UserDomain userDomain,HttpSession session){
        UserDomain sessionUser = (UserDomain) session.getAttribute("userInfo");     //查询session中的值
        Map<String,Object> addMap = new HashMap<String,Object>();       //用户存放返回的json数据
        if (sessionUser.getUserRole().equals("1")){
            //可执行创建操作
            String userCode = userDomain.getUserCode();
            String userPass = userDomain.getUserPass();
            if (userService.selUserCode(userCode)==0){
                //String passMD5 = MD5.getMD5(userPass);
                //对userPass进行MD5加密操作,然后创建为新的对象执行添加操作
                UserDomain newUserDomain = new UserDomain();
                newUserDomain.setUserCode(userCode);
                newUserDomain.setUserPass(MD5.getMD5(userPass));
                newUserDomain.setUserRole("2");
                //执行添加操作的方法
                int pdNum = userService.addUser(newUserDomain);
                if (pdNum>0) {
                    //添加成功后  刷新前端表格中的数据   1.调用查询用户列表的方法   2.前端ajax中在套用一层ajax访问  <有数据时再做调整>
                    addMap.put("add","true");
                }else{
                    addMap.put("add","false");
                }
            }else{
                //这里可用作判定同名的标示<可有可无>
                addMap.put("add","same");
            }
        }else{
            addMap.put("add","noAdmin");
        }

        return JSONArray.toJSONString(addMap);
    }

    /*
    * 查询用户列表    <前端使用Layui的js方法加载数据,所以这里Map返回格式有所差异>
    * */
    @ResponseBody
    @RequestMapping(value = "/selAllUserInfo" )
    public Object selAllUserInfo(@RequestParam("page") String page1, @RequestParam("limit")String limit1, HttpServletResponse response){
        response.setContentType("application/json;charset=utf-8");
        int page = Integer.valueOf(page1);
        int limit = Integer.valueOf(limit1);
        int before = limit * (page - 1) + 1;
        int after = page * limit;
        List<UserDomain> userList = userService.selAllUserInfo(before,after);
        HashMap<String,Object> userInfoMap = new HashMap<String,Object>();
        userInfoMap.put("code",0);
        userInfoMap.put("msg", "");
        userInfoMap.put("count",userService.countUser());       //调用方法查询全部
        Object arry = JSONArray.toJSON(userList);
        userInfoMap.put("data",arry);
        return JSONArray.toJSONString(userInfoMap);
    }


    /*
     * 查询用户列表(模糊查询) <前端使用Layui的js方法加载数据,所以这里Map返回格式有所差异>
     * */
    @ResponseBody
    @RequestMapping(value = "/selAllUserInfoByName" )
    public Object selAllUserInfoByName(@RequestParam("page") String page1, @RequestParam("limit")String limit1,@RequestParam("userCode")String userCode, HttpServletResponse response){
        response.setContentType("application/json;charset=utf-8");
        int page = Integer.valueOf(page1);
        int limit = Integer.valueOf(limit1);
        int before = limit * (page - 1) + 1;
        int after = page * limit;
        List<UserDomain> userList = userService.selAllUserInfoByName(before,after,userCode);
        HashMap<String,Object> userInfoMap = new HashMap<String,Object>();
        userInfoMap.put("code",0);
        userInfoMap.put("msg", "");
        userInfoMap.put("count",userService.countUserByName(userCode));       //调用方法查询全部
        Object arry = JSONArray.toJSON(userList);
        userInfoMap.put("data",arry);
        return JSONArray.toJSONString(userInfoMap);
    }


    /*
    * 删除用户
    * */
    @ResponseBody
    @RequestMapping("/delUser")
    public Object delUser(@RequestParam(value = "userId") String userId,HttpSession session){
        UserDomain sessionUser = (UserDomain) session.getAttribute("userInfo");     //查询session中的值
        Map<String,Object> delMap = new HashMap<String,Object>();
        //判定是否为管理员
        if (sessionUser.getUserRole().equals("1")){
            if (userService.delUser(userId)>0){
                delMap.put("del","true");
            }else{
                delMap.put("del","false");
            }
        }else{
            delMap.put("del","noAdmin");
        }
        return JSONArray.toJSONString(delMap);
    }

}
 
