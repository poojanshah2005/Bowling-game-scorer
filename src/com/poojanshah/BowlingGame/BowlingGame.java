package com.poojanshah.BowlingGame;
public interface BowlingGame {

    /**
     * Keeps track of pins knocked over
     * @param noOfPins knocked over per frame
     * @exception {@link BowlingException}
     */
    public void roll(int noOfPins);

    /**
     *
     * @return score of current frame only
     */
    public int score();
}