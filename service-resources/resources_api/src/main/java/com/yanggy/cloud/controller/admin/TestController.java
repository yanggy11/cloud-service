package com.yanggy.cloud.controller.admin;

import com.yang.cloud.mapper.RoleMapper;
import com.yang.cloud.mapper.UserMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/**
 * @author derrick.yang
 * @Date 12/11/18 3:34 PM
 */

@RestController
public class TestController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private ExecutorService executorService;

    @PostMapping(value = "/insertData")
    public String insertData(@RequestBody Map<String, String> pathMap) throws InterruptedException, IOException {


        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(pathMap.get("path"))));

        StringBuilder builder = new StringBuilder("");

        String line = bufferedReader.readLine();


        while (StringUtils.isNotBlank(line)) {

            try {
                line = bufferedReader.readLine();
                Map map = new HashMap();
                map.put("word", line.trim());
                map.put("type", pathMap.get("type"));
                userMapper.insertStopWord(map);
            }catch (Exception e) {
                System.out.println(line);

                e.printStackTrace();
            }

        }

        bufferedReader.close();


        return "";
    }
}
