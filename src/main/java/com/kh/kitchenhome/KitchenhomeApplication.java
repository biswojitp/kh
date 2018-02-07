package com.kh.kitchenhome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.kh.kitchenhome.controller.KHController;



//@EnableJpaRepositories(basePackages="com.kh.kitchenhome.model", entityManagerFactoryRef="entityManagerFactory")
//@ComponentScan({"com.kh.kitchenhome.repository"})
//@ComponentScan({"com.kh.kitchenhome.*"})
//@EntityScan("com.kh.kitchenhome.*")
//@ComponentScan(basePackageClasses = KHController.class)
//@Configuration

@SpringBootApplication
public class KitchenhomeApplication {

	public static void main(String[] args) {
		SpringApplication.run(KitchenhomeApplication.class, args);
	}
}
