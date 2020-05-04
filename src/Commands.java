import com.sun.istack.internal.Nullable;

import java.util.ArrayList;

public class Commands {
    public String command;
    public String help_command;
    public String[] aliases = null;


    public Commands(String cmd, String help_command){
        this.command = cmd;
        this.help_command = help_command;
    }

    public Commands(String cmd, String help_command, String[] alias){
        this.command = cmd;
        this.help_command = help_command;
        this.aliases = alias;
    }

    public void on_command(ArrayList<String> args){

    }


}
