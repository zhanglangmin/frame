package com.frame.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhanglm
 * @date 2018年11月27日 上午11:10:47
 * 
 */
@Controller
@Slf4j
@RequestMapping("/main")
public class MainController {

	@RequestMapping("/index")
	public String home() {
		
		return "index";
	}
}
