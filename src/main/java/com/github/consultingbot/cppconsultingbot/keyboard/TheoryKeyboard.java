package com.github.consultingbot.cppconsultingbot.keyboard;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class TheoryKeyboard {
    public static List<List<InlineKeyboardButton>> GetTheoryKeyboard(){
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInline = new ArrayList<>();
        InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
        inlineKeyboardButton.setText("Типы данных");
        inlineKeyboardButton.setCallbackData("/theme id");
        rowInline.add(inlineKeyboardButton);
        rowsInline.add(rowInline);
        return rowsInline;
    }
}
