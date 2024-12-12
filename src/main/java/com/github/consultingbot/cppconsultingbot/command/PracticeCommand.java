package com.github.consultingbot.cppconsultingbot.command;

import com.github.consultingbot.cppconsultingbot.keyboard.PracticeKeyboard;
import com.github.consultingbot.cppconsultingbot.service.PracticeTopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.List;

import static com.github.consultingbot.cppconsultingbot.command.CommandName.PRACTICE;

@Component
@RequiredArgsConstructor
public class PracticeCommand extends AbstractCommand{
    private final PracticeTopicService practiceTopicService;
    private final PracticeKeyboard practiceKeyboard;
    private final PracticeIdCommand practiceIdCommand;

    // Текстовое сообщение по умолчанию, когда команда "теория" активируется
    public final String PRACTICE_MESSAGE = "Выберите тему для практики:";

    @Override
    public BotApiMethod<?> buildResponse(Update update) {
        SendMessage sendMessage = new SendMessage();
        Long chatId;

        // Получаем chatId в зависимости от того, пришло ли сообщение или callback
        if (update.hasMessage() && update.getMessage().hasText()) {
            chatId = update.getMessage().getChatId();
        } else if (update.hasCallbackQuery()) {
            chatId = update.getCallbackQuery().getMessage().getChatId();
        } else {
            throw new IllegalArgumentException("Ошибка: сообщение или callback-запрос не содержат chatId.");
        }

        sendMessage.setChatId(chatId.toString());
        if (update.hasMessage()) {
            sendMessage.setText(PRACTICE_MESSAGE);  // Текст приветствия или инструкции
        }

        // Генерируем клавиатуру с темами
        List<List<InlineKeyboardButton>> keyboard = practiceKeyboard.getPracticeKeyboard(practiceTopicService);
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        markup.setKeyboard(keyboard);

        // Устанавливаем клавиатуру
        sendMessage.setReplyMarkup(markup);

        if (update.hasCallbackQuery()) {
            String callbackData = update.getCallbackQuery().getData();
            if (callbackData.startsWith("/practice")) {
                // Обработка данных из TheoryIdCommand
                SendMessage callbackMessage = (SendMessage) practiceIdCommand.buildResponse(update);

                // Проверяем, что callbackMessage.getText() не равно null
                String callbackText = callbackMessage.getText();
                if (callbackText == null || callbackText.isEmpty()) {
                    callbackText = PRACTICE_MESSAGE;
                }

                // Устанавливаем текст материала или сообщение об ошибке
                sendMessage.setText(callbackText); // Заменяем текст на материал по теме
            }
        }

        // Отправляем сообщение
        return sendMessage;
    }

    @Override
    public String getCommandIdentifier() {
        return PRACTICE.getCommandName();  // /theory
    }
}
