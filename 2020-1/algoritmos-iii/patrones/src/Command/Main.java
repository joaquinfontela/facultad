package Command;

import Command.Commands.*;
import Command.Keys.Key;

public class Main {

    public static void main(String[] args) {

        Player myPlayer = new Player();

        Command upCommand = new GoUpCommand(myPlayer);
        Command downCommand = new GoDownCommand(myPlayer);
        Command rightCommand = new GoRightCommand(myPlayer);
        Command leftCommand = new GoLeftCommand(myPlayer);

        Key upKey = new Key(upCommand);
        Key downKey = new Key(downCommand);
        Key rightKey = new Key(rightCommand);
        Key leftKey = new Key(leftCommand);

        upKey.press();
        upKey.press();
        upKey.press();
        rightKey.press();
        leftKey.press();
        leftKey.press();
        rightKey.press();
        downKey.press();
        upKey.press();

    }
}
