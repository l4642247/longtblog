package cn.nicecoder.longtblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class LongtblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(LongtblogApplication.class, args);
    }

}
