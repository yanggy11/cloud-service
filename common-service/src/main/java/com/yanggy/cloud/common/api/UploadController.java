package com.yanggy.cloud.common.api;

import com.yanggy.cloud.common.config.enums.ErrorCode;
import com.yanggy.cloud.common.dto.UploadDto;
import com.yanggy.cloud.common.service.IFileUploadService;
import com.yanggy.cloud.common.utils.ResponseEntityBuilder;
import com.yanggy.cloud.common.utils.ResponseEntityDto;
import com.yanggy.cloud.common.utils.UrlEncryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author derrick.yang
 * @Date 9/23/18 10:25
 */

@RestController
public class UploadController {
    @Autowired
    private IFileUploadService fileUploadService;

    private static Logger logger = LoggerFactory.getLogger(WebTestController.class);


    @PostMapping(value = "/upload")
    public ResponseEntityDto<?> uploadImage(UploadDto uploadDto) {

        ResponseEntityDto<?> res;

        try {
            res = ResponseEntityBuilder.buildNormalResponseEntity(fileUploadService.fileUpload(uploadDto.getFile()));
        } catch (Exception e) {
            e.printStackTrace();
            res = ResponseEntityBuilder.buildErrorResponseEntity(ErrorCode.UNKONWN_ERROR);
        }

        return res;
    }

    @PostMapping(value = "/log")
    public String loginfo(@RequestBody String str){
        logger.info("日志 :" + str);

        return str;
    }

    public static void main(String[] args) {
        System.out.println(UrlEncryptor.e(5));
    }
}
