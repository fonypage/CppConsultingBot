package com.github.consultingbot.cppconsultingbot.command;

import com.github.consultingbot.cppconsultingbot.keyboard.StartKeyboard;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

import static com.github.consultingbot.cppconsultingbot.command.CommandName.BACK;

@Component
@RequiredArgsConstructor
public class BackCommand extends AbstractCommand{
    private StartCommand startCommand = new StartCommand();
    @Override
    public BotApiMethod<?> buildResponse(Update update) {
        SendMessage sendMessage = new SendMessage();
        Long chatId;
        String backType;
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        if (update.hasCallbackQuery()) {
            chatId = update.getCallbackQuery().getMessage().getChatId();
            backType = update.getCallbackQuery().getData().split(" ")[1];
        }else throw new IllegalArgumentException("Не содержит корректного сообщения.");
        if (backType.equals("start")){
            markup = StartKeyboard.GetStartKeyboard();
        }
        sendMessage.setChatId(chatId.toString());
        sendMessage.setText(startCommand.START_MESSAGE);
        sendMessage.setReplyMarkup(markup);
        return sendMessage;
    }

    @Override
    public String getCommandIdentifier() {
        return BACK.getCommandName();
    }
}
