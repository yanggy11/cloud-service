package com.yanggy.cloud.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * @author derrick.yang
 * @Date 9/1/18 12:34
 */

@Data
public class UploadDto implements Serializable {
    
	private static final long serialVersionUID = -6233839345238776868L;
	private MultipartFile file;
    private String name;
}
