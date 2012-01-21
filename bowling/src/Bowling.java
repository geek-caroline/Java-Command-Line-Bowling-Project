import java.util.logging.Logger;

/**
 * Created by IntelliJ IDEA.
 * User: handleyc
 * Date: 20/01/2012
 * Time: 08:27
 * To change this template use File | Settings | File Templates.
 */
public class Bowling {
    private static Logger logger = Logger.getLogger("com.wombat.nose");
    public static void main() {

        CommandLineController commandLineController = new CommandLineController();
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
