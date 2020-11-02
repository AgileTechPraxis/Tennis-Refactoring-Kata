public class TennisGame3 implements TennisGame {

    private static final String[] SCORES = new String[]{"Love", "Fifteen", "Thirty", "Forty"};

    private final String player1Name;
    private final String player2Name;

    private int player1Points;
    private int player2Points;

    public TennisGame3(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        if (scoreIsBelowDeuce()) {
            return (player1Points == player2Points)
                    ? SCORES[player1Points] + "-All"
                    : SCORES[player1Points] + "-" + SCORES[player2Points];
        }
        if (player1Points == player2Points) {
            return "Deuce";
        }
        final String playerName = player1Points > player2Points ? player1Name : player2Name;
        return ((player1Points - player2Points) * (player1Points - player2Points) == 1) ? "Advantage " + playerName : "Win for " + playerName;
    }

    private boolean scoreIsBelowDeuce() {
        return player1Points < 4 && player2Points < 4 && !(player1Points + player2Points == 6);
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1")) {
            this.player1Points += 1;
            return;
        }
        this.player2Points += 1;
    }

}