package com.github.consultingbot.cppconsultingbot.repository.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "practice_topics")
@Data
public class PracticeTopic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "practice_topic_name", nullable = false)
    private String topicName;

    @Column(name = "material", nullable = false)
    private String material;
}
