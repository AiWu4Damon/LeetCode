package com.damon.worm.config;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * @Description: //相当于web.xml 可以加filter
 * @Author: fjy
 * @Date: 2020/4/21 0021 14:11
 * @Version: V1.0
 */
@Configuration
@EnableRedisHttpSession
public class RedisSessionConfig{
}
