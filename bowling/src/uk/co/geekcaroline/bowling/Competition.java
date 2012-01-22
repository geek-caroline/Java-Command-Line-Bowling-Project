package uk.co.geekcaroline.bowling;

/**
 * Controls the game, prompting for score entries and recording these appropriately
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

    //TODO: consider splitting this method into more easy to read chunks
    public void play(){
        while(frameCounter>0) {
            for(int playerNumber=0; playerNumber<players.length; playerNumber++) {
                Integer frameNumber = 10-frameCounter;
                int pinsCount = 0;
                Player currentPlayer = players[playerNumber];
                for(int attemptNumber=0; attemptNumber<2; attemptNumber++) {
                    pinsCount = clc.getPlayerPins(frameNumber, currentPlayer.name, attemptNumber);
                    currentPlayer.setFrame(frameNumber, pinsCount);
                    //in case of a strike we skip the next go (if we're not on the final frame)
                    if(pinsCount==10 && frameNumber<9){
                        attemptNumber++;
                        currentPlayer.setFrame(frameNumber, 0);
                    }
                    //update previous scores if last ball was a strike or spare
                    if(frameNumber>0) {
                        currentPlayer.updatePreviousScores(frameNumber, pinsCount,  attemptNumber);
                    }
                }
                //special case of in final round and we're getting close to a perfect game...
                if(frameNumber == 9 && pinsCount == 10) {
                    pinsCount = clc.getPlayerPins(frameNumber, currentPlayer.name, 2);
                }
                this.printScoreSheet();
            }
            frameCounter--;
        }
    }

    public void printScoreSheet() {
        clc.printScoreSheet(players);
    }

}
