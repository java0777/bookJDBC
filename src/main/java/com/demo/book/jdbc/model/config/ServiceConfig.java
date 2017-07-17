package com.demo.book.jdbc.model.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by Administrator on 2017/7/17.
 */
@PropertySource("classpath:service.properties")
@Configuration
public class ServiceConfig {
    @Value("${service.BaseDir}")
    private String baseDir;

    public String getBaseDir() {
        return baseDir;
    }

    public void setBaseDir(String baseDir) {
        this.baseDir = baseDir;
    }
}
