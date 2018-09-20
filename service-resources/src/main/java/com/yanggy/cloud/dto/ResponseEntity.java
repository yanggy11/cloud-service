package com.yanggy.cloud.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: yangguiyun
 * @Date: 2017/10/17 14:59
 * @Description:
 */

@Data
public class ResponseEntity<T> implements Serializable {
    
	private static final long serialVersionUID = -5595517960658263529L;
	private String status = "1";
    private String msg = "load successfully";
    private T data;
    private String code = "00000000";
    public ResponseEntity(){

    }

    public ResponseEntity(String status){
        this.status = status;
    }

    public ResponseEntity( T data){
        this.data = data;
    }
    public ResponseEntity(String status, T data){
        this.status = status;
        this.data = data;
    }
    public ResponseEntity(String status, String msg, String code){
        this.status = status;
        this.msg = msg;
        this.code = code;
    }

    public ResponseEntity(String status, String msg, T data){
        this.status = status;
        this.msg = msg;
        this.data = data;
    }
}
