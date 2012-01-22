package uk.co.geekcaroline.bowling;

/**
 * Records the score for this frame
 */
public class Frame {
    int score1;
    int score2;
    int score3; // in case of extra ball in final frame
    boolean isAstrike;
    boolean isAspare;
    public Frame(int pinCount){
        score1 = pinCount;
        if(score1 == 10) {
            this.isAstrike = true;
        }
        score3 = 0;
    }
    public void setSecondScore(int pinCount) {
        score2 = pinCount;
        if(score1 + score2 == 10) {
            this.isAspare = true;
        }
    }
    public void updateScoresForStrike(int pinCount, int attemptNumber) {
        if(attemptNumber==1 && pinCount == 10) {
            //to compensate for the fact that a strike will only allow one ball in the next round
            score1 = score1+pinCount*2;
        }else if(attemptNumber==1) {
            score1 = score1+pinCount;
        } else {
            score2 = score2+pinCount;
        }
    }
    public void updateScoresForSpare(int pinCount) {
        score1 = score1+pinCount;
    }
    public int getScore(int attemptNumber){
        if(attemptNumber == 1) {
            return score1;
        } else {
            return score2;
        }
    }

    public boolean isAstrike(){
        return isAstrike;
    }

    public boolean isAspare(){
        return isAspare;
    }
    public void printScoreSheet() {
        if(isAstrike) {
            System.out.print("|   x   |");
        } else {
            System.out.print(String.format("%3s", "|  "+this.getScore(1)));
            System.out.print("|");
            if(isAspare()) {
                System.out.print("/  |");
            }  else {
                System.out.print(String.format("%-2s", this.getScore(2)+"  |"));
            }
        }
        if(score3 != 0) {
            if(score3 == 10) {
                System.out.print("|  x  |");
            } else {
                System.out.print(String.format("%-2s", score3+" |"));
            }
        }
    }

}