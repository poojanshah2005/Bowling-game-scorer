public final class MatchFactory {

    private MatchFactory(){};

    public static BowlingGame createMatch() {
        return new BowlingGameScoreBoard();
    }

}