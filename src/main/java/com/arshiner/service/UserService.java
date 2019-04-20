package com.arshiner.service;

import com.arshiner.model.UserDomain;
import org.apache.ibatis.annotations.Param;

import java.util.List;
 
/**
 * Created by Administrator on 2018/4/19.
 */
public interface UserService {

    /*登陆*/
    UserDomain loginUser(String userCode);

    /*添加用户*/
    int addUser(UserDomain userDomain);

    /*判定是否为管理员*/
    UserDomain judgeAdmin(String userCode);

    /*用于判定是否存在同名*/
    Integer selUserCode(String userCode);

    /*删除用户*/
    int delUser(String userId);

    /*查询全部用户*/
    List<UserDomain> selAllUserInfo(@Param("before") int before, @Param("after") int after);

    /*查询全部用户(模糊查询0*/
    List<UserDomain> selAllUserInfoByName(@Param("before") int before, @Param("after") int after, @Param("userCode") String userCode);

    /*用户总数(模糊)*/
    int countUserByName(@Param("userCode") String userCode);

    /*用户总数*/
    int countUser();

    /*修改密码（可无）*/
    int updUserPass(String newUserPass, int userId);

}
 
