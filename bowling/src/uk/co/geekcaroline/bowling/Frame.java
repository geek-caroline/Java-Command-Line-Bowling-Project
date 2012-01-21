package uk.co.geekcaroline.bowling;

/**
 * Created by IntelliJ IDEA.
 * User: CJ
 * Date: 21/01/12
 * Time: 18:53
 * To change this template use File | Settings | File Templates.
 */
public class Frame {
    Score score1;
    Score score2;
    public Frame(){}
    public void setScore(int pinCount, int attemptNumber) {

    }
    public Score getScore(int attemptNumber){
        if(attemptNumber == 1) {
            return score1;
        } else {
            return score2;
        }
    }

}