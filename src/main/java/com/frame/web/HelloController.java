package com.frame.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.frame.domain.JsonResult;
import com.frame.entity.FrUserInfo;
import com.frame.services.IUserInfoService;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

//@RestController
@Controller
@Setter
@Slf4j
public class HelloController {
	@Autowired
	private IUserInfoService userService;
	 @RequestMapping("/greeting")  
	    public String hello(Model model)  
	    {  
//		 	FrUserInfo userInfo=new FrUserInfo();
//		 	userInfo.setUsername("zhangsan");
//		 	userInfo.setPassword("123456");
//		 	userService.insertUserInfo(userInfo);
		 	log.info("进入方法");
//		 	ModelAndView model=new ModelAndView();
//		 	model.setViewName("main");
		 	model.addAttribute("message", "这是信息");
//            model.addAttribute("title", "用户管理");
//            return new ModelAndView("index", "userModel", model);
//		 	
//		 	Locale locale = LocaleContextHolder.getLocale();
//		 	locale.
//	        model.addAttribute("world", messageSource.getMessage("world", null, locale));
		 	
//		 	Locale locale = LocaleContextHolder.getLocale();
//	        model.addAttribute("message", messageSource.getMessage("page.welcome", null, locale));

		 	FrUserInfo userInfo=new FrUserInfo();
		 	userInfo.setUserName("请输入用户名!");
		 	userInfo.setPassWord("请输入密码!");
		 	model.addAttribute("userInfo",userInfo);
		 	
		 	return "login";
	    }  
}
