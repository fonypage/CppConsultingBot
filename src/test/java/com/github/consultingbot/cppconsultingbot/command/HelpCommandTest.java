package com.github.consultingbot.cppconsultingbot.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.github.consultingbot.cppconsultingbot.command.CommandName.HELP;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@DisplayName("Unit-level testing for HelpCommand")
public class HelpCommandTest {

    private HelpCommand helpCommand;
    private Update update;
    private Message message;

    @BeforeEach
    public void setUp() {
        helpCommand = new HelpCommand();
        update = Mockito.mock(Update.class);
        message = Mockito.mock(Message.class);
    }

    @Test
    public void testHelpCommandMessage() {
        long chatId = 123456L;

        when(update.getMessage()).thenReturn(message);
        when(message.getChatId()).thenReturn(chatId);

        SendMessage sendMessage = helpCommand.buildResponse(update);

        assertEquals(String.valueOf(chatId), sendMessage.getChatId());
        assertEquals(HelpCommand.HELP_MESSAGE, sendMessage.getText());
    }

    @Test
    public void testGetCommandIdentifier() {
        String expectedIdentifier = HELP.getCommandName();
        String actualIdentifier = helpCommand.getCommandIdentifier();

        assertEquals(expectedIdentifier, actualIdentifier);
    }
}
