package com.frame.services;

import java.util.List;

import com.frame.entity.FrUserInfo;

import com.frame.entity.FrUserInfo;

/**
 * @author zhanglm
 * @date 2018年11月21日 下午1:37:10
 * 
 */


public interface IUserInfoService {

	public int insertUserInfo(FrUserInfo userInfo);
	
	public List<FrUserInfo> selectByList(FrUserInfo userInfo);
	
	public int deleteUserInfoById(Integer id);
}
