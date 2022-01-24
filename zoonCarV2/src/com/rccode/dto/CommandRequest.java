package com.rccode.dto;

import com.google.gson.Gson;
import com.rccode.enumeration.Command;

public class CommandRequest {
    private Command command;
    private String payload;

    public CommandRequest(Command command, String payload) {
        this.command = command;
        this.payload = payload;
    }

    public Object getCommandRequest() {
        return new Gson().fromJson(this.payload, this.command.getRequestPayloadClass());
    }

    public Command getCommand() {
        return command;
    }
}
