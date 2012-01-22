package uk.co.geekcaroline.bowling;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: handleyc
 * Date: 20/01/2012
 * Time: 08:30
 * To change this template use File | Settings | File Templates.
 */
public class Player {
    String name;
    ArrayList<Frame> frames;
    public Player(String name) {
        this.name = name;
        frames = new ArrayList<Frame>(10);
    }
    
    public Frame getFrame(int frameNumber) {
        if(frames.size()>=frameNumber) {
            return frames.get(frameNumber);
        } else {
            return null;
        }
    }

    public void setFrame(int frameNumber, int pinCount) {
        Frame f;
        if(frames.size()<=frameNumber) {
            f = new Frame(pinCount);
            frames.add(f);
        } else {
            f = frames.get(frameNumber);
            f.setSecondScore(pinCount);
            frames.set(frameNumber, f);
        }
    }

    public int getTotal() {
        int total = 0;
        for(int i=0; i<frames.size(); i++) {
            total += frames.get(i).getScore(1);
            total += frames.get(i).getScore(2);
        }
        return total;
    }

    public void updatePreviousScores(int frameNumber, int pinsCount,  int attemptNumber){
        if(this.getFrame(frameNumber-1).isAstrike()) {
            this.getFrame(frameNumber-1).updateScoresForStrike(pinsCount, attemptNumber);
        } else if(attemptNumber == 1 && this.getFrame(frameNumber-1).isAspare()) {
            this.getFrame(frameNumber-1).updateScoresForSpare(pinsCount);
        }
    }

    public void printScoreSheet() {
        String outString = String.format("%15s", this.name);
        System.out.print("For player " + outString);
        for(int i=0; i<frames.size(); i++) {
            frames.get(i).printScoreSheet();
        }
        for(int i=10; i>frames.size(); i--) {
            System.out.print("|       |");
        }
        System.out.println(" total:"+this.getTotal());
    }
}
