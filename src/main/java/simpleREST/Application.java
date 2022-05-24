package simpleREST;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

//This annotation instructs Spring to initialize its configuration - which is needed to start a
//new application
@SpringBootApplication
//Indicates that this class contains RESTful methods to handle incoming HTTP requests
@RestController
public class Application {

	// We can start our application by calling the run method with the primary class
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	

	
	@PostMapping("/sendMessage")
	public ResponseEntity<TestMessage> create(@RequestBody String m) {
		TestMessage message = new TestMessage(m);
		return new ResponseEntity<>(message,HttpStatus.CREATED);
	}
}