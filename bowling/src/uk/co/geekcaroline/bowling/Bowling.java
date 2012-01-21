package uk.co.geekcaroline.bowling;
import java.io.*;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Created by IntelliJ IDEA.
 * User: handleyc
 * Date: 20/01/2012
 * Time: 08:27
 * To change this template use File | Settings | File Templates.
 */
public class Bowling {
    private static Logger logger;
    //private static Console console;
    private static BufferedReader inputStreamReader;


    public static void main(String[] args) {
        //Console console = System.console();
        inputStreamReader = new BufferedReader(new InputStreamReader(System.in));

        //logger = getLogger();
//        CommandLineController commandLineController = new CommandLineController(console);

//        CommandLineController commandLineController = new CommandLineController(inputStreamReader, logger);
        CommandLineController commandLineController = new CommandLineController(inputStreamReader);

        int playerCount = commandLineController.getPlayerCount();
        assert playerCount>0 : "Player count is below permitted";
        assert playerCount<5 : "Player count is above permitted";

        String[] playerNames = commandLineController.getPlayerNames(playerCount);
        assert playerNames.length == playerCount+1 : "player names array not long enough";

        Competition competition = new Competition(playerNames, commandLineController);

        competition.start();

        //make new competition
        //  -enter player number
        //  -enter names
        //  -enter rounds?
        //  -
    }

//    private static Logger getLogger(){
//        Properties prop = null;
//        Logger logger = Logger.getLogger("uk.co.geek-caroline.bowling");
//        FileHandler fh;
//
//        try {
//            fh = new FileHandler("logs/log.txt", true);
//            logger.addHandler(fh);
//            logger.setLevel(Level.ALL);
//            SimpleFormatter formatter = new SimpleFormatter();
//            fh.setFormatter(formatter);
//        } catch (SecurityException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return logger;
//    }
    //             Bowling
    //   |             |         |
    // Competition  Players   Printer
    //   |
    //  Frames
    //   |
    //  Scores
}
