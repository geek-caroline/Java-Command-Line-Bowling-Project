package uk.co.geekcaroline.bowling;

import javax.management.QueryEval;
import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.logging.Logger;

/**
 * Created by IntelliJ IDEA.
 * User: handleyc
 * Date: 20/01/2012
 * Time: 08:49
 * To change this template use File | Settings | File Templates.
 */
public class CommandLineController {
    final String PLAYER_COUNT_WRONG = "Sorry, that is an invalid player count, it must be a number between 1 and 4, e.g. 2";
    final String ENTER_PLAYER_COUNT = "Please enter number of players:";
    final String ENTER_NAME_TEMPLATE = "Please enter the name for player %s";
    final String PLAYER_NAME_WRONG = "Sorry, the name must be less that 10 characters long";
    final String QUERY_PIN_COUNT = "We are in frame, {0}, how many pins has {1} knocked over in his/her {2} go?";
    final String INVALID_SCORE_MESSAGE = "Sorry, your score must be between 1 and 10";
    final String SCORE_SHEET_HEADER = "            Frame number  |   1   ||   2   ||   3   ||   4   ||   5   ||   6   ||   7   ||   8   ||   9   ||  10   |";
    
    Logger logger;
    
    //Console console;
    BufferedReader input;


    //public CommandLineController(Console console){
//    public CommandLineController(BufferedReader input, Logger logger){
    public CommandLineController(BufferedReader input){
        //this.console = console;
        this.input = input;
        this.logger = logger;
    }

    public int getPlayerCount() {
        int playerCount;
        do {
            //            String playerCountStr = console.readLine(ENTER_PLAYER_COUNT);
            System.out.println(ENTER_PLAYER_COUNT);
            String playerCountStr = null;
            try {
                playerCountStr = input.readLine();
            } catch (IOException e) {
                System.out.println("issues reading"+e.getMessage());
            }
            playerCount = this.getValidPlayerCount(playerCountStr);
        } while (playerCount == -1);

        return playerCount;
    }

    private int getValidPlayerCount(String userInput) {
        if(userInput.length()>1 || !Character.isDigit(userInput.charAt(0))){
            System.out.println(PLAYER_COUNT_WRONG);
            return -1;
        }
        Integer playerCount = -1;
        try {
            //for some reason this isn't returning an integer, it's returning null
            playerCount = Integer.valueOf(userInput);
        } catch (NumberFormatException nfe) {
            logger.warning(
                    "An exception has occured that should not be possible due to checks, userInput was: " + userInput
                    + ", printing stack trace:" + nfe.getStackTrace());
        }
        if( playerCount>4 || playerCount<1 ) {
            System.out.println(PLAYER_COUNT_WRONG);
            return -1;
        }
        return playerCount;
    }

    public String[] getPlayerNames(int playerCount) {
        String[] playerNames = new String[playerCount];

        for (int i = 0; i < playerCount; i++) {
            String playerNameReq = String.format(ENTER_NAME_TEMPLATE, Integer.toString(i+1));
            String name = null;
            do {
//                name = console.readLine(playerNameReq);
                System.out.println(playerNameReq);
                try {
                    name = input.readLine();
                } catch (IOException e) {
                    System.out.println("issues reading"+e.getMessage());
                }
            } while (!this.isValidName(name));
            assert name.length() > 0 : "name length is too short";
            assert name.length() < 11 : "name length is too long";
            playerNames[i] = name;
        }

        return playerNames;
    }

    private boolean isValidName(String name) {
        if(name.length() < 1 || name.length()>10){
            System.out.println(PLAYER_NAME_WRONG);
            return false;
        }
        return true;
    }
    
    public int getPlayerPins(int frameNumber, String name, int attemptNumber) {
        String ordinal = "first";
        if (attemptNumber == 1) {
            ordinal = "second";
        } else if (attemptNumber == 2) {
            ordinal = "extra";
        }
        MessageFormat mf = new MessageFormat(QUERY_PIN_COUNT);
        String pinCountStr = "";
        int pinCount = -1;
        do {
//                name = console.readLine(playerNameReq);
            Integer outputFrameNumber = 1+frameNumber;
            String[] tokens =  {outputFrameNumber.toString(), name, ordinal};
            System.out.println(mf.format(tokens));
            try {
                pinCountStr = input.readLine();
                pinCount = this.isValidPinCount(pinCountStr);
            } catch (IOException e) {
                System.out.println("issues reading"+e.getMessage());
            }
        } while (pinCount == -1);
        assert pinCount >= 0 : "pin count is less than 1";
        assert pinCount <= 10 : "pin count is greater than 10";
        return pinCount;
    }
    
    private int isValidPinCount(String pinCountStr) {
        int pinCount;
        try {
            pinCount = Integer.valueOf(pinCountStr);
        } catch (NumberFormatException nfe) {
            System.out.println(INVALID_SCORE_MESSAGE);
            return -1;
        }
        if (pinCount<0 || pinCount>10) {
            System.out.println(INVALID_SCORE_MESSAGE);
            return -1;
        }
        return pinCount;
    }

    public void printScoreSheet(Player[] players) {
        System.out.println("Here are the scores so far:");
        System.out.println(SCORE_SHEET_HEADER);
        for(int i=0; i<players.length; i++) {
            players[i].printScoreSheet();
        }

    }
}
