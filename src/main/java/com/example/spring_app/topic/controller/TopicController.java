package com.example.spring_app.topic.controller;

import com.example.spring_app.topic.entity.Topic;
import com.example.spring_app.topic.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

    private final TopicService topicService;
    @Autowired
    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping("/topics")
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    @GetMapping("/topics/{id}")
    public ResponseEntity<Object> getTopicById(@PathVariable String id) {
        if(topicService.doesTopicExist(id)) {
            return ResponseEntity.ok(topicService.getTopicById(id));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/topics")
    public ResponseEntity<Object> addTopic(@RequestBody Topic topic) {
        if(topic == null || topic.getId() == null || topic.getName() == null || topic.getDescription() == null) {
            return ResponseEntity.badRequest().body("Invalid topic");
        }

        if(topicService.doesTopicExist(topic.getId())) {
            return ResponseEntity.badRequest().body("Topic with id " + topic.getId() + " already exists");
        }
        topicService.addTopic(topic);
        return ResponseEntity.ok().body("Topic added successfully");
    }

    @PutMapping("/topics/{id}")
    public ResponseEntity<Object> updateTopic(@PathVariable String id, @RequestBody Topic topic) {
        if(topic == null || topic.getName() == null || topic.getDescription() == null) {
            return ResponseEntity.badRequest().body("Invalid topic");
        }

        if(!topicService.doesTopicExist(id)) {
            return ResponseEntity.badRequest().body("Topic with id " + id + " does not exist");
        }
        topicService.addTopic(topic);
        return ResponseEntity.ok().body("Topic updated successfully");
    }

    @DeleteMapping("/topics/{id}")
    public ResponseEntity<Object> deleteTopic(@PathVariable String id) {
        if(!topicService.doesTopicExist(id)) {
            return ResponseEntity.badRequest().body("Topic with id " + id + " does not exist");
        }
        topicService.deleteTopic(id);
        return ResponseEntity.ok().body("Topic deleted successfully");
    }
}
