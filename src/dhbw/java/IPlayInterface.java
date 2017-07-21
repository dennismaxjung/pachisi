package dhbw.java;

import java.util.List;

/**
 * Created by Dennis on 29.06.2017.
 */
public interface IPlayInterface {

    public void showDiceValue(int dice);

    public String enterPlayerName(PlayerColor color);

    public Figure letPlayerChooseWhichFigureShouldMove(List<Figure> figures);

    void turnOfPlayer(Player player);

    void printBoard(Board board);

    void playerWon(Board board, Player player);
}
