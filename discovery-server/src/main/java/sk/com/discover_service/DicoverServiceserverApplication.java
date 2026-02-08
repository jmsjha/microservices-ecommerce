package sk.com.discover_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //Turns app into Eureka registry
public class DicoverServiceserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(DicoverServiceserverApplication.class, args); //Starts embedded server
	}

}
