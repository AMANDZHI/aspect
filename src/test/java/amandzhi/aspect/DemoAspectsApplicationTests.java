package amandzhi.aspect;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DemoAspectsApplicationTests {

	@Autowired
	private CoachService service;

	@Test
	public void testLoggable() {
		service.say("gogo");
		service.jump();
		service.getAnswer();
	}

}
