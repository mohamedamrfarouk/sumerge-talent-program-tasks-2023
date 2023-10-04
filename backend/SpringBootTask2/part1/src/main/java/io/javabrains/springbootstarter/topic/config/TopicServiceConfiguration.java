package io.javabrains.springbootstarter.topic.config;

import io.javabrains.springbootstarter.topic.components.AliceTopicComponent;
import io.javabrains.springbootstarter.topic.components.BobTopicComponent;
import io.javabrains.springbootstarter.topic.components.StaticTopicComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"org.sumerge.secondspringbootproject.part1"})
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
