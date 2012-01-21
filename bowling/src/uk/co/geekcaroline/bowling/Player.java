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
    ArrayList<Frame> frames = new ArrayList<Frame>(10);
    public Player(String name) {
        this.name = name;
    }

    public Frame getFrame(int frameNumber) {
        return frames.get(frameNumber);
    }

    public void setFrame(int frameNumber, Frame frame) {
        frames.set(frameNumber, frame);
    }
}
