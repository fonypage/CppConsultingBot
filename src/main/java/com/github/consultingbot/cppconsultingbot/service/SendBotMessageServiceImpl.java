package com.github.consultingbot.cppconsultingbot.service;

import com.github.consultingbot.cppconsultingbot.bot.ConsultingTelegramBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SendBotMessageServiceImpl implements SendBotMessageService{

    private final ConsultingTelegramBot consultingBot;

    @Autowired
    public SendBotMessageServiceImpl(ConsultingTelegramBot consultingBot){
        this.consultingBot = consultingBot;
    }

    @Override
    public void sendMessage(String chatId, String message){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(message);
        sendMessage.enableHtml(true);

        try{
            consultingBot.execute(sendMessage);
        } catch (TelegramApiException e ){
            e.printStackTrace();
        }
    }
}
