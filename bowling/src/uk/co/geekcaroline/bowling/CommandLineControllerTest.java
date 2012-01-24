package uk.co.geekcaroline.bowling;

import junit.framework.TestCase;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.StringReader;

/**
* Created by IntelliJ IDEA.
* User: handleyc
* Date: 23/01/2012
* Time: 19:20
* To change this template use File | Settings | File Templates.
*/
public class CommandLineControllerTest extends TestCase {
    @Test
    public void testGetPlayerCount() throws Exception {
        String input = "3";
        BufferedReader reader = new BufferedReader(new StringReader(input));
        InputDevice fakeInput = new InputDevice(reader, new PrintWriter(System.out, true));
        CommandLineController commandLineController = new CommandLineController(fakeInput);
        int playerCount = commandLineController.getPlayerCount();
        assertEquals(playerCount,2);
    }
//
//    @Test
//    public void testGetPlayerNames() throws Exception {
//
//    }
//
//    @Test
//    public void testGetPlayerPins() throws Exception {
//
//    }
//
//    @Test
//    public void testPrintScoreSheet() throws Exception {
//
//    }
}
