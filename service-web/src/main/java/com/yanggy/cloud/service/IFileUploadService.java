package com.yanggy.cloud.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author derrick.yang
 * @Date 9/4/18 13:34
 */
public interface IFileUploadService {
    String fileUpload(MultipartFile file);
}
