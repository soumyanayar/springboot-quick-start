package com.example.spring_app.topic.repository;

import com.example.spring_app.topic.entity.Topic;
import org.springframework.data.repository.CrudRepository;


public interface TopicRepository extends CrudRepository<Topic, String> {

}


