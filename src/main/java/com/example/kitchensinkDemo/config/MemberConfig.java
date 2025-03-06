package com.example.kitchensinkDemo.config;

import com.example.kitchensinkDemo.data.MemberRepository;
import com.example.kitchensinkDemo.model.Member;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MemberConfig {

    @Bean
    CommandLineRunner commandLineRunner(MemberRepository memberRepository) {
        return args -> {
            Member mariam = new Member(
                    "Mariam",
                    "Mariam.jamal@gmail.com",
                    "1617000000"
            );

            Member alex = new Member(
                    "Alex",
                    "Alex.jamal@gmail.com",
                    "1617444555"
            );
            memberRepository.saveAll (
                    List.of(mariam, alex)
            );
        };

    }
}

