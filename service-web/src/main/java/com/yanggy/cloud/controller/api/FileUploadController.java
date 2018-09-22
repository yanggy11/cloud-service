package com.yanggy.cloud.controller.api;

import com.yanggy.cloud.config.enums.ErrorCode;
import com.yanggy.cloud.dto.UploadDto;
import com.yanggy.cloud.service.IFileUploadService;
import com.yanggy.cloud.utils.ResponseEntityBuilder;
import com.yanggy.cloud.utils.ResponseEntityDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author derrick.yang
 * @Date 9/20/18 21:10
 */

@RestController
public class FileUploadController {

    @Autowired
    private IFileUploadService fileUploadService;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
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
}