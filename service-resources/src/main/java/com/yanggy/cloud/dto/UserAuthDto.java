package com.yanggy.cloud.dto;

import java.io.Serializable;

import lombok.Data;


@Data
public class UserAuthDto implements Serializable{

	private static final long serialVersionUID = 1626130950667667435L;
	private long userId;
    private  String username;
    private  String email;
    private  String phone;
    private  String avater;
}
