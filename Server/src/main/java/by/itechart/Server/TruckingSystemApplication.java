package by.itechart.Server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;

@SpringBootApplication(exclude = LiquibaseAutoConfiguration.class)
public class TruckingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(TruckingSystemApplication.class, args);
	}

}
