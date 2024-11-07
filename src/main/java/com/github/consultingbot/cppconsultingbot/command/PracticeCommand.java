package com.github.consultingbot.cppconsultingbot.command;

import com.github.consultingbot.cppconsultingbot.keyboard.BackButton;
import com.github.consultingbot.cppconsultingbot.keyboard.PracticeKeyboard;
import com.github.consultingbot.cppconsultingbot.keyboard.TheoryKeyboard;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

import static com.github.consultingbot.cppconsultingbot.command.CommandName.PRACTICE;

@Component
@RequiredArgsConstructor
@Getter
public class PracticeCommand extends AbstractCommand{
    public final String PRACTICE_MESSAGE = "Выберите тему задачи:";

    @Override
    public BotApiMethod<?> buildResponse(Update update) {
        SendMessage sendMessage = new SendMessage();
        Long chatId;
        if(update.hasMessage() && update.getMessage().hasText()){
            chatId = update.getMessage().getChatId();
        }else if (update.hasCallbackQuery()){
            chatId = update.getCallbackQuery().getMessage().getChatId();
        }else throw new IllegalArgumentException("Не содержит корректного сообщения");
        sendMessage.setChatId(chatId.toString());
        sendMessage.setText(PRACTICE_MESSAGE);
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.addAll(PracticeKeyboard.GetTheoryKeyboard());
        keyboard.add(BackButton.GetBackOnStartButton());
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        markup.setKeyboard(keyboard);
        sendMessage.setReplyMarkup(markup);
        return sendMessage;
    }

    @Override
    public String getCommandIdentifier() {
        return PRACTICE.getCommandName();
    }
}
