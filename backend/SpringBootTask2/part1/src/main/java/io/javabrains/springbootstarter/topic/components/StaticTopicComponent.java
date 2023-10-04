package io.javabrains.springbootstarter.topic.components;


import io.javabrains.springbootstarter.topic.models.Topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface StaticTopicComponent {

    List<Topic> alisList = new ArrayList<>( Arrays.asList(
            new Topic("spring", "Spring Framework", "Spring Description")
            ,new Topic("java", "core java", "core java description")
            ,new Topic("javascript", "Spring Framework", "Spring Description")
    ));

    public List<Topic>  getTopics();
    
}
