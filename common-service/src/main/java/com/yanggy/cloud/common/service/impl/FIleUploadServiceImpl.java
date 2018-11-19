package com.yanggy.cloud.common.service.impl;

import com.yanggy.cloud.common.service.IFileUploadService;
import com.yanggy.cloud.common.utils.AliOssUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static Logger logger = LoggerFactory.getLogger(FIleUploadServiceImpl.class);
    @Autowired
    private ExecutorService executorService;
    @Autowired
    private AliOssUtils aliOssUtils;


    @Override
    public String fileUpload(MultipartFile file) {
        String url = null;
        Future<String> task = executorService.submit(() -> aliOssUtils.uploadImage(file));
        try {
            url = task.get();
        } catch (InterruptedException e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        } catch (ExecutionException e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }

        return url;
    }
}
