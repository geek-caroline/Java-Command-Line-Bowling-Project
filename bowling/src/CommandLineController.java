import java.io.Console;

/**
 * Created by IntelliJ IDEA.
 * User: handleyc
 * Date: 20/01/2012
 * Time: 08:49
 * To change this template use File | Settings | File Templates.
 */
public class CommandLineController {
    String title = "title";
    String menu = "Enter player name:";
    final String PLAYER_COUNT_ERROR = "Sorry, that is an invalid player count, it must be a number between 1 and 4, e.g. 2";
    StringBuffer gameProgressReport = new StringBuffer();
    Console console;
    public CommandLineController(){
        console = System.console();
    }

    public int getPlayerCount() {
        int playerCount;
        do {
            String playerCount = console.readLine("Please enter number of players:");
            playerCount = this.getValidPlayerCount(playerCount);

        } while (!isValidPlayerCount);

        return 1;
    }

    private int getValidPlayerCount(String userInput) {
        if(userInput.length()>1 || !Character.isDigit(userInput.charAt(0))){
            System.out.println(PLAYER_COUNT_ERROR);
            return -1;
        }
        int playerCount = -1;
        try {
            playerCount = Integer.getInteger(userInput);
        } catch (NumberFormatException nfe) {

        }
        if( playerCount>4 || playerCount<1 ) {
            System.out.println(PLAYER_COUNT_ERROR);
            return -1;
        }
        return playerCount;
    }

    public String getPlayerNames(int playerCount) {
        String[] playerNames = new String[playerCount];
        for (int i = 0; i < playerCount; i++) {
            System.out.println("Please enter the name of player " + Integer.toString(playerNumber);
            String name = "bob";
            playerNames[i] = name
    }
}
