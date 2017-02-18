package Omens;

import static org.junit.Assert.*;

import org.junit.Test;

import Common.*;
import Common.FactoryProducer;

public class TestOmens {

	@Test
	public void testStartingHand() {
		OmensGame game = new OmensGame();
		
		assertEquals(4, game.gethandlength());
		assertEquals("Coin", game.gethandcard(0).getName());
		assertEquals("Coin", game.gethandcard(1).getName());
		assertEquals("Coin", game.gethandcard(2).getName());
		assertEquals("Coin", game.gethandcard(3).getName());
		
		game.gethandcard(0).onplay();
		assertEquals(3, game.gethandlength());
		assertEquals(1, game.getGoldAmount());
		
		assertEquals("Coin", game.gethandcard(0).getName());
		assertEquals("Coin", game.gethandcard(1).getName());
		assertEquals("Coin", game.gethandcard(2).getName());
		assertEquals("No card", game.gethandcard(3).getName());
		
		game.gethandcard(0).onplay();
		assertEquals(2, game.gethandlength());
		assertEquals(2, game.getGoldAmount());
		
		game.gethandcard(0).onplay();
		assertEquals(1, game.gethandlength());
		assertEquals(3, game.getGoldAmount());
		
		assertEquals("Coin", game.gethandcard(0).getName());
		assertEquals("No card", game.gethandcard(1).getName());
		assertEquals("No card", game.gethandcard(2).getName());
		assertEquals("No card", game.gethandcard(3).getName());
		
		/**
		assertEquals(9, game.getdecklength());
		game.newTurndraw();
		assertEquals(4, game.gethandlength()); 
		*/
		game.gethandcard(0).onplay(); 
		assertEquals(0, game.gethandlength());
		game.newTurndraw();
		assertEquals(3, game.gethandlength());
		
		}

}
