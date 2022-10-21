package com.zgj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/*
@Controller: 创建处理对象,对象放在springmvc容器中
位置 :在类上面
和spring中讲的@Service,@Component

能够处理请求都是控制器(处理器):
        MyController能处理请求,叫做后端控制器(back)
* 能够处理请求的都是
* */
@Controller
public class MyControl {

    /*
        处理用户提交的请求,springmvc中是使用方法来处理的
        方法是自定义的,可以有多重返回值,多种参数,方法名自定义
     */


    /*
    * 准备使用doSome()方法处理some.do请求
    * @RequestMapping: 请求映射 作用是把一个请求地址和一个uri绑定在一起
    *                   uri:统一资源定位符  -->一个请求指定给一个方法处理
    *       属性: 1.value 是一个String[],表示请求的uri地址
    *               value的值必须唯一 ,在使用时 推荐地址以 "/"
    *       位置: 1. 方法之上 常用
    *               2. 类之上
    * 说明: 使用RequestMapping修饰的方法叫做处理器方法或者控制器方法
    * 使用@RequestMapping修饰的方法可以处理请求,类似于Servlet中的doGet/doPost
    *
    * 返回值: ModelAndView 表示本次请求处理的结果
    *   Model: 数据,请求处理完成后,要显示给用户的数据
    *   View: 视图,比如JSP等
    * */

    @RequestMapping(value = "/some.do")  //uri
    public ModelAndView  doSome(){  //doGet
        //处理some.do请求  service调用请求暂时完成 继续后面的步骤
        ModelAndView modelAndView = new ModelAndView();
        //添加数据,框架在请求的最后把数据放到request作用域中
        //request.setAttribute("msg","欢迎使用springmvc");
        modelAndView.addObject("msg","欢迎使用springmvc");
        modelAndView.addObject("fun","执行的是doSome方法");

        //指定视图,指定视图的完整路径
        //框架对视图执行的是请求转发
        //request.getRequestDispatcher("/show.jsp").forward(request,response)
        modelAndView.setViewName("/show.jsp");

        //返回mv
        return modelAndView;
    }
}
