package com.github.consultingbot.cppconsultingbot.command;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

public abstract class AbstractCommand implements Command{
    protected String commandIdentifier;
    public abstract BotApiMethod<?> buildResponse(Update update);
    public abstract String getCommandIdentifier();
}
