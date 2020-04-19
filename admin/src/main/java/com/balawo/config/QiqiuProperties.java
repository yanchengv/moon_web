package com.balawo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.annotation.Validated;

@Configuration
@PropertySource(value = "classpath:qiniu.yml",factory = ResourceFactory.class)
@ConfigurationProperties(prefix = "app")
@Validated
public class QiqiuProperties {
    private String hostname;
    private String img;

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
