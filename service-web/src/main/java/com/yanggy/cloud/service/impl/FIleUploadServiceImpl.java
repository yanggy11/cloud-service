package com.yanggy.cloud.service.impl;

import com.yanggy.cloud.config.oss.AliOssUtils;
import com.yanggy.cloud.service.IFileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * @author derrick.yang
 * @Date 9/4/18 13:35
 */

@Service
public class FIleUploadServiceImpl implements IFileUploadService {
    @Autowired
    private ExecutorService executorService;
    @Autowired
    private AliOssUtils aliOssUtils;


    @Override
    public String fileUpload(MultipartFile file) {
        Future<String> task = executorService.submit(() -> aliOssUtils.uploadImage(file));

        try {
            return task.get();
        } catch (InterruptedException e) {
            return null;
        } catch (ExecutionException e) {
            return null;
        }
    }
}
