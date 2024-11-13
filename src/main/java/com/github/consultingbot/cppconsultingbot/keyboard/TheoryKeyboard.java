package com.github.consultingbot.cppconsultingbot.keyboard;

import com.github.consultingbot.cppconsultingbot.repository.entity.TheoryTopic;
import com.github.consultingbot.cppconsultingbot.service.TheoryTopicService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@Component
public class TheoryKeyboard {
    public List<List<InlineKeyboardButton>> getTheoryKeyboard(TheoryTopicService theoryTopicService) {
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<TheoryTopic> topics = theoryTopicService.getAllTopics(); // Получаем список тем через сервис

        // Создаем кнопки для каждой темы
        for (TheoryTopic topic : topics) {
            List<InlineKeyboardButton> rowInline = new ArrayList<>();
            InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
            inlineKeyboardButton.setText(topic.getTopicName());
            inlineKeyboardButton.setCallbackData("/theory " + topic.getId());  // callbackData включает тему
            rowInline.add(inlineKeyboardButton);
            rowsInline.add(rowInline);
        }
        rowsInline.add(BackButton.GetBackOnStartButton());
        return rowsInline;
    }
}
