import java.util.HashMap;
import java.util.Map;

public class TennisGame1 implements TennisGame {

    private static final String LOVE_ALL = "Love-All";
    private static final String FIFTEEN_ALL = "Fifteen-All";
    private static final String THIRTY_ALL = "Thirty-All";
    private static final String DEUCE = "Deuce";

    private static final String ADVANTAGE_PLAYER_1 = "Advantage player1";
    private static final String ADVANTAGE_PLAYER_2 = "Advantage player2";

    private static final String WIN_FOR_PLAYER_1 = "Win for player1";
    private static final String WIN_FOR_PLAYER_2 = "Win for player2";

    private static final Map<Integer, String> POINT_TO_SCORE_FOR_TIE = new HashMap<>() {{
        put(0, LOVE_ALL);
        put(1, FIFTEEN_ALL);
        put(2, THIRTY_ALL);
    }};

    public static final String LOVE = "Love";
    public static final String FIFTEEN = "Fifteen";
    public static final String THIRTY = "Thirty";
    public static final String FORTY = "Forty";
    private static final Map<Integer, String> POINT_TO_SCORE_FOR_IN_PROGRESS = new HashMap<>() {{
        put(0, LOVE);
        put(1, FIFTEEN);
        put(2, THIRTY);
        put(3, FORTY);
    }};

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
        if (playersHaveSamePoints()) {
            return scoreForTie();
        }
        if (bothPlayersHaveLessThan4Points()) {
            return inProgressScore();
        }
        if (isAdvantage()) {
            return scoreForAdvantage();
        }
        return scoreForWin();
    }

    private boolean bothPlayersHaveLessThan4Points() {
        return pointsPlayerOne < 4 && pointsPlayerTwo < 4;
    }

    private boolean isAdvantage() {
        return Math.abs(pointsPlayerOne - pointsPlayerTwo) == 1;
    }

    private boolean playersHaveSamePoints() {
        return pointsPlayerOne == pointsPlayerTwo;
    }

    private String scoreForTie() {
        return POINT_TO_SCORE_FOR_TIE.getOrDefault(pointsPlayerOne, DEUCE);
    }

    private String scoreForAdvantage() {
        if (pointsPlayerOne > pointsPlayerTwo) {
            return ADVANTAGE_PLAYER_1;
        }
        return ADVANTAGE_PLAYER_2;
    }

    private String scoreForWin() {
        if (pointsPlayerOne > pointsPlayerTwo) {
            return WIN_FOR_PLAYER_1;
        }
        return WIN_FOR_PLAYER_2;
    }

    private String inProgressScore() {
        return POINT_TO_SCORE_FOR_IN_PROGRESS.get(pointsPlayerOne) + "-" + POINT_TO_SCORE_FOR_IN_PROGRESS.get(pointsPlayerTwo);
    }
}