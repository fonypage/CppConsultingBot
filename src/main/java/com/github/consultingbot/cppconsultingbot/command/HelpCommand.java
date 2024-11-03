package com.github.consultingbot.cppconsultingbot.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.github.consultingbot.cppconsultingbot.command.CommandName.HELP;

@Component
@RequiredArgsConstructor
public class HelpCommand extends AbstractCommand{
    public static final String HELP_MESSAGE=String.format("Доcтупные команды\n\n"
            + "%s - Получить доступ к теоретическим материалам по C++.\n"
            + "%s - Получить доступ к практическим заданиям.\n\n","/theory","/practice");
    @Override
    public SendMessage buildResponse(Update update) {
        return new SendMessage(update.getMessage().getChatId().toString(),HELP_MESSAGE);
    }

    @Override
    public String getCommandIdentifier() {
        return HELP.getCommandName();
    }
}
