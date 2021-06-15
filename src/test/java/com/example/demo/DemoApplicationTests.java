package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Base64Utils;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            SecureRandom secureRandom = new SecureRandom();
            keyGenerator.init(128,secureRandom);
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] encode = Base64Utils.encode(secretKey.getEncoded());
            for (int i=0;i< encode.length;i++){
                System.out.print(encode[i]);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

}
