package com.github.consultingbot.cppconsultingbot.command;

import com.github.consultingbot.cppconsultingbot.keyboard.TheoryKeyboard;
import com.github.consultingbot.cppconsultingbot.service.TheoryTopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TheoryCommand extends AbstractCommand{
    private final TheoryTopicService theoryTopicService;
    private final TheoryKeyboard theoryKeyboard;
    private final TheoryIdCommand theoryIdCommand;

    // Текстовое сообщение по умолчанию, когда команда "теория" активируется
    public final String THEORY_MESSAGE = "Выберите тему для изучения:";

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
            sendMessage.setText(THEORY_MESSAGE);  // Текст приветствия или инструкции
        }

        // Генерируем клавиатуру с темами
        List<List<InlineKeyboardButton>> keyboard = theoryKeyboard.getTheoryKeyboard(theoryTopicService);
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        markup.setKeyboard(keyboard);

        // Устанавливаем клавиатуру
        sendMessage.setReplyMarkup(markup);

        if (update.hasCallbackQuery()) {
            String callbackData = update.getCallbackQuery().getData();
            if (callbackData.startsWith("/theory")) {
                // Обработка данных из TheoryIdCommand
                SendMessage callbackMessage = (SendMessage) theoryIdCommand.buildResponse(update);

                // Проверяем, что callbackMessage.getText() не равно null
                String callbackText = callbackMessage.getText();
                if (callbackText == null || callbackText.isEmpty()) {
                    callbackText = THEORY_MESSAGE;
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
        return CommandName.THEORY.getCommandName();  // /theory
    }
}
