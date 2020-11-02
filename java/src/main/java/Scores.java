class Scores {
    private final static String[] SCORES = {"Love", "Fifteen", "Thirty", "Forty"};

    public static String getRegularScore(int pointsPlayer1, int pointsPlayer2) {
        return SCORES[pointsPlayer1] + "-" + SCORES[pointsPlayer2];
    }

    public static String getEqualScore(int points) {
        if (points < 3) {
            return SCORES[points] + "-All";
        }
        return "Deuce";
    }

    public static String getAdvantageOrWinScore(int pointsDifference) {
        if (pointsDifference == 1) {
            return "Advantage player1";
        }
        if (pointsDifference == -1) {
            return "Advantage player2";
        }
        if (pointsDifference >= 2) {
            return "Win for player1";
        }
        return "Win for player2";
    }

    public static String getScore(int pointsPlayer1, int pointsPlayer2) {
        if (playersHaveSamePoints(pointsPlayer1, pointsPlayer2)) {
            return Scores.getEqualScore(pointsPlayer1);
        }
        if (anyPlayerHasAtLeastFourPoints(pointsPlayer1, pointsPlayer2)) {
            return Scores.getAdvantageOrWinScore(pointsPlayer1 - pointsPlayer2);
        }
        return Scores.getRegularScore(pointsPlayer1, pointsPlayer2);
    }

    private static boolean anyPlayerHasAtLeastFourPoints(int pointsPlayer1, int pointsPlayer2) {
        return pointsPlayer1 >= 4 || pointsPlayer2 >= 4;
    }

    private static boolean playersHaveSamePoints(int pointsPlayer1, int pointsPlayer2) {
        return pointsPlayer1 == pointsPlayer2;
    }
}
