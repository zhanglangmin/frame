package com.frame.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * FR_USERINFO
 * @author 
 */
@Data
public class FrUserInfo implements Serializable {
    private Long id;

    private String userName;

    private String passWord;

    private String address;

    private String status;

    private Date registerTime;

    private String tel;

    private String mobile;

    private String remark;

    private static final long serialVersionUID = 1L;

   
}