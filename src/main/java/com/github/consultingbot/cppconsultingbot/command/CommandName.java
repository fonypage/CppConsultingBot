package com.github.consultingbot.cppconsultingbot.command;

public enum CommandName {
    START("/start"),
    HELP("/help"),
    NO("nocommand"),
    THEORY("/theory"),
    BACK("/back");

    private final String commandName;

    CommandName(String commandName){
        this.commandName = commandName;
    }

    public String getCommandName(){
        return commandName;
    }
}
