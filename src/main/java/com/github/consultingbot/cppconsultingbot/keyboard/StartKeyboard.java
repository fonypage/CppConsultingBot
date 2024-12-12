package com.github.consultingbot.cppconsultingbot.keyboard;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class StartKeyboard {
    public static InlineKeyboardMarkup GetStartKeyboard() {
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();

        List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
        InlineKeyboardButton theoryButton = new InlineKeyboardButton();
        theoryButton.setText("Теория");
        theoryButton.setCallbackData("/theory");

        InlineKeyboardButton practiceButton = new InlineKeyboardButton();
        practiceButton.setText("Практика");
        practiceButton.setCallbackData("/practice");

//        InlineKeyboardButton sendDocButton = new InlineKeyboardButton();
//        sendDocButton.setText("Получить материал");
//        sendDocButton.setCallbackData("/send_doc");

        rowInline1.add(theoryButton);
        rowInline1.add(practiceButton);
//        rowInline1.add(sendDocButton);

        rowsInline.add(rowInline1);
        markupInline.setKeyboard(rowsInline);

        return markupInline;
    }
}


