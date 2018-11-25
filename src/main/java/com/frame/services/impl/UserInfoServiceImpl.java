package com.frame.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frame.dao.IFrUserInfoDao;
import com.frame.entity.FrUserInfo;
import com.frame.services.IUserInfoService;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhanglm
 * @date 2018年11月21日 下午1:37:44
 * 
 */

@Getter
@Setter
@Slf4j
@Service
public class UserInfoServiceImpl implements IUserInfoService{

	@Autowired
	private IFrUserInfoDao userDao;

	@Override
	public int insertUserInfo(FrUserInfo userInfo) {
		log.info("保存用户信息");
		userDao.insert(userInfo);
		return 0;
	}

	@Override
	public List<FrUserInfo> selectByList(FrUserInfo userInfo) {
		// TODO Auto-generated method stub
		log.info("查找用户信息");
		return userDao.selectByList(userInfo);
	}

	@Override
	public int deleteUserInfoById(Integer id) {
		userDao.deleteById(id);
		return 0;
	}
}
