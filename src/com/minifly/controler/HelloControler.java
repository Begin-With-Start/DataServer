package com.minifly.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mvc")
public class HelloControler {
	/**
	*@Controller 负责注册一个bean 到spring 上下文中
　　	*@RequestMapping 注解为控制器指定可以处理哪些 URL 请求
	*/
//    @RequestMapping("/hello")
//    public String hello(){        
//        return "hello";
//    }
    
    //redirect 在Controller中使用redirect方式处理请求
    @RequestMapping("/redirect")
    public String redirect(){
        return "redirect:hello";
    }
    
    //使用@RequestParam注解指定参数的name
    @Controller
    @RequestMapping("/test")
    public class mvcController1 {
        @RequestMapping(value="/param")
        public String testRequestParam(@RequestParam(value="id") Integer id,
                @RequestParam(value="name")String name){
            System.out.println(id+" "+name);
            return "/hello";
        }    
    }
    
    @RequestMapping("/hello")
    @ResponseBody
    public String get(){        
        return "{'ha':'hhhh'}";
    }
    
}
