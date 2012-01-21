import java.io.Console;
import java.util.logging.Logger;

/**
 * Created by IntelliJ IDEA.
 * User: handleyc
 * Date: 20/01/2012
 * Time: 08:27
 * To change this template use File | Settings | File Templates.
 */
public class Bowling {
    private static Logger logger = Logger.getLogger("uk.co.geek-caroline.bowling");
    public static void main(String[] args) {
        Console console = System.console();
        System.out.println("console is"+console.toString());
        CommandLineController commandLineController = new CommandLineController(console);
        int playerCount = commandLineController.getPlayerCount();
        Competition competition = new Competition(playerCount);

        String[] playerNames = commandLineController.getPlayerNames(playerCount);
        competition.setPlayerNames(playerNames);
        //make new competition
        //  -enter player number
        //  -enter names
        //  -enter rounds?
        //  -
    }
    //             Bowling
    //   |             |         |
    // Competition  Players   Printer
    //   |
    //  Frames
    //   |
    //  Scores
}
