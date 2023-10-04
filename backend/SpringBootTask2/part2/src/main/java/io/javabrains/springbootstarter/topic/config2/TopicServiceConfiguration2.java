package io.javabrains.springbootstarter.topic.config2;

import io.javabrains.springbootstarter.topic.config.TopicServiceConfiguration;
import io.javabrains.springbootstarter.topic.services.TopicService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {
        TopicServiceConfiguration.class,
        TopicServiceConfiguration2.class
})
public class TopicServiceConfiguration2 {
    @Bean
    @ConditionalOnMissingBean
    TopicService getTopicService(){
        return new TopicService();
    }
//
//    @Bean
//    @ConditionalOnMissingBean
//    AliceTopicComponent AliceTopicComponent(){
//        return new AliceTopicComponent();
//    }
//    @Bean
//    @ConditionalOnMissingBean
//    BobTopicComponent bobTopicComponent(){
//        return new BobTopicComponent();
//    }

}
