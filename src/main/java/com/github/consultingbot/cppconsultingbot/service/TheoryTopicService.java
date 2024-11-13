package com.github.consultingbot.cppconsultingbot.service;

import com.github.consultingbot.cppconsultingbot.repository.entity.TheoryTopic;

import java.util.List;
import java.util.Optional;

public interface TheoryTopicService {
    List<TheoryTopic> getAllTopics();
    String getMaterialById(long id);
}