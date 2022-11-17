package com.example.spring_app.topic.service;

import com.example.spring_app.topic.dao.Topic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {
    List<Topic> topicsList = new ArrayList<>(Arrays.asList(
            new Topic("1", "Java", "Java is a programming language"),
            new Topic("2", "Spring", "Spring is a framework"),
            new Topic("3", "Spring Boot", "Spring Boot is a framework"),
            new Topic("4", "JavaScript", "Javascript is a programming language")
    ));

    public List<Topic> getAllTopics() {
        return topicsList;
    }

    public Topic getTopicById(String id) {
        return topicsList.stream().filter(topic -> topic.getId().equals(id)).findFirst().orElse(null);
    }

    public void addTopic(Topic topic) {
        topicsList.add(topic);
    }

    public boolean doesTopicExist(String id) {
        return topicsList.stream().anyMatch(topic -> topic.getId().equals(id));
    }

    public void updateTopic(Topic topic, String id) {
        topicsList.stream().filter(t -> t.getId().equals(id)).forEach(t -> {
            t.setName(topic.getName());
            t.setDescription(topic.getDescription());
        });
    }

    public void deleteTopic(String id) {
        topicsList.removeIf(topic -> topic.getId().equals(id));
    }
}
