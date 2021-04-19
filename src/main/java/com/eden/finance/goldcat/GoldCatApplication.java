package com.eden.finance.goldcat;

import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.eden.finance.goldcat.*.mapper")
public class GoldCatApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoldCatApplication.class,args);
    }
}
