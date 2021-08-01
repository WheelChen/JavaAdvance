package com.example.schoolboot;

import com.example.schoolbootcore.bean.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SchoolBootApplication {
    @Autowired
    private School school ;

    public static void main(String[] args) {
        SpringApplication.run(SchoolBootApplication.class, args);
    }

}
