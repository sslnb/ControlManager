package com.arshiner;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
@EnableAutoConfiguration
@SpringBootApplication
@MapperScan("com.arshiner.dao")
@PropertySource("file:${user.dir}/application.properties") 
public class Application {
//启动类
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(Application.class, args);
		
	}

}
