package com.zero.spring.boot.stater.common.starter;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;

@Data
@SuppressWarnings("serial")
@ConfigurationProperties(prefix = "com.person")
public class SystemUserProperties implements Serializable {
    private String name;
    private int age;
    private String gender = "M";
}