package com.example.spring_app.topic.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Topic {
    private String id;
    private String name;
    private String description;
}

