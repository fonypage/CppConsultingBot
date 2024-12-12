//package com.github.consultingbot.cppconsultingbot.command;
//
//import com.github.consultingbot.cppconsultingbot.bot.ConsultingTelegramBot;
//import com.github.consultingbot.cppconsultingbot.keyboard.StartKeyboard;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
//import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
//import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
//import org.telegram.telegrambots.meta.api.objects.InputFile;
//import org.telegram.telegrambots.meta.api.objects.Update;
//import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
//import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
//
//import java.io.File;
//import java.io.Serializable;
//
//import static com.github.consultingbot.cppconsultingbot.command.CommandName.SENDDOC;
//
//@Component
//@RequiredArgsConstructor
//public class SendDocCommand extends AbstractCommand{
//    CommandContainer commandContainer;
//    @Override
//    public PartialBotApiMethod<?> buildResponse(Update update) {
//        ConsultingTelegramBot consultingTelegramBot = new ConsultingTelegramBot(commandContainer);
//        SendDocument sendDocument = new SendDocument();
//        Long chatId;
//        if (update.hasMessage() && update.getMessage().hasText()) {
//            chatId = update.getMessage().getChatId();
//        } else if (update.hasCallbackQuery()) {
//            chatId = update.getCallbackQuery().getMessage().getChatId();
//        } else throw new IllegalArgumentException("Не содержит корректного сообщения.");
//        sendDocument.setChatId(chatId.toString());
//
//        File file = new File("C:/Users/FonyP/IdeaProjects/CppConsultingBot/material.docx");
//
//        if (!file.exists()) {
//            throw new RuntimeException("Файл не существует: " + file.getAbsolutePath());
//        }
//
//        if (!file.canRead()) {
//            throw new RuntimeException("Файл существует, но недоступен для чтения: " + file.getAbsolutePath());
//        }
//
//        if (file.length() > 50 * 1024 * 1024) { // 50 МБ
//            throw new RuntimeException("Файл слишком большой для отправки через Telegram.");
//        }
//
//        InputFile inputFile = new InputFile("material.docx");
//        sendDocument.setDocument(inputFile);
//        System.out.println("Chat ID: " + chatId);
//        System.out.println("Путь к файлу: " + file.getAbsolutePath());
//        System.out.println("Файл существует: " + file.exists());
//        System.out.println("Файл доступен для чтения: " + file.canRead());
//        System.out.println("Размер файла: " + file.length());
//        try {
//            consultingTelegramBot.execute(sendDocument);
//        } catch (TelegramApiException e) {
//            System.err.println("Ошибка Telegram API: " + e.getMessage());
//            e.printStackTrace();
//            throw new RuntimeException("Детали ошибки: " + e.getMessage(), e);
//        }
//
//        return sendDocument;
//    }
//
//    @Override
//    public String getCommandIdentifier() {
//        return SENDDOC.getCommandName();
//    }
//}
