package org.spiderflow;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan("org.spiderflow.*.mapper")
public class SpiderApplication implements ServletContextInitializer{
	
	public static void main(String[] args) throws IOException {
		
		SpringApplication.run(SpiderApplication.class, args);
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		//设置文本缓存1M
		servletContext.setInitParameter("org.apache.tomcat.websocket.textBufferSize", Integer.toString((1024 * 1024)));
	}
	
}