package com.example.schoolboot;

import com.example.schoolbootcore.bean.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.Scanner;

/**
 * @author Kelvin Chen
 * @date 2021-07-25 23:22:39
 */
@Configuration
@ComponentScan("com.example.schoolbootcore.bean")
@EnableConfigurationProperties(SchoolPropertiesConfiguration.class)
public class SchoolAutoConfiguration {

    @Bean
    public School createSchool() {
    }
}
