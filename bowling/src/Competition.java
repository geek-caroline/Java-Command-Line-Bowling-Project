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
    int rounds;
    ArrayList<Frame> frames = new ArrayList<Frame>(10);
    public Competition(int playersCount){
        players = new Player[]{};
    }
    public void setPlayerNames(String[] playerNames) {

    }
}
