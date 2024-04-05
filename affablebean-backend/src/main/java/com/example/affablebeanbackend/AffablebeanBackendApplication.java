package com.example.affablebeanbackend;

import com.example.affablebeanbackend.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@RequiredArgsConstructor
public class AffablebeanBackendApplication {

    private final ProductRepository productRepository;
    @Bean
    @Profile("dev")
    public ApplicationRunner runner() {
        return r-> {
//            productRepository.allProductsByCategoryName("bakery")
//                    .forEach(e -> System.out.println(e));
            productRepository.findAll()
                    .forEach(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(AffablebeanBackendApplication.class, args);
    }

}
