import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testBowling {

	 private BowlingGame game;
	    private static final int MAX_ATTEMPTS = 20;

	    @Before
	    public void setUp() {
	        game = MatchFactory.createMatch();
	    }


	    @Test
	    public void testScoreNoSpareOrStrike() {

	        game.roll(4);
	        game.roll(4);

	        int score  = game.score();
	        Assert.assertEquals(8, score);

	    }

	    @Test
	    public void testSpare() {

	        game.roll(4);
	        game.roll(6);

	        int score  = game.score();
	        Assert.assertEquals(10, score);

	        game.roll(5);
	        game.roll(0);

	        score  = game.score();
	        Assert.assertEquals(20, score);

	    }


	    @Test
	    public void testStrikeOnSecondAttempt() {

	        game.roll(0);
	        game.roll(10);

	        int score  = game.score();
	        Assert.assertEquals(10, score);


	        game.roll(5);
	        game.roll(4);

	        score  = game.score();
	        Assert.assertEquals(28, score);

	    }


	    @Test
	    public void testStrikeOnFirstAttempt() {

	        game.roll(10);
	        game.roll(0);

	        int score  = game.score();
	        Assert.assertEquals(10, score);


	        game.roll(5);
	        game.roll(5);

	        score  = game.score();
	        Assert.assertEquals(30, score);

	    }


	    @Test
	    public void testStrikeEveryRoll() {

	        for (int i = 0; i < 10 ; i++) {

	            game.roll(10);
	            game.roll(0);
	        }

	        int score = game.score();
	        Assert.assertEquals(300, score);

	    }


	    @Test
	    public void testLastFrameSpare() {

	        for (int i = 0; i < 10 ; i++) {

	            game.roll(5);
	            game.roll(5);
	        }

	        game.roll(5);

	        int score = game.score();
	        Assert.assertEquals(15, score);
	    }

	    @Test
	    public void testLastFrameStrike() {

	        for (int i = 0; i < 10 ; i++) {

	            game.roll(10);
	            game.roll(0);
	        }

	        game.roll(3);
	        game.roll(4);

	        int score = game.score();
	        Assert.assertEquals(17, score);
	    }


	    @Test(expected = BowlingGameScoreBoard.BowlingException.class)
	    public void testLastFrameNoStrike() {

	        for (int i = 0; i < 10 ; i++) {

	            game.roll(3);
	            game.roll(5);
	        }
	        // this wont happen as last frame wasnt strike/spare
	        game.roll(3);
	        game.roll(4);

	    }

	    /**
	     * Exception is generated if try and go beyond 10 frames / match
	     */
	    @Test(expected = BowlingGameScoreBoard.BowlingException.class)
	    public void testPlayMoreThanAllFrames() {

	        for (int i = 0; i <= MAX_ATTEMPTS  ; i++) {
	            game.roll(i/10);
	        }
	    }


	    /**
	     * This tests an illegal argument , ie cant pass more than 10 pins to
	     * knock down
	     *
	     * I'am using custom exception here instead of Java's {@link java.lang.IllegalArgumentException}
	     */
	    @Test(expected = BowlingGameScoreBoard.BowlingException.class)
	    public void testIllegalBowlException() {

	            game.roll(200);

	    }

}
