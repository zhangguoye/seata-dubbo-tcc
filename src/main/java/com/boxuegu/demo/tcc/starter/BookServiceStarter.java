package com.boxuegu.demo.tcc.starter;

import com.boxuegu.demo.tcc.ApplicationKeeper;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookServiceStarter {
    public static void main(String[] args) {
        /**
         *  启动图书服务
         */
        ClassPathXmlApplicationContext orderContext = new ClassPathXmlApplicationContext(new String[]{"spring/dubbo-book-service.xml"});
        orderContext.getBean("service");
        new ApplicationKeeper(orderContext).keep();
    }
}
