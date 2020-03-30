package com.imnu.bobEmail.config;



import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

	/* 页面过滤
	 * @Override public void configurePathMatch(PathMatchConfigurer
	 * pathMatchConfigurer) {
	 * pathMatchConfigurer.setUseSuffixPatternMatch(false);//设置是否是后缀模式匹配,即:/test.*
	 * pathMatchConfigurer.setUseRegisteredSuffixPatternMatch(true);//设置是否自动后缀路径模式匹配
	 * ,即：/test/ }
	 * 
	 * @Override public void
	 * configureContentNegotiation(ContentNegotiationConfigurer configurer) {
	 * configurer.favorPathExtension(false); }
	 */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver irvr = new InternalResourceViewResolver("/", ".jsp");
        registry.viewResolver(irvr);
    }
    /**
  		 * 资源映射路径
  		 * addResourceHandler：访问映射路径
  		 * addResourceLocations：资源绝对路径
  		 */
	
	 private String path= "E:/mvc/uploads/";
	  @Override public void addResourceHandlers(ResourceHandlerRegistry registry) {
	  String staticMapping="/**"; String localDirectory = "file:"+path;
	  registry.addResourceHandler(staticMapping).addResourceLocations(
			  "classpath:/META-INF/resources/",localDirectory);
	  
	  }
	 


}

