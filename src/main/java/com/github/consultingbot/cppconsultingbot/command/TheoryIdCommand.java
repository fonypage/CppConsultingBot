package com.github.consultingbot.cppconsultingbot.command;

import com.github.consultingbot.cppconsultingbot.service.TheoryTopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@RequiredArgsConstructor
public class TheoryIdCommand extends AbstractCommand {

    private final TheoryTopicService theoryTopicService;

    @Override
    public BotApiMethod<?> buildResponse(Update update) {
        SendMessage sendMessage = new SendMessage();

        // Обрабатываем callback-запрос (когда нажимают на кнопку с темой)
        if (update.hasCallbackQuery()) {
            String callbackData = update.getCallbackQuery().getData();  // Получаем данные из callback

            // Проверяем, что callbackData начинается с /theory и есть пробел после этой строки
            if (callbackData.startsWith("/theory") && callbackData.length() > "/theory ".length()) {
                String[] parts = callbackData.split(" ");  // Разделяем данные по пробелу

                if (parts.length > 1) {
                    try {
                        String topicIdString = parts[1];  // Получаем ID темы

                        // Преобразуем ID в Long
                        Long topicId = Long.parseLong(topicIdString);

                        // Получаем материал по ID
                        String topicMaterial = theoryTopicService.getMaterialById(topicId);

                        // Устанавливаем материал в sendMessage
                        sendMessage.setChatId(update.getCallbackQuery().getMessage().getChatId().toString());
                        sendMessage.setText(topicMaterial);
                    } catch (NumberFormatException e) {
                        sendMessage.setText("Некорректный ID темы. Пожалуйста, выберите правильную тему.");
                    }
                } else {
                    sendMessage.setText("Не удалось найти ID темы. Пожалуйста, выберите правильную тему.");
                }
            }
        }

        return sendMessage;
    }

    @Override
    public String getCommandIdentifier() {
        return "theory_id_command";  // Этот класс отвечает на запросы с ID темы
    }
}




