package com.frame.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.frame.domain.Constants;
import com.frame.entity.FrUserInfo;
import com.frame.services.IUserInfoService;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhanglm
 * @date 2018年11月23日 上午9:21:47
 * 
 */
@Controller
@Setter
@Slf4j
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private IUserInfoService userInfoService;
	
	
	/**
	 * 登录请求
	 * @param userInfo
	 * @return
	 */
	@RequestMapping(value="/loginIn",method = RequestMethod.GET)
	public String loginIn(FrUserInfo userInfo,String userName,String passWord) {
		log.info("登录信息:"+userInfo.getUserName());
		log.info("登录信息:"+userName);
		return "login";
	}
	
}
