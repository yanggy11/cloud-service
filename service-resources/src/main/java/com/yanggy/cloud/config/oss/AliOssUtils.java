package com.yanggy.cloud.config.oss;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectRequest;

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
        //获取一个ossclient连接
        try {
            //上传后的文件名
            String fileName = UUID.randomUUID().toString().toUpperCase().replace("-", "")
                    + multfile.getOriginalFilename().substring(multfile.getOriginalFilename().lastIndexOf(".")); //文件名，根据UUID来

            ossClient = new OSSClient(ossProperties.getEndpoint(), ossProperties.getAccessKeyId(), ossProperties.getAccessKeySecret());
            InputStream input = multfile.getInputStream();
            ObjectMetadata meta = new ObjectMetadata();             // 创建上传Object的Metadata
            meta.setContentType(multfile.getContentType());       // 设置上传内容类型
            meta.setCacheControl("no-cache");                   // 被下载时网页的缓存行为
            PutObjectRequest request = new PutObjectRequest(ossProperties.getBucket(), fileName, input, meta);//创建上传请求
            ossClient.putObject(request);

            StringBuilder sb = new StringBuilder(ossProperties.getBucketEndpoint()).append(fileName);

            url = sb.toString();
        }catch (OSSException oe) {
            oe.printStackTrace();

            return null;
        } catch (ClientException ce) {
            ce.printStackTrace();

            return null;
        } catch (FileNotFoundException e) {
            e.printStackTrace();

            return null;
        } catch (IOException e) {
            e.printStackTrace();

            return null;
        } finally {
            //关闭连接
            ossClient.shutdown();
        }

        return url;
    }
}
