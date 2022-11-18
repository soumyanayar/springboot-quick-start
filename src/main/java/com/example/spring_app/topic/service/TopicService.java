package com.example.spring_app.topic.service;

import com.example.spring_app.topic.entity.Topic;
import com.example.spring_app.topic.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;


    public List<Topic> getAllTopics() {
        return (List<Topic>) topicRepository.findAll();
    }

    public Topic getTopicById(String id) {
        return topicRepository.findById(id).get();
    }

    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public boolean doesTopicExist(String id) {
        return topicRepository.existsById(id);
    }

    public void deleteTopic(String id) {
        topicRepository.deleteById(id);
    }
}
