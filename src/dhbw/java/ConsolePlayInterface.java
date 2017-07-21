package dhbw.java;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Dennis on 29.06.2017.
 */
public  class ConsolePlayInterface implements IPlayInterface {

    private String getColorOfPlayer(PlayerColor color)
    {
        String returns = "";
        switch (color) {
            case Blue:
                returns = (char)27 + "[34;0m";
                break;
            case Red:
                returns = (char)27 + "[31;0m";
                break;
            case Green:
                returns = (char)27 + "[32;0m";
                break;
            case Yellow:
                returns = (char)27 + "[33;0m";
                break;
        }

        return returns;
    }
    private String getNormalColor()
    {
        return (char)27 + "[0;0m";
    }

    @Override
    public void showDiceValue(int dice) {
        System.out.println("Folgender Wert wurde gewürfelt: "+ dice);
    }

    @Override
    public String enterPlayerName(PlayerColor color) {
        System.out.print("Bitte Name fuer Spieler mit Farbe \""+getColorOfPlayer(color)+color+getNormalColor()+"\" eingeben (Leer wenn spieler nicht aktiv): ");
        Scanner scanner = new Scanner(System.in);
        String test= scanner.nextLine();
        return test;
        //return readString();
    }

    @Override
    public Figure letPlayerChooseWhichFigureShouldMove(List<Figure> figures) {
        System.out.println("Folgende Figuren können bewegt werden:");
        for (Figure figure : figures)
        {
            System.out.println("("+figures.indexOf(figure)+") Figur Nr."+figure.getId());
        }
        System.out.print("Waehle die zu bewegende Figur: ");
        Scanner scanner = new Scanner(System.in);
        int tmp = 0;
        try {
            tmp = scanner.nextInt();
        }
        catch(Exception e)
        {
           return letPlayerChooseWhichFigureShouldMove(figures);
        }
        if(tmp >= figures.size() || tmp <0)
        {
            return letPlayerChooseWhichFigureShouldMove(figures);
        }
        return figures.get(tmp);
    }

    @Override
    public void turnOfPlayer(Player player) {
        System.out.println(getColorOfPlayer(player.getColor())+player.getName() + getNormalColor()+" ist nun am zug!" );
    }

    @Override
    public void printBoard(Board board) {
        System.out.println("\n\n\n");

        //System.out.println("12  ###  21");
        //System.out.println("34  ###  43");
        //System.out.println("    ###    ");
        //System.out.println("    ###    ");
        //System.out.println("###########");
        //System.out.println("##### #####");
        //System.out.println("###########");
        //System.out.println("    ###    ");
        //System.out.println("    ###    ");
        //System.out.println("34  ###  43");
        //System.out.println("12  ###  21");
        print01(board);
        print02(board);
        print03(board);
        print04(board);
        print05(board);
        print06(board);
        print07(board);
        print08(board);
        print09(board);
        print10(board);
        print11(board);


    }

    @Override
    public void playerWon(Board board, Player player) {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("SPIEL BEENDET");
        System.out.println(getColorOfPlayer(player.getColor())+player.getName() + getNormalColor()+" HAT GEWONNENNN!" );
        printBoard(board);
    }

    private void print01(Board board) {
        printStart(2,PlayerColor.Red,board);
        printStart(1,PlayerColor.Red,board);
        System.out.print("  ");
        printField(38,board);
        printField(39,board);
        printField(0,board);
        System.out.print("  ");
        printStart(2,PlayerColor.Blue,board);
        printStart(1,PlayerColor.Blue,board);
        System.out.print("\n");
    }

    private void print02(Board board)
    {
        printStart(3,PlayerColor.Red,board);
        printStart(4,PlayerColor.Red,board);
        System.out.print("  ");
        printField(37,board);
        printTarget(1,PlayerColor.Blue,board);
        printField(1,board);
        System.out.print("  ");
        printStart(4,PlayerColor.Blue,board);
        printStart(3,PlayerColor.Blue,board);
        System.out.print("\n");


    }
    private void print03(Board board)
    {
       System.out.print("    ");
        printField(36,board);
        printTarget(2,PlayerColor.Blue,board);
        printField(2,board);
        System.out.print("\n");
    }

    private void print04(Board board)
    {
        System.out.print("    ");

        printField(35,board);
        printTarget(3,PlayerColor.Blue,board);
        printField(3,board);

        System.out.print("\n");
    }
    private void print05(Board board)
    {
        printField(30,board);
        printField(31,board);
        printField(32,board);
        printField(33,board);
        printField(34,board);
        printTarget(4,PlayerColor.Blue,board);
        printField(4,board);
        printField(5,board);
        printField(6,board);
        printField(7,board);
        printField(8,board);
        System.out.print("\n");
    }
    private void print06(Board board)
    {
        printField(29,board);
        printTarget(1,PlayerColor.Red,board);
        printTarget(2,PlayerColor.Red,board);
        printTarget(3,PlayerColor.Red,board);
        printTarget(4,PlayerColor.Red,board);
        //printField(34,board);
        System.out.print(" ");
        printTarget(4,PlayerColor.Green,board);
        printTarget(3,PlayerColor.Green,board);
        printTarget(2,PlayerColor.Green,board);
        printTarget(1,PlayerColor.Green,board);
        printField(9,board);
        System.out.print("\n");
    }

    private void print07(Board board)
    {
        printField(28,board);
        printField(27,board);
        printField(26,board);
        printField(25,board);
        printField(24,board);
        printTarget(4,PlayerColor.Yellow,board);
        printField(14,board);
        printField(13,board);
        printField(12,board);
        printField(11,board);
        printField(10,board);
        System.out.print("\n");
    }

    private void print08(Board board)
    {
        System.out.print("    ");
        printField(23,board);
        printTarget(3,PlayerColor.Yellow,board);
        printField(15,board);
        System.out.print("\n");
    }

    private void print09(Board board)
    {
        System.out.print("    ");
        printField(22,board);
        printTarget(2,PlayerColor.Yellow,board);
        printField(16,board);
        System.out.print("\n");
    }

    private void print10(Board board)
    {

        printStart(3,PlayerColor.Yellow,board);
        printStart(4,PlayerColor.Yellow,board);
        System.out.print("  ");
        printField(21,board);
        printTarget(1,PlayerColor.Yellow,board);
        printField(17,board);
        System.out.print("  ");
        printStart(4,PlayerColor.Green,board);
        printStart(3,PlayerColor.Green,board);
        System.out.print("\n");
    }

    private void print11(Board board)
    {

        printStart(1,PlayerColor.Yellow,board);
        printStart(2,PlayerColor.Yellow,board);
        System.out.print("  ");
        printField(20,board);
        printField(19,board);
        printField(18,board);
        System.out.print("  ");
        printStart(2,PlayerColor.Green,board);
        printStart(1,PlayerColor.Green,board);
        System.out.print("\n");
    }

    private void printField(int id, Board board)
    {
        if(board.getFigureOfField(id) != null)
        {
            System.out.print(getColorOfPlayer(board.getFigureOfField(id).getColor())+board.getFigureOfField(id).getId()+getNormalColor());
        }
        else
        {
            System.out.print("#");
        }
    }

    private void printStart(int field, PlayerColor color, Board board)
    {
        if(board.getPlayer(color) != null && board.getPlayer(color).figuresAtStart() >= field)
        {
            System.out.print(getColorOfPlayer(color)+"#"+getNormalColor());
        }
        else
        {
            System.out.print("#");
        }
    }

    private void printTarget(int field, PlayerColor color, Board board)
    {
        if(board.getPlayer(color) != null && board.getPlayer(color).isFigureOnTargetPosition(field))
        {
            System.out.print(getColorOfPlayer(color)+"#"+getNormalColor());
        }
        else
        {
            System.out.print("#");
        }
    }



}
