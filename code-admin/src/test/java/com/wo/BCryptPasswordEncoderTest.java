package com.wo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
@Slf4j
public class BCryptPasswordEncoderTest {
    @Test
    void contextLoads() {
    }
    @Test
    void testBCryptPasswordEncoder(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        // 编码
        String encodeOne = bCryptPasswordEncoder.encode("123456");
        String encodeTwo = bCryptPasswordEncoder.encode("123456");
        String encodeThree = bCryptPasswordEncoder.encode("123456");
        log.info("加密1 {}",encodeOne);
        log.info("加密2 {}",encodeTwo);
        log.info("加密3 {}",encodeThree);
        // 比对方法 参数一：明文 参数二：密文
        boolean matches = bCryptPasswordEncoder.matches("123456", encodeOne);
        boolean matches1 = bCryptPasswordEncoder.matches("123456", encodeTwo);
        boolean matches2 = bCryptPasswordEncoder.matches("123456", encodeThree);
        assert (matches1 || matches2);
        assert matches;
    }
}
