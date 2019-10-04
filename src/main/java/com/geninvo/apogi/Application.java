package com.geninvo.apogi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

/**
 * The main application
 * 
 * @author Sujith Kumar Sirisanagandla
 * @since ver 1.0 (oct 2019)
 * @version 1.0
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@EntityScan(basePackageClasses = {
        Application.class,
		Jsr310JpaConverters.class
})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}