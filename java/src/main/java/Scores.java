public class Scores {
    private final static String[] SCORES = {"Love", "Fifteen", "Thirty", "Forty"};

    public static String getRegularScore(int pointsPlayer1, int pointsPlayer2) {
        return SCORES[pointsPlayer1] + "-" + SCORES[pointsPlayer2];
    }

}
