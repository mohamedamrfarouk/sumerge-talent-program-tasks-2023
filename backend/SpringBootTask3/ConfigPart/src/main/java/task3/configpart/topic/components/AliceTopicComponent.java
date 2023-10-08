package task3.configpart.topic.components;

import task3.configpart.topic.models.Topic;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Qualifier("aliceTopicComponent")
public class AliceTopicComponent implements StaticTopicComponent{
    public List<Topic> getAliceList() {
        return aliceList;
    }

    public void setAliceList(List<Topic> aliceList) {
        this.aliceList = aliceList;
    }

    List<Topic> aliceList = new ArrayList<>( Arrays.asList(
            new Topic("alice spring", "alice Spring Framework", "alice Spring Description")
            ,new Topic("alice java", "alice core java", "alice core java description")
            ,new Topic("alice javascript", "alice Spring Framework", "alice Spring Description")
    ));

    @Override
    public List<Topic>  getTopics(){
        return aliceList;
    };

    @Override
    public void setTopics(List<Topic> aliceList) {
        this.aliceList = aliceList;
    }


}
