package com.github.consultingbot.cppconsultingbot.repository.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "theory_topics")
@Data
public class TheoryTopic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "topic_name", nullable = false)
    private String topicName;

    @Column(name = "material", nullable = false)
    private String material;
}

