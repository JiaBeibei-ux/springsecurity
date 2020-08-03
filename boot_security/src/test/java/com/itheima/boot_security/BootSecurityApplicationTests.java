package com.itheima.boot_security;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;

@SpringBootTest
class BootSecurityApplicationTests {

    @Test
    void contextLoads() {
        //对密码进行加密
        String hashpw = BCrypt.hashpw("123456", BCrypt.gensalt());
        System.out.println(hashpw);
        //校验密码a
        Boolean c = BCrypt.checkpw("123456","$2a$10$b6BooK49n6.cSW4Hdz.yBOD.OAjnFu26FiMm9js7b5Se4RKejF//O");
        System.out.println(c);
    }

}
