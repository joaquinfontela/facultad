package Command.Commands;

import Command.Commands.Command;
import Command.Player;

public class GoDownCommand implements Command {

    Player player;

    public GoDownCommand(Player newPlayer) {

        player = newPlayer;
    }

    @Override
    public void execute() {

        player.goDown();
    }
}
