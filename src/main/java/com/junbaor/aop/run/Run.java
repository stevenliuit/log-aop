package com.junbaor.aop.run;

import com.junbaor.aop.service.AService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

@Component
public class Run {
    @Autowired
    private AService aService;

    @PostConstruct
    public void init() {
//        aService.methodA();
        aService.methodB("aop", 1, 2, new Date());
    }

}
