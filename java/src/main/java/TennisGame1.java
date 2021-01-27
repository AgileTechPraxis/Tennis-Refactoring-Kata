public class TennisGame1 implements TennisGame {

    private int pointsPlayerOne = 0;
    private int pointsPlayerTwo = 0;

    public TennisGame1() {
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            pointsPlayerOne += 1;
        else
            pointsPlayerTwo += 1;
    }

    public String getScore() {
        String score = "";
        int tempScore = 0;
        if (playersHaveSamePoints()) {
            return scoreForTie();
        }
        if (onePlayerHasMoreThan3Points()) {
            return scoreForAdvantageOrWin();
        }

        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = pointsPlayerOne;
            else {
                score += "-";
                tempScore = pointsPlayerTwo;
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

        return score;
    }

    private String scoreForAdvantageOrWin() {
        String score;
        int minusResult = pointsPlayerOne - pointsPlayerTwo;
        if (minusResult == 1) {
            score = "Advantage player1";
        } else if (minusResult == -1) {
            score = "Advantage player2";
        } else if (minusResult >= 2) {
            score = "Win for player1";
        } else {
            score = "Win for player2";
        }
        return score;
    }

    private boolean onePlayerHasMoreThan3Points() {
        return pointsPlayerOne >= 4 || pointsPlayerTwo >= 4;
    }

    private String scoreForTie() {
        String score;
        switch (pointsPlayerOne) {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            default:
                score = "Deuce";
                break;
        }
        return score;
    }

    private boolean playersHaveSamePoints() {
        return pointsPlayerOne == pointsPlayerTwo;
    }
}