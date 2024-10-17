package com.zero.spring.boot.stater.common.config;

import com.zero.spring.boot.stater.common.starter.SystemUserProperties;
import com.zero.spring.boot.stater.service.SystemUserService;
import com.zero.spring.boot.stater.service.impl.SystemUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration 
@EnableConfigurationProperties(SystemUserProperties.class)
@ConditionalOnClass(SystemUserService.class)
@ConditionalOnProperty(prefix = "com.person", value = "enabled", matchIfMissing = true)
public class SystemUserServiceAutoConfiguration {

    @Value("${com.person.name}")
    private String name;
    @Value("${com.person.age}")
    private int age;
    @Value("${com.person.gender}")
    private String gender;

    SystemUserProperties properties;

    /**
     * 构造函数方式注入
     * @param properties    属性
     * 优先级最高
     */
//    @Autowired
//    public SystemUserServiceAutoConfiguration(SystemUserProperties properties) {
//        // 通过 @Value 注解获取配置文件中的值
////        properties.setName(name);
////        properties.setAge(age);
////        properties.setGender(gender);
//
//        // 通过 @ConditionalOnProperty 方式获取
//        this.properties = properties;
//    }

    /**
     * setter方式注入
     * @param properties    属性
     * 优先级第二
     */
    @Autowired
    public void setProperties(SystemUserProperties properties) {

        // 通过 @Value 注解获取配置文件中的值
//        properties.setName(name);
//        properties.setAge(age);
//        properties.setGender(gender);

        // 通过 @ConditionalOnProperty 方式获取
        this.properties = properties;
    }

    /**
     * &#064;PostConstruct注解方式注入
     * 优先级最低
     */
//    @PostConstruct
//    public void init() {
//        properties.setName(name);
//        properties.setAge(age);
//        properties.setGender(gender);
//    }

    // if spring container do not config bean，auto config SystemUserService
    @Bean
    @ConditionalOnMissingBean(SystemUserService.class)
    public SystemUserService systemUserService(){
        return new SystemUserServiceImpl(properties);
    }
}