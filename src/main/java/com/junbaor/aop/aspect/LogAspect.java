package com.junbaor.aop.aspect;

import com.alibaba.fastjson.JSONObject;
import com.junbaor.aop.annotation.Comment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class LogAspect implements MethodBeforeAdvice, AfterReturningAdvice {

    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);


    public void before(Method method, Object[] objects, Object o) throws Throwable {
        String target = o.getClass().getName() + "#" + method.getName();
        String params = JSONObject.toJSONStringWithDateFormat(objects, "yyyy-MM-dd HH:mm:ss");

        StringBuffer sb = new StringBuffer();
        Comment classAnnotation = o.getClass().getAnnotation(Comment.class);
        if (classAnnotation != null) {
            sb.append(classAnnotation.value()).append("-");
        }
        Comment methodAnnotation = method.getAnnotation(Comment.class);
        if (methodAnnotation != null) {
            sb.append(methodAnnotation.value());
        }

        System.out.println();
        log.info("{} 方法调用--> {} 参数:{}", sb.toString(), target, params);
        System.out.println();
    }

    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        String target = o1.getClass().getName() + "#" + method.getName();
        String params = JSONObject.toJSONStringWithDateFormat(objects, "yyyy-MM-dd HH:mm:ss");
        String returnValue = JSONObject.toJSONStringWithDateFormat(o, "yyyy-MM-dd HH:mm:ss");

        System.out.println();
        log.info("调用结束<-- {} 参数:{} 返回值:{}", target, params, returnValue);
        System.out.println();
    }
}
