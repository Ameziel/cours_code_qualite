package tennis;

import java.util.Locale;

public class Tennis {

    public static void main(String[] args) {
        Locale locale = new Locale("fr", "FR"); // Change to "es", "ES" for Spanish or "en", "US" for English
        JeuxTennis game = new JeuxTennis("player1", "player2", locale);

        game.wonPoint("player1");
        game.wonPoint("player2");
        game.wonPoint("player1");
        System.out.println(game.getScore());
        game.wonPoint("player1");
        game.wonPoint("player1");
        System.out.println(game.getScore());
        game.wonPoint("player1");
        System.out.println(game.getScore());
    }
}
