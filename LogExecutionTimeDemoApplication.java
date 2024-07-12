package logexecutiontime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import logexecutiontime.service.MyService;

@SpringBootApplication
public class LogExecutionTimeDemoApplication implements CommandLineRunner{
	
	@Autowired
	private MyService myService;
	public static void main(String[] args) {
		SpringApplication.run(LogExecutionTimeDemoApplication.class, args);
	}
	@Override
    public void run(String... args) throws Exception {
        myService.serve();
    }

}
