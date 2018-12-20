package com.yanggy.cloud.controller.admin;

import com.yang.cloud.mapper.RoleMapper;
import com.yang.cloud.mapper.UserMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
    public String insertData() throws InterruptedException, IOException {
        String path = "/Users/derrick.yang/Documents/lmt_sys_user.sql";


        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(path)));

        StringBuilder builder = new StringBuilder("");

        String line = bufferedReader.readLine();

        while (StringUtils.isNotBlank(line)) {
            builder.append(line);

            line = bufferedReader.readLine();
        }

        String strs = builder.toString().replace("</li><li>", "|");
        String[] str = strs.split("\\|");
        System.out.println(strs);

        for (int j = 1; j <= 1000; j++) {
            String name = str[j - 1];
            name = name.replace("<p>", "");
            name = name.replace("</p>", "");
            name = name.replace("</li>", "");
            name = name.replace("<li>", "");

            Map map = new HashMap();
            map.put("id", j);
            map.put("name", name);

            userMapper.updateQpUserInfo(map);

        }
        return "";
    }
}
