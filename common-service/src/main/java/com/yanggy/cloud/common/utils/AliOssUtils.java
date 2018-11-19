package com.yanggy.cloud.common.utils;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @author derrick.yang
 * @Date 9/1/18 10:27
 */

@Component
public class AliOssUtils {

    @Autowired
    private OssProperties ossProperties;

    public String uploadImage(MultipartFile multfile) {
        String url = null;      //默认null
        OSSClient ossClient = null;
        try {
            ossClient = new OSSClient(ossProperties.getEndpoint(), ossProperties.getAccessKeyId(), ossProperties.getAccessKeySecret());
            String fileName = UUID.randomUUID().toString().toUpperCase().replace("-", "")
                    + multfile.getOriginalFilename().substring(multfile.getOriginalFilename().lastIndexOf(".")); //文件名，根据UUID来
            // 创建上传Object的Metadata
            InputStream input = multfile.getInputStream();
            ObjectMetadata meta = new ObjectMetadata();
            meta.setContentType(multfile.getContentType());       // 设置上传内容类型
            meta.setCacheControl("no-cache");                   // 被下载时网页的缓存行为
            PutObjectRequest request = new PutObjectRequest(ossProperties.getBucket(), fileName, input, meta);//创建上传请求
            ossClient.putObject(request);
            StringBuilder sb = new StringBuilder(ossProperties.getBucketEndpoint()).append(fileName);
            url = sb.toString();
        }catch (OSSException oe) {
            return null;
        } catch (ClientException e) {
            return null;
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e) {
            return null;
        } finally {
            ossClient.shutdown();
        }

        return url;
    }
}
