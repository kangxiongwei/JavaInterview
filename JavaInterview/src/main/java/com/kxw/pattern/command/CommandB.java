package com.kxw.pattern.command;

/**
 * 命令B的具体实现
 */
public class CommandB implements Command {

    private Receiver receiver;

    public CommandB(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        this.receiver.doMethod2();
    }
}
