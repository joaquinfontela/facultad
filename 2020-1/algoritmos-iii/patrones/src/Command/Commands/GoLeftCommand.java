package Command.Commands;

import Command.Commands.Command;
import Command.Player;

public class GoLeftCommand implements Command {

    Player player;

    public GoLeftCommand(Player newPlayer){

        player = newPlayer;
    }

    @Override
    public void execute() {

        player.goLeft();
    }
}
