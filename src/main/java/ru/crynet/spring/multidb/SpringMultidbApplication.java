package ru.crynet.spring.multidb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ru.crynet.spring.multidb.service.AccountService;

@SpringBootApplication
public class SpringMultidbApplication implements ApplicationRunner {
    @Autowired
    private AccountService accountService;

    public static void main(String[] args) {
        SpringApplication.run(SpringMultidbApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        accountService.execute();
    }
}
