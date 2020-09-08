package Command.Keys;

import Command.Commands.Command;

public class Key {

    Command command;

    public Key(Command newCommand) {

        command = newCommand;
    }

    public void press() {

        command.execute();
    }
}
