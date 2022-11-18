package com.example.spring_app.topic.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Topic {
    @Id
    private String id;
    private String name;
    private String description;
}

