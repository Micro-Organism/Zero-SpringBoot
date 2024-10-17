package com.zero.spring.boot.stater;

import com.zero.spring.boot.stater.service.SystemUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ZeroSpringBootStaterApplicationTests {

    @Autowired
    private SystemUserService systemUserService;

    /**
     * 这个地方适用本地的 yml 配置可以获取到相关值
     */
    @Test
    public void testHelloWorld() {
        systemUserService.sayHello();
    }

}
