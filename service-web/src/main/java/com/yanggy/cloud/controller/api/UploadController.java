package com.yanggy.cloud.controller.api;

import com.yanggy.cloud.dto.UploadDto;
import com.yanggy.cloud.enums.ErrorCode;
import com.yanggy.cloud.service.IFileUploadService;
import com.yanggy.cloud.utils.ResponseEntityBuilder;
import com.yanggy.cloud.utils.ResponseEntityDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author derrick.yang
 * @Date 9/23/18 10:25
 */

@RestController
public class UploadController {
    @Autowired
    private IFileUploadService fileUploadService;

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
}
