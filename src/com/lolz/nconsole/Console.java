package com.lolz.nconsole;

import java.util.Scanner;

public class Console {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public String prefix = "> ";
    public CommandRegister register;

    public void setPrefix(String prefix){
        this.prefix = prefix;
    }

    public void setRegister(CommandRegister register){
        this.register = register;
    }

    enum LogType {INFO, WARN, ERROR};

    public static void Log(LogType type, String msg){
        String prefix = "";
        if (type == LogType.INFO){
            prefix = ANSI_GREEN + "[INFO] ";
        } else if (type == LogType.WARN){
            prefix = ANSI_YELLOW + "[WARN] ";
        } else if (type == LogType.ERROR){
            prefix = ANSI_RED + "[ERROR] ";
        }
        System.out.println(prefix + msg);
        System.out.print(ANSI_WHITE);
    }


    public void update(){
        Scanner scan = new Scanner(System.in);
        System.out.print(this.prefix);
        String cmd = scan.next();
        this.register.checkInput(cmd);
    }

}
