package br.com.coiffer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "br.com.coiffer",
        "model",
        "Service",
        "controller"
})

public class CoifferBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoifferBackendApplication.class, args);
    }
}
