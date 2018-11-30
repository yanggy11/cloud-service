package com.yanggy.cloud.utils;

/**
 * @author derrick.yang
 * @Date 8/23/18 11:49
 */
public interface Constants {

    interface RabbitConstants {
        String USER_EXCHANGE = "user_exchange";
        String USER_QUEUE = "hello";
    }

    interface AliOssConstans {
        String OSS_BUCKET = "derrick-yang";
        String OSS_ENDPOINT = "http://oss-ap-northeast-1.aliyuncs.com";
        String OSS_ACCESS_KEY = "TAIowDSmQznK5FK";
        String OSS_ACCESS_KEY_SECRET = "7bpGZepvHCI4ieSswiLfh5zI296IJh";
    }

    interface UserConstants {
        String DEFAULT_PASSWORD = "$e0801$zIo/EskQ1HH7BKefSxxsALaSetkcrTQVkkSG3UGazCpmPRVFwA6Sy0cTvygeYjkiIPrM38z547n188o0IapANA==$tjPzcn+aFPzAue/08CmvHV/sP7U00k6lbhWeexkokNg=";
    }
}


