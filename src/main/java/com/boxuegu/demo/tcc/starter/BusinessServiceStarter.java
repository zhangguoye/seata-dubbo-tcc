package com.boxuegu.demo.tcc.starter;

import com.boxuegu.demo.tcc.service.BusinessService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BusinessServiceStarter {
    public static void main(String[] args) {
        /**
         *  启动业务测试服务
         */
        ClassPathXmlApplicationContext businessContext = new ClassPathXmlApplicationContext(new String[]{"spring/dubbo-business-service.xml"});
        final BusinessService business = (BusinessService) businessContext.getBean("business");
        business.borrowBook("B101", "123456");

    }
}
