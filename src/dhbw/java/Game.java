package dhbw.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dennis on 30.06.2017.
 */
public class Game{

    private Board board;

    public void StartNewGame()
    {
        List<Player> newPlayers = new ArrayList<Player>();
        boolean allPlayerEntered = false;

        PlayerColor[] test = PlayerColor.values();
        int i = 0;

        while(newPlayers.size() < 4 && !allPlayerEntered)
        {
            String enteredName = Main.playerInterfac.enterPlayerName(test[i]);

            if(enteredName.isEmpty())
            {
                allPlayerEntered = true;
            }
            else{
                newPlayers.add(PlayerHelper.createPlayer(enteredName,test[i]));

            }
            i++;
        }

        board = new Board(newPlayers);
        StartGame();
    }

    private void StartGame()
    {
        //TODO: WHILE nobody has won
        int currentplayer = 0;
        int players = board.getPlayerCount();
        boolean play = true;
        while(play)
        {
            if(currentplayer >= players)
            {
                currentplayer = 0;
            }
            int targetcount = 0;
            for (int i = 1; i <= 4; i++)
            {
                if(board.getPlayer(PlayerColor.values()[currentplayer]).isFigureOnTargetPosition(i))
                {
                    targetcount++;
                }
            }
            if(targetcount >= 4)
            {
                Main.playerInterfac.playerWon(board,board.getPlayer(PlayerColor.values()[currentplayer]));
                play = false;
                return;
            }
            new Turn(board,PlayerColor.values()[currentplayer]);
            currentplayer++;

        }
    }
}
