package com.github.consultingbot.cppconsultingbot.command;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface Command {
    BotApiMethod<?> buildResponse(Update update);
    String getCommandIdentifier();
}
