package io.javabrains.springbootstarter.topic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class TopicService {
    List<Topic> topics = new ArrayList<>( Arrays.asList(
         new Topic("spring", "Spring Framework", "Spring Description")
         ,new Topic("java", "core java", "core java description")
         ,new Topic("javascript", "Spring Framework", "Spring Description")
    ));

    public List<Topic> getAllTopics(){
        return topics;
    }
    public Topic getTopic(String id){
        return topics.stream().filter(topic -> topic.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic topic){
        topics.add(topic);
    }

    public void updateTopic(String id, Topic topic) {
        System.out.println("updating");
        int index =  IntStream.range(0, topics.size())
                .filter(topicInd-> (topics.get(topicInd).getId().equals(id)))
                .findFirst()
                .getAsInt();

        topics.set(index, topic);
    }

    public void deleteTopic(String id) {
        topics.removeIf(t-> t.getId().equals(id));
    }
}
