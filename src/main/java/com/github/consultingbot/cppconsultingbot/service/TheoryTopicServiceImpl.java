package com.github.consultingbot.cppconsultingbot.service;


import com.github.consultingbot.cppconsultingbot.repository.TheoryTopicRepository;
import com.github.consultingbot.cppconsultingbot.repository.entity.TheoryTopic;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TheoryTopicServiceImpl implements TheoryTopicService {

    private final TheoryTopicRepository repository;

    @Override
    public List<TheoryTopic> getAllTopics() {
        return repository.findAll();
    }

    @Override
    public String getMaterialById(long id) {
        // Находим тему по ID (метод findById возвращает Optional<TheoryTopic>)
        Optional<TheoryTopic> optionalTheoryTopic = repository.findById(id);

        // Если тема найдена, возвращаем материал, иначе возвращаем сообщение о том, что материал не найден
        return optionalTheoryTopic.map(TheoryTopic::getMaterial)
                .orElse("Материал по выбранной теме не найден.");
    }
}
