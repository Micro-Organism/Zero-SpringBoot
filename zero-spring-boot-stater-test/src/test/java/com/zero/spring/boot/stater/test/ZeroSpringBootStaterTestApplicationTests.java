package com.zero.spring.boot.stater.test;

import com.zero.spring.boot.stater.service.SystemUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ZeroSpringBootStaterTestApplicationTests {

    @Autowired
    private SystemUserService systemUserService;

    /**
     * 如果不在本地配置 yml 配置，就会找不到stater的值
     * todo 需要再研究一下
     */
    @Test
    public void testHelloWorld() {
        systemUserService.sayHello();
    }

}
