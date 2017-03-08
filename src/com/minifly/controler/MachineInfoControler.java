package com.minifly.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.minifly.utils.MachineUtils;

@Controller
@RequestMapping("/machine")
public class MachineInfoControler {
	//从数据库中查询照片的信息 将数据库中有的照片和人返回一个数组
	@RequestMapping(value = "/info", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String getMainPage() {
		ObjectMapper objectMapper = new ObjectMapper();

		MachineUtils machine = MachineUtils.getInstance();
		
		try {
			return objectMapper.writeValueAsString(machine);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "" + machine.toString();
	}
}
