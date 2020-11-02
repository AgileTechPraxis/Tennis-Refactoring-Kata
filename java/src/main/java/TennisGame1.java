public class TennisGame1 implements TennisGame {

    private final String player1Name;
    private final String player2Name;

    private int pointsPlayer1 = 0;
    private int pointsPlayer2 = 0;

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
        if (playersHaveSamePoints()) {
            return Scores.getEqualScore(pointsPlayer1);
        }
        if (anyPlayerHasAtLeastFourPoints()) {
            return Scores.getAdvantageOrWinScore(pointsPlayer1 - pointsPlayer2);
        }
        return Scores.getRegularScore(pointsPlayer1, pointsPlayer2);
    }

    private boolean anyPlayerHasAtLeastFourPoints() {
        return pointsPlayer1 >= 4 || pointsPlayer2 >= 4;
    }

    private boolean playersHaveSamePoints() {
        return pointsPlayer1 == pointsPlayer2;
    }
}