package com.itheima.init;


import com.itheima.config.ApplicationConfig;
import com.itheima.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringApplicationInt extends AbstractAnnotationConfigDispatcherServletInitializer {
    //applicationContext.xml
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ApplicationConfig.class};
    }

    //springmvc.xml
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }
    //url-pattern
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
