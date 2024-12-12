package com.github.consultingbot.cppconsultingbot.repository;

import com.github.consultingbot.cppconsultingbot.repository.entity.PracticeTopic;
import com.github.consultingbot.cppconsultingbot.repository.entity.TheoryTopic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PracticeTopicRepository extends JpaRepository<PracticeTopic, Long> {
    Optional<PracticeTopic> findById(long id);
}
