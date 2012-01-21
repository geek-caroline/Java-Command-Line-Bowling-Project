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

    String playerNameRequestTemplate = "Please enter the name for player $playerNumber";


    public CommandLineController(){
        console = System.console();
    }

    public int getPlayerCount() {
        int playerCount;
        do {
            String playerCountStr = console.readLine("Please enter number of players:");
            playerCount = this.getValidPlayerCount(playerCountStr);

        } while (playerCount != -1);

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

    public String[] getPlayerNames(int playerCount) {
        String[] playerNames = new String[playerCount];

        for (int i = 0; i < playerCount; i++) {
            String playerNameReq = String.format(playerNameRequestTemplate, Integer.toString(i));
            String name;
            do {
                name = console.readLine(playerNameReq);
            } while (!this.isValidName(name));
            playerNames[i] = name;
        }
        return playerNames;
    }

    private boolean isValidName(String name) {
        if(name.length()>10){
            return false;
        }
        return true;
    }
}
