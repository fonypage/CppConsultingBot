package com.github.consultingbot.cppconsultingbot.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@DisplayName("Unit-level testing for UnknownCommand")
public class UnknownCommandTest {

    private UnknownCommand unknownCommand;
    private Update update;
    private Message message;
    private CallbackQuery callbackQuery;

    @BeforeEach
    public void setUp() {
        unknownCommand = new UnknownCommand();
        update = Mockito.mock(Update.class);
        message = Mockito.mock(Message.class);
        callbackQuery = Mockito.mock(CallbackQuery.class);
    }

    @Test
    public void testUnknownCommandMessageWithTextMessage() {
        long chatId = 123456L;

        when(update.hasMessage()).thenReturn(true);
        when(update.getMessage()).thenReturn(message);
        when(message.hasText()).thenReturn(true);
        when(message.getChatId()).thenReturn(chatId);

        SendMessage sendMessage = unknownCommand.buildResponse(update);

        assertEquals(String.valueOf(chatId), sendMessage.getChatId());
        assertEquals(UnknownCommand.UNKNOWN_MESSAGE, sendMessage.getText());
    }

    @Test
    public void testUnknownCommandMessageWithCallbackQuery() {
        long chatId = 123456L;

        when(update.hasMessage()).thenReturn(false);
        when(update.hasCallbackQuery()).thenReturn(true);
        when(update.getCallbackQuery()).thenReturn(callbackQuery);
        when(callbackQuery.getMessage()).thenReturn(message);
        when(message.getChatId()).thenReturn(chatId);

        SendMessage sendMessage = unknownCommand.buildResponse(update);

        assertEquals(String.valueOf(chatId), sendMessage.getChatId());
        assertEquals(UnknownCommand.UNKNOWN_MESSAGE, sendMessage.getText());
    }

    @Test
    public void testUnknownCommandInvalidUpdate() {
        when(update.hasMessage()).thenReturn(false);
        when(update.hasCallbackQuery()).thenReturn(false);

        assertThrows(IllegalArgumentException.class, () -> unknownCommand.buildResponse(update));
    }

    @Test
    public void testGetCommandIdentifier() {
        String expectedIdentifier = "";
        String actualIdentifier = unknownCommand.getCommandIdentifier();

        assertEquals(expectedIdentifier, actualIdentifier);
    }
}
