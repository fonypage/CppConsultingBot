package com.github.consultingbot.cppconsultingbot.bot;

import com.github.consultingbot.cppconsultingbot.command.CommandContainer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static com.github.consultingbot.cppconsultingbot.command.CommandName.NO;

@Component
@RequiredArgsConstructor
public class ConsultingTelegramBot extends TelegramLongPollingBot {

    public static final String COMMAND_PREFIX = "/";

    @Value("${bot.username}")
    private String username;

    @Value("${bot.token}")
    private String token;

    private final CommandContainer commandContainer;

    @Override
    public void onUpdateReceived(Update update) {
            if (update.hasMessage() && update.getMessage().hasText()) {
                String message = update.getMessage().getText().trim();
                executeResponse(update, message);
            } else if (update.hasCallbackQuery()) {
                String callData = update.getCallbackQuery().getData();
                executeResponse(update, callData);
            }
    }

    private void executeResponse(Update update, String message) {
        BotApiMethod<?> response;

        if (message.startsWith(COMMAND_PREFIX)) {
            String commandIdentifier = message.split(" ")[0].toLowerCase();
            response = commandContainer.retrieveCommand(commandIdentifier).buildResponse(update);
        } else {
            response = commandContainer.retrieveCommand(NO.getCommandName()).buildResponse(update);
        }

        executeBotMethod(response);
    }

    private void executeBotMethod(PartialBotApiMethod<?> botMethod) {
        try {
            if (botMethod instanceof SendMessage) {
                execute((SendMessage) botMethod);
            } else if (botMethod instanceof EditMessageText) {
                execute((EditMessageText) botMethod);
            }
        } catch (TelegramApiException e) {
            throw new RuntimeException("Ошибка при выполнении метода Telegram API", e);
        }
    }

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }
}

