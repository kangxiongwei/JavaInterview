package com.kxw.pattern.command;

/**
 * 命令A的实现
 */
public class CommandA implements Command {

    private Receiver receiver;

    public CommandA(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        this.receiver.doMethod1();
    }
}
