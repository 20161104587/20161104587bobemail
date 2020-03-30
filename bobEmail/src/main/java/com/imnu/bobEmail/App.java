package com.imnu.bobEmail;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = "com.imnu.bobEmail.mapper")
public class App {
	    public static void main(String[] args) {
	    	SpringApplication.run(App.class, args);
		}
	/* 页面过滤器 .do
	 * @Bean public ServletRegistrationBean<DispatcherServlet>
	 * servletRegistrationBean(DispatcherServlet dispatcherServlet) {
	 * ServletRegistrationBean<DispatcherServlet> bean = new
	 * ServletRegistrationBean<DispatcherServlet>(dispatcherServlet);
	 * bean.addUrlMappings("*.do"); return bean; }
	 */
}

