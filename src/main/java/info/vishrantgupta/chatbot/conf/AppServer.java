package info.vishrantgupta.chatbot.conf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("info.vishrantgupta.chatbot")
@EnableAutoConfiguration
public class AppServer 
{
	public static void main(String[] args) throws Exception {
		SpringApplication.run(AppServer.class, args);
	}
}
