package com.ning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
//掃描mybatis mapper包路徑
@MapperScan(basePackages = "com.ning.mapper")
//扫描所需要的包，包含自用工具类所在路径
@ComponentScan(basePackages = {"com.ning","org.n3r.idworker"})
public class Application {
	@Bean
	public  SpringUtil getSpringUtil() {
		return new SpringUtil();
	}
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	
}
