package Command.Commands;

import Command.Commands.Command;
import Command.Player;

public class GoRightCommand implements Command {

    Player player;

    public GoRightCommand(Player newPlayer) {

        player = newPlayer;
    }

    @Override
    public void execute() {

        player.goRight();
    }
}
