package com.kxw.pattern.command;

public class CommandClient {

    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        //执行命令A
        new CommandInvoker(new CommandA(receiver)).invoke();
        //执行命令B
        new CommandInvoker(new CommandB(receiver)).invoke();
    }

}
