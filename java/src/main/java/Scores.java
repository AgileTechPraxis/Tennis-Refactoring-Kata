class Scores {
    private final static String[] SCORES = {"Love", "Fifteen", "Thirty", "Forty"};

    public static String getRegularScore(int pointsPlayer1, int pointsPlayer2) {
        return SCORES[pointsPlayer1] + "-" + SCORES[pointsPlayer2];
    }

    public static String getEqualScore(int pointsPlayer1) {
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
