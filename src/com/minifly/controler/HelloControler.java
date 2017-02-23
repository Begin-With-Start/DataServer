package com.minifly.controler;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.minifly.bean.MobileNeedBean;
import com.minifly.db.DBHelper;
/**
 * @Controller 负责注册一个bean 到spring 上下文中 　　 *@RequestMapping 注解为控制器指定可以处理哪些
 * @author Administrator
 *
 */

@Controller
@RequestMapping("/mvc")
public class HelloControler {

	// redirect 在Controller中使用redirect方式处理请求
	@RequestMapping("/redirect")
	public String redirect() {
		return "redirect:hello";
	}

	// 使用@RequestParam注解指定参数的name
	@RequestMapping(value = "/param")
	public String testRequestParam(@RequestParam(value = "id") Integer id,
			@RequestParam(value = "name") String name) {
		System.out.println(id + " " + name);
		return "/hello";
	}

	@RequestMapping(value = "/hello", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String get() {
		ObjectMapper objectMapper = new ObjectMapper();

		Connection con = DBHelper.getConnection();
		try {
			con.getMetaData();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		try {
			return objectMapper.writeValueAsString(new MobileNeedBean());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "{'ha':'hhhh'}";
	}

}
