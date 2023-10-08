package task3.apppart.topic.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import task3.apppart.exceptions.TopicsEmptyException;

@ControllerAdvice
public class TopicsControllerAdvice {
    @ExceptionHandler(TopicsEmptyException.class)
    public ResponseEntity handleTopicEmpty(TopicsEmptyException topicsEmptyException){

        return ResponseEntity.noContent().build();
    }

}
