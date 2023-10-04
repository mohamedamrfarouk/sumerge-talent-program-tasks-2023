package  io.javabrains.springbootstarter;
import io.javabrains.springbootstarter.topic.config.TopicServiceConfiguration;
import io.javabrains.springbootstarter.topic.config2.TopicServiceConfiguration2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

public class CourseApiApp {
    public static void main(String[] args) {
        SpringApplication.run(CourseApiApp.class, args);
    }
}
