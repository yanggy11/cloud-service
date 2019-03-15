package com.atomikos.atomikosdemo.service;

import com.atomikos.atomikosdemo.dao1.WebMapper;
import com.atomikos.atomikosdemo.dao2.ResMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * @author derrick.yang
 * @Date 12/25/18 11:09 AM
 */

@Transactional
@Service
public class AtomikosServiceImpl implements AtomikosService {

    @Autowired
    private WebMapper webMapper;

    @Autowired
    private ResMapper resMapper;
    @Override
    public Object insert() {
        Map map = new HashMap();
        map.put("name","test");

        webMapper.insert(map);
        resMapper.insert(map);

        return "OK";
    }
}
