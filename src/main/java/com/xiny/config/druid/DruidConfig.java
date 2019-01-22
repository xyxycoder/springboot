package com.xiny.config.druid;

import javax.sql.DataSource;


import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * druid监听
 */
@Configuration
@ServletComponentScan //用于扫描所有的Servlet、filter、listener
public class DruidConfig {

    private static final Logger log = LoggerFactory.getLogger(DruidConfig.class);

//    @Value("${druid.login.username}")
//    private String username;
//
//    @Value("${druid.login.password}")
//    private String password;
//
//    @Value("${druid.allow.ip}")
//    private String ip;
//
//    @Value("${druid.resetEnable}")
//    private String resetEnable;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid") //加载时读取指定的配置信息,前缀为spring.datasource.druid
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }


//    @Bean
//    public ServletRegistrationBean druidServlet() {
//        log.info("init druid Servlet Configuration");
//        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
//        servletRegistrationBean.setServlet(new StatViewServlet());
//        servletRegistrationBean.addUrlMappings("/druid/*");
//        // IP白名单 (没有配置或者为空，则允许所有访问)
//        servletRegistrationBean.addInitParameter("allow", ip);
//        servletRegistrationBean.addInitParameter("loginUsername", username);
//        servletRegistrationBean.addInitParameter("loginPassword", password);
//        //禁用HTML页面上的“Reset All”功能
//        servletRegistrationBean.addInitParameter("resetEnable", resetEnable);
//        return servletRegistrationBean;
//    }
//
//    @Bean
//    public FilterRegistrationBean druidFilter() {
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        filterRegistrationBean.setFilter(new WebStatFilter());
//        filterRegistrationBean.addUrlPatterns("/*");
//        //配置本过滤器放行的请求后缀
//        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
//        return filterRegistrationBean;
//    }



}
