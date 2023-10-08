package task3.apppart.topic.controllers;

import task3.apppart.exceptions.TopicsEmptyException;
import task3.configpart.topic.models.Topic;
import task3.apppart.topic.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;



    @RequestMapping("/topics")
    public List<Topic> getAllTopics(){
        return topicService.getAllTopics();
    }

    @RequestMapping("/alicetopics")
    public List<Topic> getaliceTopics() throws TopicsEmptyException {
        List<Topic> anything = new ArrayList<>();
        topicService.staticTopicComponent.setTopics(anything);

        if (topicService.staticTopicComponent.getTopics().size()==0)
            throw new TopicsEmptyException();

        return topicService.staticTopicComponent.getTopics();
    }



    @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id){
        return topicService.getTopic(id);
    }

    @RequestMapping(value = "/topics", method = RequestMethod.POST)
    public void addTopic(@RequestBody Topic topic){
        topicService.addTopic(topic);

    }

    @RequestMapping(value = "/topics/{id}", method = RequestMethod.PUT)
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id){
        topicService.updateTopic(id, topic);
    }

    @RequestMapping(value = "/topics/{id}", method = RequestMethod.DELETE)
    public void deleteTopic(@PathVariable String id){
        topicService.deleteTopic(id);
    }

}
