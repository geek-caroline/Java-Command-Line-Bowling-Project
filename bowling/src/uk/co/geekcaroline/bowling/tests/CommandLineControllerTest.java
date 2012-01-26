package uk.co.geekcaroline.bowling.tests;

import org.junit.Test;
import uk.co.geekcaroline.bowling.CommandLineController;
import uk.co.geekcaroline.bowling.InputDevice;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
* Created by IntelliJ IDEA.
* User: handleyc
* Date: 23/01/2012
* Time: 19:20
* To change this template use File | Settings | File Templates.
*/
public class CommandLineControllerTest{
    PrintWriter pw = new PrintWriter(System.out, true);

    @Test
    public void testGetPlayerCountUsingTooHigh() throws Exception {
        String input = "5";
        BufferedReader reader = new BufferedReader(new StringReader(input));
        InputDevice fakeInput = new InputDevice(reader, pw);
        CommandLineController commandLineController = new CommandLineController(fakeInput);
        try {
            int playerCount = commandLineController.getPlayerCount();
            assertEquals(playerCount, Integer.parseInt(input));
            fail("Should have thrown an exception here");
        } catch (NullPointerException n) {
            //test successfull
        }
    }

    @Test
    public void testGetPlayerCountUsingTooLow() throws Exception {
        String input = "0";
        BufferedReader reader = new BufferedReader(new StringReader(input));
        InputDevice fakeInput = new InputDevice(reader, pw);
        CommandLineController commandLineController = new CommandLineController(fakeInput);
        try {
            int playerCount = commandLineController.getPlayerCount();
            assertEquals(playerCount, Integer.parseInt(input));
            fail("Should have thrown an exception here");
        } catch (NullPointerException n) {
            //test successfull
        }
    }

    @Test
    public void testGetPlayerCountUsingValidValue() throws Exception {
        String input = "2";
        BufferedReader reader = new BufferedReader(new StringReader(input));
        InputDevice fakeInput = new InputDevice(reader, new PrintWriter(System.out, true));
        CommandLineController commandLineController = new CommandLineController(fakeInput);
        int playerCount = commandLineController.getPlayerCount();
        assertEquals(playerCount,Integer.parseInt(input));
    }

    @Test
    public void testGetPlayerNameWithNameTooShort() throws Exception {
        String input = "";
        BufferedReader reader = new BufferedReader(new StringReader(input));
        InputDevice fakeInput = new InputDevice(reader, pw);
        CommandLineController commandLineController = new CommandLineController(fakeInput);
        try {
            String[] playerNames = commandLineController.getPlayerNames(1);
            assertEquals(playerNames[0], input);
            fail("Should have thrown an exception here");
        } catch (NullPointerException n) {
            //test successfull
        }
    }

    @Test
    public void testGetPlayerNameWithNameTooLong() throws Exception {
        String input = "012345678910";
        BufferedReader reader = new BufferedReader(new StringReader(input));
        InputDevice fakeInput = new InputDevice(reader, pw);
        CommandLineController commandLineController = new CommandLineController(fakeInput);
        try {
            String[] playerNames = commandLineController.getPlayerNames(1);
            assertEquals(playerNames[0], input);
            fail("Should have thrown an exception here");
        } catch (NullPointerException n) {
            //test successfull
        }
    }

    @Test
    public void testGetPlayerNameWithName() throws Exception {
        String input = "012345678910";
        BufferedReader reader = new BufferedReader(new StringReader(input));
        InputDevice fakeInput = new InputDevice(reader, pw);
        CommandLineController commandLineController = new CommandLineController(fakeInput);
        try {
            String[] playerNames = commandLineController.getPlayerNames(1);
            assertEquals(playerNames.length, 1);
            assertEquals(playerNames[0], input);
            fail("Should have thrown an exception here");
        } catch (NullPointerException n) {
            //test successfull
        }
    }

    //TODO: Fix file path so it's relative, then figure out how to make test use file data line by line
//    @Test
//    public void testGetPlayerNameCreatesCorrectLengthArr() throws Exception {
//        String filename = "/Users/handleyc/personalsrc/bowling/src/uk/co/geekcaroline/bowling/tests/dataForNameArrayTest.txt";
//        FileInputStream fileInputStream = new FileInputStream(filename);
//        //need to find a way of overriding the .read method each time
//        BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));
//        InputDevice fakeInput = new InputDevice(reader, pw);
//        CommandLineController commandLineController = new CommandLineController(fakeInput);
//        String[] playerNames = commandLineController.getPlayerNames(4);
//        assertEquals(playerNames.length, 4);
//        assertEquals(playerNames[0], "nameOne");
//    }

//    @Test
//    public void testGetPlayerPinsTooFewFirstRoundFirstGo() throws Exception {
//        String input = "0";
//        BufferedReader reader = new BufferedReader(new StringReader(input));
//        InputDevice fakeInput = new InputDevice(reader, pw);
//        CommandLineController commandLineController = new CommandLineController(fakeInput);
//        try {
//            int playerCount = commandLineController.getPlayerPins(0, "fakeName", 0);
//            assertEquals(playerCount, Integer.parseInt(input));
//            fail("Should have thrown an exception here");
//        } catch (NullPointerException n) {
//            //test successfull
//        }
//    }
//
//        @Test
//    public void testGetPlayerPinsTooManyFirstRoundFirstGo() throws Exception {
//        String input = "11";
//        BufferedReader reader = new BufferedReader(new StringReader(input));
//        InputDevice fakeInput = new InputDevice(reader, pw);
//        CommandLineController commandLineController = new CommandLineController(fakeInput);
//        try {
//            int playerCount = commandLineController.getPlayerPins(0, "fakeName", 0);
//            assertEquals(playerCount, Integer.parseInt(input));
//            fail("Should have thrown an exception here");
//        } catch (NullPointerException n) {
//            //test successfull
//        }
//    }

//    public void testIsValidPinCount() throws Exception {
//        int testNumber = 1;
//        BufferedReader reader = new BufferedReader(new StringReader(""));
//        InputDevice fakeInput = new InputDevice(reader, pw);
//        CommandLineController commandLineController = new CommandLineController(fakeInput);
//        try {
//            int validatedNumber = commandLineController.isValidPinCount(testNumber);
//            assertEquals(validatedNumber, testNumber);
//            fail("Should have thrown an exception here");
//        } catch (NullPointerException n) {
//            //test successfull
//        }
//    }
//
//    @Test
//    public void testPrintScoreSheet() throws Exception {
//
//    }
}
