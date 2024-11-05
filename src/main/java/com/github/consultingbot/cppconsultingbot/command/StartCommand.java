package com.github.consultingbot.cppconsultingbot.command;

import com.github.consultingbot.cppconsultingbot.keyboard.StartKeyboard;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

import static com.github.consultingbot.cppconsultingbot.command.CommandName.START;

@Component
@RequiredArgsConstructor
@Getter
public class StartCommand extends AbstractCommand{

    public final static String START_MESSAGE = "Привет! Я CppConsultingBot. Я помогу тебе изучить такой язык программирования как C++. " +
            "Напиши /help, чтобы узнать команды.";

    @Override
    public SendMessage buildResponse(Update update){
        SendMessage sendMessage = new SendMessage();
        Long chatId;
        if(update.hasMessage() && update.getMessage().hasText()){
            chatId = update.getMessage().getChatId();
        } else if (update.hasCallbackQuery()) {
            chatId = update.getCallbackQuery().getMessage().getChatId();
        }else throw new IllegalArgumentException("Не содержит корректного сообщения.");
        sendMessage.setChatId(chatId.toString());
        sendMessage.setText(START_MESSAGE);
        InlineKeyboardMarkup markupInline = StartKeyboard.GetStartKeyboard();
        sendMessage .setReplyMarkup(markupInline);
        return sendMessage;
    }

    @Override
    public String getCommandIdentifier(){
        return START.getCommandName();
    }

}
