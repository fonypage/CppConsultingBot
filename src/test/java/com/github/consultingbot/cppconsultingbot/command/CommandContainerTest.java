//package com.github.consultingbot.cppconsultingbot.command;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.*;
//
//public class CommandContainerTest {
//
//    private CommandContainer commandContainer;
//    private Command startCommand;
//    private Command helpCommand;
//    private UnknownCommand unknownCommand;
//
//    @BeforeEach
//    public void setUp() {
//        startCommand = Mockito.mock(StartCommand.class);
//        helpCommand = Mockito.mock(HelpCommand.class);
//        unknownCommand = Mockito.mock(UnknownCommand.class);
//
//        List<Command> commands = Arrays.asList(startCommand, helpCommand);
//
//        commandContainer = new CommandContainer(commands, unknownCommand);
//
//        when(startCommand.getCommandIdentifier()).thenReturn("/start");
//        when(helpCommand.getCommandIdentifier()).thenReturn("/help");
//        when(unknownCommand.getCommandIdentifier()).thenReturn("/unknown");
//    }
//
//    @Test
//    public void testRetrieveCommand_ExistingCommand() {
//        Command command = commandContainer.retrieveCommand("/start");
//        assertEquals(startCommand, command);
//    }
//
//    @Test
//    public void testRetrieveCommand_NonExistingCommand() {
//        Command command = commandContainer.retrieveCommand("/nonexistent");
//        assertEquals(unknownCommand, command);
//    }
//
//    @Test
//    public void testRetrieveCommand_CaseInsensitive() {
//        Command command = commandContainer.retrieveCommand("/HELP");
//        assertEquals(helpCommand, command);
//    }
//}
