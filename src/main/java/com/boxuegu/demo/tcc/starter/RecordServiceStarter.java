package com.boxuegu.demo.tcc.starter;

import com.boxuegu.demo.tcc.ApplicationKeeper;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RecordServiceStarter {
    public static void main(String[] args) {
        /**
         *  启动借阅记录服务
         */
        ClassPathXmlApplicationContext orderContext = new ClassPathXmlApplicationContext(new String[]{"spring/dubbo-record-service.xml"});
        orderContext.getBean("service");
        new ApplicationKeeper(orderContext).keep();
    }
}
