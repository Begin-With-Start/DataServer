package com.minifly.controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.rpc.ServiceException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.minifly.bean.BaseBean;
import com.minifly.bean.MeizhiImageBean;
import com.minifly.bean.PhotoBean;
import com.minifly.dbutil.MeizhiDbutils;
import com.minifly.dbutil.PhotoDbutils;
/**
 * @Controller 负责注册一个bean 到spring 上下文中 　　 *@RequestMapping 注解为控制器指定可以处理哪些
 * @author Administrator
 *
 */

@Controller
@RequestMapping("/meizhi")
public class MeizhiControler {

	// redirect 在Controller中使用redirect方式处理请求
	@RequestMapping("/redirect")
	public String redirect() {
		return "redirect:hello";
	}

	//从数据库中查询照片的信息 将数据库中有的照片和人返回一个数组
	@RequestMapping(value = "/getMeizhiAlbum", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String getMeizhiImage(@RequestParam(value="page")  String page) {
		ObjectMapper objectMapper = new ObjectMapper();

		List<MeizhiImageBean> list = MeizhiDbutils.getMeizhiImageAlbum(page);
		BaseBean bean = new BaseBean();
		bean.setData(list);
		
		try {
			return objectMapper.writeValueAsString(bean);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			bean.setMsg("json转换失败");
			bean.setCode("1");
		}
		return ""+bean.toString(); 
	}
	
	//查询parentid下的所有的妹纸的图片.
	@RequestMapping(value = "/getMeizhiImageById", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String getMeizhiImageById(@RequestParam(value="id")  String id) {
		ObjectMapper objectMapper = new ObjectMapper();

		List<MeizhiImageBean> list = MeizhiDbutils.getMeizhiById(id);
		BaseBean bean = new BaseBean();
		bean.setData(list);
		
		try {
			return objectMapper.writeValueAsString(bean);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			bean.setMsg("json转换失败");
			bean.setCode("1");
		}
		return ""+bean.toString(); 
	}

	//从数据库中查询某一个人的照片的信息
	@RequestMapping(value = "/getMeizhiVideo", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String getPersonPhoto(@RequestParam(value="userId")  String userId) {
		ObjectMapper objectMapper = new ObjectMapper();

		List<PhotoBean> list = PhotoDbutils.getPohotoById(userId);
		BaseBean bean = new BaseBean();
		bean.setData(list);
		
		try {
			return objectMapper.writeValueAsString(bean);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			bean.setMsg("json转换失败");
			bean.setCode("1");
		}
		return "" + bean.toString();
	}
	
	//异常处理
	@ExceptionHandler(Exception.class)
	@ResponseBody
    public String handleError(HttpServletRequest req, Exception exception) {
      
      Integer code = 500;
      String msg = exception.getMessage();
      if(exception instanceof ServiceException) {
          msg = exception.getMessage();
          code = 10001;
      }else if (exception instanceof IOException) {
          msg = "文件读写异常!";
      }else if (exception instanceof DataIntegrityViolationException) {
          msg = "提交数据异常!";
      }else{
    	  msg = "系统出了点小故障";
      }
      BaseBean error = new BaseBean();
      error.setMsg(exception.getMessage());
      error.setCode(code+"");
      error.setData("");
      
      return error.toString();
    }
}
