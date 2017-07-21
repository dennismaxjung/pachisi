package dhbw.java;

import dhbw.java.Players.BluePlayer;
import dhbw.java.Players.GreenPlayer;
import dhbw.java.Players.RedPlayer;
import dhbw.java.Players.YellowPlayer;

/**
 * Created by Dennis on 30.06.2017.
 */
public class PlayerHelper {

    public static Player createPlayer(String name, PlayerColor color)
    {
        switch (color) {
            case Blue:
                return new BluePlayer(name);
            case Red:
                return new RedPlayer(name);
            case Green:
                return new GreenPlayer(name);
            case Yellow:
                return new YellowPlayer(name);
            default:
                return null;
        }
    }
}
