package todo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = { "todo.app" })
@EntityScan(basePackages = { "todo.app" })
public class ToDoApp {

	public static void main(String[] args) {
		SpringApplication.run(ToDoApp.class, args);
	}

}
