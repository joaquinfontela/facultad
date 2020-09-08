package Command.Commands;

import Command.Commands.Command;
import Command.Player;

public class GoUpCommand implements Command {

    Player player;

    public GoUpCommand(Player newPlayer) {

        player = newPlayer;
    }

    @Override
    public void execute() {

        player.goUp();
    }
}
