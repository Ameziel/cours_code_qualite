package tennis;

import java.util.Locale;

public class JeuxTennis {

    private int player1Score = 0;
    private int player2Score = 0;
    private final String player1Name;
    private final String player2Name;
    private final TextesScore messages;

    public JeuxTennis(String player1Name, String player2Name, Locale locale) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.messages = new TextesScore(locale);
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name)) {
            player1Score += 1;
        } else if (playerName.equals(player2Name)) {
            player2Score += 1;
        } else {
            throw new IllegalArgumentException(messages.getString("invalid_player") + playerName);
        }
    }

    public String getScore() {
        if (player1Score == player2Score) {
            return getEvenScore(player1Score);
        } else if (player1Score >= 4 || player2Score >= 4) {
            return getWinningScore();
        } else {
            return getRunningScore();
        }
    }

    private String getEvenScore(int score) {
        switch (score) {
            case 0:
                return messages.getString("love_all");
            case 1:
                return messages.getString("fifteen_all");
            case 2:
                return messages.getString("thirty_all");
            case 3:
                return messages.getString("forty_all");
            default:
                return messages.getString("deuce");
        }
    }

    private String getWinningScore() {
        int scoreDifference = player1Score - player2Score;
        if (scoreDifference == 1) {
            return messages.getString("advantage") + " " + player1Name;
        } else if (scoreDifference == -1) {
            return messages.getString("advantage") + " " + player2Name;
        } else if (scoreDifference >= 2) {
            return messages.getString("win_for") + " " + player1Name;
        } else {
            return messages.getString("win_for") + " " + player2Name;
        }
    }

    private String getRunningScore() {
        return getScoreDescription(player1Score) + "-" + getScoreDescription(player2Score);
    }

    private String getScoreDescription(int score) {
        switch (score) {
            case 0:
                return messages.getString("love");
            case 1:
                return messages.getString("fifteen");
            case 2:
                return messages.getString("thirty");
            case 3:
                return messages.getString("forty");
            default:
                throw new IllegalArgumentException(messages.getString("invalid_score") + score);
        }
    }
}
