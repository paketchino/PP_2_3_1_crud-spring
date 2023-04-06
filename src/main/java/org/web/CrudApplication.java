package org.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "org.web")
@EntityScan("org.web.model")
public class CrudApplication {


    public static void main(String[] args) {
        SpringApplication.run(CrudApplication.class);
    }
}
