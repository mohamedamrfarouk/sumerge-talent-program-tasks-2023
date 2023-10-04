package io.javabrains.springbootstarter.topic.components;

import io.javabrains.springbootstarter.topic.components.StaticTopicComponent;
import io.javabrains.springbootstarter.topic.models.Topic;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Qualifier("bobTopicComponent")
public class BobTopicComponent implements StaticTopicComponent {
    List<Topic> bobList = new ArrayList<>( Arrays.asList(
            new Topic("bob spring", "bob Spring Framework", "bob Spring Description")
            ,new Topic("bob java", "bob core java", "bob core java description")
            ,new Topic("bob javascript", "bob Spring Framework", "bob Spring Description")
    ));

    @Override
    public List<Topic>  getTopics(){
        return bobList;
    };


}
