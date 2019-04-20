package com.arshiner.service.impl;


import com.arshiner.dao.UserMapper;
import com.arshiner.model.UserDomain;
import com.arshiner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import java.util.List;
 
/**
 * Created by Administrator on 2017/8/16.
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper; //这里会报错，但是并不会影响


    @Override
    public UserDomain loginUser(String userCode) {
        return userMapper.loginUser(userCode);
    }

    @Override
    public int addUser(UserDomain userDomain) {
        return userMapper.addUser(userDomain);
    }

    @Override
    public UserDomain judgeAdmin(String userCode) {
        return userMapper.judgeAdmin(userCode);
    }

    @Override
    public Integer selUserCode(String userCode) {
        return userMapper.selUserCode(userCode);
    }

    @Override
    public int delUser(String userId) {
        return userMapper.delUser(userId);
    }

    @Override
    public List<UserDomain> selAllUserInfoByName(int before, int after, String userCode) {
        return userMapper.selAllUserInfoByName(before,after,userCode);
    }

    @Override
    public int countUserByName(String userCode) {
        return userMapper.countUserByName(userCode);
    }

    @Override
    public List<UserDomain> selAllUserInfo(int before, int after) {
        return userMapper.selAllUserInfo(before, after);
    }

    @Override
    public int countUser() {
        return userMapper.countUser();
    }

    @Override
    public int updUserPass(String newUserPass, int userId) {
        return userMapper.updUserPass(newUserPass, userId);
    }

    /* *//*
    * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
    * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
    * pageNum 开始页数
    * pageSize 每页显示的数据条数
    * *//*
    @Override
    public List<UserDomain> findAllUser(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<UserDomain> userDomains = userDao.selectUserList();
        return userDomains;
    }*/
}
 
