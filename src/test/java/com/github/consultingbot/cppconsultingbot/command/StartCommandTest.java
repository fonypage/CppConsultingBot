package com.github.consultingbot.cppconsultingbot.command;

import com.github.consultingbot.cppconsultingbot.keyboard.FirstKeyboard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@DisplayName("Unit-level testing for StartCommand")
public class StartCommandTest {

    private StartCommand startCommand;
    private Update update;
    private Message message;
    private CallbackQuery callbackQuery;

    @BeforeEach
    public void setUp() {
        startCommand = new StartCommand();
        update = Mockito.mock(Update.class);
        message = Mockito.mock(Message.class);
        callbackQuery = Mockito.mock(CallbackQuery.class);
    }

    @Test
    public void testBuildResponse_WithMessage() {
        when(update.hasMessage()).thenReturn(true);
        when(update.getMessage()).thenReturn(message);
        when(message.hasText()).thenReturn(true);
        when(message.getChatId()).thenReturn(123456L);

        InlineKeyboardMarkup markupInline = FirstKeyboard.GetStartKeyboard();

        SendMessage sendMessage = startCommand.buildResponse(update);

        assertEquals("123456", sendMessage.getChatId());
        assertEquals(StartCommand.START_MESSAGE, sendMessage.getText());
        assertEquals(markupInline, sendMessage.getReplyMarkup());
    }

    @Test
    public void testBuildResponse_WithCallbackQuery() {
        when(update.hasMessage()).thenReturn(false);
        when(update.hasCallbackQuery()).thenReturn(true);
        when(update.getCallbackQuery()).thenReturn(callbackQuery);
        when(callbackQuery.getMessage()).thenReturn(message);
        when(message.getChatId()).thenReturn(123456L);

        InlineKeyboardMarkup markupInline = FirstKeyboard.GetStartKeyboard();

        SendMessage sendMessage = startCommand.buildResponse(update);

        assertEquals("123456", sendMessage.getChatId());
        assertEquals(StartCommand.START_MESSAGE, sendMessage.getText());
        assertEquals(markupInline, sendMessage.getReplyMarkup());
    }

    @Test
    public void testBuildResponse_InvalidUpdate() {
        when(update.hasMessage()).thenReturn(false);
        when(update.hasCallbackQuery()).thenReturn(false);

        assertThrows(IllegalArgumentException.class, () -> startCommand.buildResponse(update));
    }
}
