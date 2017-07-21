package dhbw.java;

import java.util.List;

/**
 * Created by Dennis on 29.06.2017.
 */
public class Turn {
    public Turn(Board board, PlayerColor currentPlayerColor)
    {

        this.board = board;
        this.currentPlayer = board.getPlayer(currentPlayerColor);
        countDice = 1;
        throwDiceAgain = true;
        Main.playerInterfac.turnOfPlayer(currentPlayer);

        while(countDice <= 3 && throwDiceAgain)
        {
            throwDiceAgain = false;
            Main.playerInterfac.printBoard(board);
            checkMoves(currentPlayer.roleTheDice());
        }

    }

    private int countDice = 0;

    private boolean throwDiceAgain = false;

    private Player currentPlayer;

    private Board board;

    private void checkMoves(int dice)
    {
        if (dice == 6)
        {
            throwDiceAgain = true;
        }

        // Wenn Noch figuren zuhause sind und das startFeld leer ist
        if (dice == 6 && !currentPlayer.isStartEmpty() && (board.isFieldEmpty(currentPlayer.getStartNr()) || board.isFieldOtherPlayer(currentPlayer.getStartNr(),currentPlayer.getColor()))) {
            // Nehme neue figur aus dem Zuhause und setze es auf start
            board.setFigureToField(currentPlayer.getStartNr(), currentPlayer.takeFigureFromStart());
        }
        // Wenn noch figuren zuhause sind und der start noch blockiert ist von einer eigenen figur
        else if(/*dice == 6 && */!currentPlayer.isStartEmpty() && !board.isFieldEmpty(currentPlayer.getStartNr()) && !board.isFieldOtherPlayer(currentPlayer.getStartNr(),currentPlayer.getColor()))
        {
            int nextPosition = currentPlayer.getStartNr()+dice;
            if(board.isFieldEmpty(nextPosition) || board.isFieldOtherPlayer(nextPosition,currentPlayer.getColor()))
            {
                board.setFigureToField(nextPosition,board.getFigureOfField(currentPlayer.getStartNr()));
            }
            else
            {
                letPlayerChoose(dice);
            }


            // Bewege figur von start weg, wenn diese jeoch eine eigene schlagen würde, dann bewege diese (rekursiv)
            // oder zwinge bewegung nur wenn nicht dieses ziel wieder von einer anderen blockiert wird

        }
        // Wenn keine spieler auf dem feld ist und nicht sowieso schon nochmal würfeln darf, darf er nochmal würfeln
        else if(board.playerHasNoFiguresOnFields(currentPlayer.getColor()) && throwDiceAgain == false)
        {
            throwDiceAgain = true;
            countDice ++;
        }
        // Wenn ein schlage vorgang erzwungen werden muss
        else if(board.playerHasToBeat(dice,currentPlayer.getColor()).size() > 0) {
            List<Figure> beatMoveFigures = board.playerHasToBeat(dice, currentPlayer.getColor());
            // überprüfe ob es nur eins ist
            if (beatMoveFigures.size() == 1) {
                Figure fig = beatMoveFigures.get(0);
                board.setFigureToField(board.getFieldOfFigure(fig) + dice, fig);
            } else {
                Figure fig = Main.playerInterfac.letPlayerChooseWhichFigureShouldMove(beatMoveFigures);
                board.setFigureToField(board.getFieldOfFigure(fig)+dice,fig);

            }
        }
        else
        {
          letPlayerChoose(dice);
        }

    }
    private void letPlayerChoose(int dice)
    {
        List<Figure> movableFigures = board.getMovableFigures(dice,currentPlayer.getColor());

        if(movableFigures.size() != 0) {

            Figure figureToMove = Main.playerInterfac.letPlayerChooseWhichFigureShouldMove(movableFigures);

            board.setFigureToField(board.getFieldOfFigure(figureToMove) + dice, figureToMove);
        }
    }
}
