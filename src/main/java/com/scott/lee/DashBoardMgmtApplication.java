package com.scott.lee;

import com.slyak.spring.jpa.GenericJpaRepositoryFactoryBean;
import com.slyak.spring.jpa.GenericJpaRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.scott.lee"})
@EnableJpaRepositories(basePackages = "com.scott.lee.**.reponsitory",
		repositoryBaseClass = GenericJpaRepositoryImpl.class,
		repositoryFactoryBeanClass = GenericJpaRepositoryFactoryBean.class)
public class DashBoardMgmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(DashBoardMgmtApplication.class, args);
	}
}
