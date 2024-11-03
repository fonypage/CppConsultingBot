package com.github.consultingbot.cppconsultingbot.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
@Component
@RequiredArgsConstructor
public class UnknownCommand extends AbstractCommand{

    public static final String UNKNOWN_MESSAGE="Не понимаю вас, напишите /help, чтобы узнать список поддерживащихся команд.";
    @Override
    public SendMessage buildResponse(Update update) {
        SendMessage sendMessage = new SendMessage();

        // Получение chatId
        Long chatId;
        if (update.hasMessage() && update.getMessage().hasText()) {
            chatId = update.getMessage().getChatId();
        } else if (update.hasCallbackQuery()) {
            chatId = update.getCallbackQuery().getMessage().getChatId();
        } else {
            throw new IllegalArgumentException("Не содержит корректного сообщения.");
        }
        sendMessage.setChatId(chatId);
        sendMessage.setText(UNKNOWN_MESSAGE);
        return sendMessage;
    }

    @Override
    public String getCommandIdentifier() {
        return "";
    }
}