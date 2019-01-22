package com.xiny;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableScheduling //开启定时任务
@EnableTransactionManagement //开启声明式事务
@MapperScan("com.xiny.dao") //扫描dao接口，mapper.xml中namespace指向值的包位置
public class MysiteApplication extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(MysiteApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(MysiteApplication.class, args);
	}
}
