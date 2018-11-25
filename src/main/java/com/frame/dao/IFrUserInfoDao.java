package com.frame.dao;

import com.frame.entity.FrUserInfo;
import java.util.List;



public interface IFrUserInfoDao {
	
	/**
	 * 	保存用户
	 * @param userInfo
	 * @return
	 */
	int insert(FrUserInfo userInfo);
	
	List<FrUserInfo> selectByList(FrUserInfo userInfo);
	
	int deleteById(Integer id);
	
	int countByUserInfo(FrUserInfo userInfo);
}