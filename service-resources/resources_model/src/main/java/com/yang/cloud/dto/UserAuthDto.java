package com.yang.cloud.dto;

import lombok.Data;

import java.io.Serializable;


@Data
public class UserAuthDto implements Serializable{

	private static final long serialVersionUID = 1626130950667667435L;
	private long userId;
    private  String username;
    private  String email;
    private  String phone;
    private  String avater;
}
