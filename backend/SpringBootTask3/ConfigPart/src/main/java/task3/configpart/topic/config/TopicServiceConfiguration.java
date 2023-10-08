package task3.configpart.topic.config;

import task3.configpart.topic.components.AliceTopicComponent;
import task3.configpart.topic.components.BobTopicComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicServiceConfiguration {
    @Bean
    AliceTopicComponent AliceTopicComponent(){
        return new AliceTopicComponent();
    }
    @Bean
    BobTopicComponent bobTopicComponent(){
        return new BobTopicComponent();
    }
}
