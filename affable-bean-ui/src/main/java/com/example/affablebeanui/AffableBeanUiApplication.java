package com.example.affablebeanui;

import com.example.affablebeanui.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class AffableBeanUiApplication {

    private final ProductService productService;

//    @Bean
    public ApplicationRunner runner() {
        return r -> {
            productService.listProductsByCategoryName("dairy")
                    .forEach(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(AffableBeanUiApplication.class, args);
    }

}
