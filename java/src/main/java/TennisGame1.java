public class TennisGame1 implements TennisGame {

    private final String player1Name;
    private final String player2Name;

    private int pointsPlayer1 = 0;
    private int pointsPlayer2 = 0;

    private final static String[] SCORES = {"Love", "Fifteen", "Thirty", "Forty"};

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name)) {
            pointsPlayer1 += 1;
        }
        if (playerName.equals(player2Name)) {
            pointsPlayer2 += 1;
        }
    }

    public String getScore() {
        if (pointsPlayer1 == pointsPlayer2) {
            return getEqualScore();
        }
        if (pointsPlayer1 >= 4 || pointsPlayer2 >= 4) {
            return getAdvantageOrWinScore();
        }
        return getRegularScore();
    }

    private String getRegularScore() {
        return lookupScore(pointsPlayer1) + "-" + lookupScore(pointsPlayer2);
    }

    private String lookupScore(int points) {
        return SCORES[points];
    }

    private String getAdvantageOrWinScore() {
        int minusResult = pointsPlayer1 - pointsPlayer2;
        if (minusResult == 1) {
            return "Advantage player1";
        }
        if (minusResult == -1) {
            return "Advantage player2";
        }
        if (minusResult >= 2) {
            return "Win for player1";
        }
        return "Win for player2";
    }

    private String getEqualScore() {
        switch (pointsPlayer1) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            default:
                return "Deuce";
        }
    }
}