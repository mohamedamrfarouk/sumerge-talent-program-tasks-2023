package task3.apppart.topic;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import task3.configpart.topic.components.AliceTopicComponent;
import task3.configpart.topic.components.BobTopicComponent;

@Mapper(componentModel = "spring")
public interface TopicMapper {
    TopicMapper INSTANCE = Mappers.getMapper(TopicMapper.class);

//    @Mapping(source = "AliceTopicComponent", target = "BobTopicComponent")
//    BobTopicComponent mapAliceTopicsToBobTopics(AliceTopicComponent aliceTopicComponent);

    @Mapping(source = "bobList", target = "aliceList")
    AliceTopicComponent mapBobTopicsToAliceTopics(BobTopicComponent bobTopicComponent);
}
