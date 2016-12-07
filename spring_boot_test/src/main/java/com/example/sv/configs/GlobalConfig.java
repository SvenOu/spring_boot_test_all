package com.example.sv.configs;

import com.example.sv.mobile.configs.SpringMobile;
import com.example.sv.web.configs.SpringMVC;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;

@Configuration
@ImportResource(value = {"classpath:test_config1.xml", "classpath:com/example/sv/test_config2.xml"})
public class GlobalConfig {
    @Bean
    public SomeBean provideSomeBean(){
        return new SomeBean("test some bean.");
    }

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Bean
    public ServletRegistrationBean springMvc(ServletContext servletContext) {

        DispatcherServlet dispatcherServlet = new DispatcherServlet();
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(SpringMVC.class);
        dispatcherServlet.setApplicationContext(applicationContext);
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(dispatcherServlet, "/controller/*");
        servletRegistrationBean.setName("spring-mvc");
        servletRegistrationBean.setLoadOnStartup(4);
        return servletRegistrationBean;

//        DispatcherServlet dispatcherServlet = new DispatcherServlet();
//        dispatcherServlet.setContextConfigLocation("classpath:com/example/sv/spring-mvc-servlet.xml");
//        ClassPathXmlApplicationContext webApplicationContext = new ClassPathXmlApplicationContext();
//        webApplicationContext.setConfigLocation("com/example/sv/spring-mvc-servlet.xml");
//        dispatcherServlet.setApplicationContext(webApplicationContext);
//        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(dispatcherServlet, "/controller/*");
//        servletRegistrationBean.setName("spring-mvc");
//        servletRegistrationBean.setLoadOnStartup(4);
//        return servletRegistrationBean;
    }

    @Bean
    public ServletRegistrationBean springMobile() {
//        DispatcherServlet dispatcherServlet = new DispatcherServlet();
//        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
//        applicationContext.register(SpringMobile.class);
//        dispatcherServlet.setApplicationContext(applicationContext);
//        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(dispatcherServlet, "/mobile/*");
//        servletRegistrationBean.setName("spring-mobile");
//        servletRegistrationBean.setLoadOnStartup(4);
//        return servletRegistrationBean;
        DispatcherServlet dispatcherServlet = new DispatcherServlet();
        dispatcherServlet.setContextConfigLocation("classpath:com/example/sv/spring-mobile-servlet.xml");
        ClassPathXmlApplicationContext webApplicationContext = new ClassPathXmlApplicationContext();
        webApplicationContext.setConfigLocation("com/example/sv/spring-mobile-servlet.xml");
        dispatcherServlet.setApplicationContext(webApplicationContext);
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(dispatcherServlet, "/mobile/*");
        servletRegistrationBean.setName("spring-mobile");
        servletRegistrationBean.setLoadOnStartup(4);
        return servletRegistrationBean;
    }
}
