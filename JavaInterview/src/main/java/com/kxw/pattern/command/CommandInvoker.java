package com.kxw.pattern.command;

public class CommandInvoker {

    private Command command;

    public CommandInvoker(Command command) {
        this.command = command;
    }

    public void invoke() {
        this.command.execute();
    }
}
