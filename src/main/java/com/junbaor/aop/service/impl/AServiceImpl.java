package com.junbaor.aop.service.impl;

import com.alibaba.fastjson.JSON;
import com.junbaor.aop.annotation.Comment;
import com.junbaor.aop.service.AService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Comment("方法模块注释")
public class AServiceImpl implements AService {

    private static final Logger log = LoggerFactory.getLogger(AServiceImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public AServiceImpl() {
        log.info("A初始化");
    }

    public void methodA() {
        System.out.println("方法A");
        int i = jdbcTemplate.update("update users set username='1' where id = 1");
        log.info(JSON.toJSONString(i));
        inline();
    }

    @Comment("业务方法注释")
    public String methodB(String a, Integer b, int c, Date date) {
        log.info("业务逻辑执行...");
        return "我是返回值";
    }

    private void inline() {
        System.out.println("内部方法执行");
        int i = jdbcTemplate.update("update users set username='2' where id = 1");
        log.info(JSON.toJSONString(i));
        /*throw new RuntimeException("哎呀,失败了");*/
    }
}
