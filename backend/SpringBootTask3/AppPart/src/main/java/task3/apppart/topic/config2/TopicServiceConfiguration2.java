package task3.apppart.topic.config2;

import task3.configpart.topic.config.TopicServiceConfiguration;
import task3.configpart.topic.components.AliceTopicComponent;
import task3.configpart.topic.components.BobTopicComponent;
import task3.apppart.topic.config2.TopicServiceConfiguration2;
import task3.apppart.topic.services.TopicService;
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

    @Bean
    @ConditionalOnMissingBean
    AliceTopicComponent AliceTopicComponent(){
        return new AliceTopicComponent();
    }
    @Bean
    @ConditionalOnMissingBean
    BobTopicComponent bobTopicComponent(){
        return new BobTopicComponent();
    }

}
