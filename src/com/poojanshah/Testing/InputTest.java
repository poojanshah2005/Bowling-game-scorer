package com.poojanshah.Testing;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import input.StringPassing;

public class InputTest {
	
	@Test
    public void fullScore() {

        StringPassing passing = new StringPassing("X|X|X|X|X|X|X|X|X|X|XX");
        Assert.assertEquals(300, passing.score);

    }
	
	@Test
    public void oneScore() {

        StringPassing passing = new StringPassing("9-|9-|9-|9-|9-|9-|9-|9-|9-|9-||9");
        Assert.assertEquals(90, passing.score);

    }
	
	@Test
    public void twoScore() {

        StringPassing passing = new StringPassing("5/|5/|5/|5/|5/|5/|5/|5/|5/|5/||5");
        Assert.assertEquals(300, passing.score);

    }
	
	@Test
    public void threeScore() {

        StringPassing passing = new StringPassing("X|7/|9-|X|-8|8/|-6|X|X|X||81");
        Assert.assertEquals(167, passing.score);

    }
	
	

}
