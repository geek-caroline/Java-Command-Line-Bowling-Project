package uk.co.geekcaroline.bowling;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: handleyc
 * Date: 20/01/2012
 * Time: 08:29
 * To change this template use File | Settings | File Templates.
 */
public class Competition {
    Player[] players;
    int frameCounter = 10;
    CommandLineController clc;
    
    public Competition(String[] playerNames, CommandLineController clc){
        this.clc = clc;
        players = new Player[playerNames.length];
        for(int i=0; i< playerNames.length; i++) {
            players[i] = new Player(playerNames[i]);
        }
    }
    
    public void start(){
        while(frameCounter>0) {
            for(int i=0; i<players.length; i++) {
                Integer frameNumber = 10-frameCounter;
                int pinsCount;
                for(int attempt=0; attempt<2; attempt++) {
                    do {
                        pinsCount = clc.getPlayerPins(frameNumber, players[i].name, attempt);
                    } while (pinsCount == -1);
                    players[i].getFrame(frameNumber).setScore(attempt, pinsCount);
                }
                clc.printScoreSheet(players);
            }
            frameCounter--;
        }
    }

}
