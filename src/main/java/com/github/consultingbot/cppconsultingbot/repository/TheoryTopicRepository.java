package com.github.consultingbot.cppconsultingbot.repository;

import com.github.consultingbot.cppconsultingbot.repository.entity.TheoryTopic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TheoryTopicRepository extends JpaRepository<TheoryTopic, Long> {
    // Найти тему по названию
    Optional<TheoryTopic> findById(long id);
}
