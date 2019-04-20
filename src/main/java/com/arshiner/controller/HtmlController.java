package com.arshiner.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author mdk
 * @Date: 10:21 2018/11/14
 * 用于页面跳转
 */
@Controller
@RequestMapping(value = "/")
public class HtmlController {

    /*登陆页面*/
    @RequestMapping("/")
    public String openLoginHtml() {
        return "login";
    }

    /*主页面*/
    @RequestMapping("/index")
    public String indexHtml(){
        return "index";
    }
}
