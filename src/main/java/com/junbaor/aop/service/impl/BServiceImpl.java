package com.junbaor.aop.service.impl;

import com.junbaor.aop.service.BService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class BServiceImpl implements BService {

    private static final Logger log = LoggerFactory.getLogger(BServiceImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public BServiceImpl() {
        System.out.println("B初始化");
    }

    public void methodB() {

    }
}
