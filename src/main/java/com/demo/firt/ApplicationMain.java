package com.demo.firt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 注解SpringBootApplication  显示这个类是主启动类
 */
@SpringBootApplication
public class ApplicationMain {


    //自动启动注入事务管理
   /* @Bean
    public Object testBean(PlatformTransactionManager platformTransactionManager){
        System.out.println(">>>>>>>>>>" + platformTransactionManager.getClass().getName());
        return new Object();
    }*/
    //main程序主入口
    public static void main(String[] args) {
        //调用静态方法 run，此方法是执行入口
        SpringApplication.run(ApplicationMain.class,args);
    }
}
