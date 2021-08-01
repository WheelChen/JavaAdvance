package com.example.schoolboot;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Properties;

/**
 * @author Kelvin Chen
 * @date 2021-07-25 23:28:04
 */
@Data
@ConfigurationProperties(prefix = "spring.school")
public class SchoolPropertiesConfiguration {
    private Properties props = new Properties();
}
