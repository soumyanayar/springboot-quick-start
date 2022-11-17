package com.example.spring_app.topic.controller;

import com.example.spring_app.topic.dao.Topic;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TopicController {

    List<Topic> topicsList = List.of(
            new Topic("1", "Java", "Java is a programming language"),
            new Topic("2", "Spring", "Spring is a framework"),
            new Topic("3", "Spring Boot", "Spring Boot is a framework"),
            new Topic("1", "JavaScript", "Javascript is a programming language")
    );

    @GetMapping("/topics")
    public List<Topic> getAllTopics() {
        return topicsList;
    }
}
