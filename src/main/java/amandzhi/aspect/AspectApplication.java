package amandzhi.aspect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AspectApplication {


	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(AspectApplication.class, args);
	}

}
