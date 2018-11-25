package com.frame.web;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import com.frame.domain.JsonResult;
import com.frame.entity.FrUserInfo;
import com.frame.services.IUserInfoService;

import lombok.Setter;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class HelloControllerTest {
	
	@Autowired
	private IUserInfoService userService;
	
//	@Autowired
//	private WebApplicationContext context;
//	
//	private MockMvc mockMvc;
//	 
//	@Before
//	public void setupMockMvc() throws Exception {
//		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
//	}


	
	
	
	    @Test
	    public void hello()  
	    {  
//		 	FrUserInfo userInfo=new FrUserInfo();
//		 	userInfo.setUsername("zhangsan");
//		 	userInfo.setPassword("123456");
//		 	userService.insertUserInfo(userInfo);
	    	userService.deleteUserInfoById(19);
	        System.out.println("成功");
	    }  
}
