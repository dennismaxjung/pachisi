package dhbw.java;

import dhbw.java.Players.GreenPlayer;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static IPlayInterface playerInterfac = new ConsolePlayInterface();

    public static void main(String[] args) {
        // write your code here

        Game game = new Game();
        game.StartNewGame();


    }
}