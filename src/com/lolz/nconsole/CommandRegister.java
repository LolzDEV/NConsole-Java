package com.lolz.nconsole;

import java.util.ArrayList;
import java.util.Arrays;

public class CommandRegister {
    ArrayList<Commands> commands = new ArrayList<>();

    public void registerCommand(Commands command){
        this.commands.add(command);
    }

    public Commands getCommandFromName(String name){
        for (Commands command : commands) {
            if (command.command.equals(name)) {
                return command;
            }
        }
        return null;
    }

    public void checkInput(String cmd){
        String[] splitted = cmd.split(" ");
        ArrayList<String> args = new ArrayList<String>(Arrays.asList(splitted).subList(1, splitted.length));
        int error = 0;
        int max_error = 0;
        for (Commands command : this.commands) {
            if (command.aliases == null){
                max_error += 1;
                if (splitted[0].equals(command.command)){
                    command.on_command(args);
                    break;
                } else {
                    error += 1;
                }
            } else {
                for (String alias : command.aliases){
                    max_error += 1;
                    if (splitted[0].equals(command.command) || splitted[0].equals(alias)){
                        command.on_command(args);
                        break;
                    } else {
                        error += 1;
                    }
                }
            }
        }
        if (error == max_error){
            Console.Log(Console.LogType.ERROR, "Command " + splitted[0] + " is an invalid command");
        }
    }


}
