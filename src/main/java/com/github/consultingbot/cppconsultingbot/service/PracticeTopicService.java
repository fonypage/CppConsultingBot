package com.github.consultingbot.cppconsultingbot.service;

import com.github.consultingbot.cppconsultingbot.repository.entity.PracticeTopic;
import com.github.consultingbot.cppconsultingbot.repository.entity.TheoryTopic;

import java.util.List;

public interface PracticeTopicService {
    List<PracticeTopic> getAllTopics();
    String getMaterialById(long id);
}
