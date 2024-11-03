package com.github.consultingbot.cppconsultingbot.command;

import com.github.consultingbot.cppconsultingbot.service.SendBotMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.github.consultingbot.cppconsultingbot.command.CommandName.*;

@RequiredArgsConstructor
@Component
public class CommandContainer {
    private final List<Command> commands;
    private final UnknownCommand unknownCommand;


    public Command retrieveCommand(String commandIdentifier){
        return commands.stream()
                .filter(command -> commandIdentifier.equalsIgnoreCase(command.getCommandIdentifier()))
                .findFirst()
                .orElse(unknownCommand);
    }
}