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
        String score = "";
        int tempScore = 0;
        if (pointsPlayer1 == pointsPlayer2) {
            return getEqualScore();

        } else if (pointsPlayer1 >= 4 || pointsPlayer2 >= 4) {
            int minusResult = pointsPlayer1 - pointsPlayer2;
            if (minusResult == 1) score = "Advantage player1";
            else if (minusResult == -1) score = "Advantage player2";
            else if (minusResult >= 2) score = "Win for player1";
            else score = "Win for player2";
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1) tempScore = pointsPlayer1;
                else {
                    score += "-";
                    tempScore = pointsPlayer2;
                }
                switch (tempScore) {
                    case 0:
                        score += "Love";
                        break;
                    case 1:
                        score += "Fifteen";
                        break;
                    case 2:
                        score += "Thirty";
                        break;
                    case 3:
                        score += "Forty";
                        break;
                }
            }
        }
        return score;
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