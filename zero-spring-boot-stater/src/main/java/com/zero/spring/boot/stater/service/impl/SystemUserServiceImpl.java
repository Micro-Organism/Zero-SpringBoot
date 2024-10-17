package com.zero.spring.boot.stater.service.impl;

import com.zero.spring.boot.stater.common.starter.SystemUserProperties;
import com.zero.spring.boot.stater.service.SystemUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SystemUserServiceImpl implements SystemUserService {

    SystemUserProperties properties;

    public void sayHello() {
        String message = String.format("hi，my name: %s, today,I'am %s , gender: %s", properties.getName(), properties.getAge(), properties.getGender());
        System.out.println(message);
    }
}