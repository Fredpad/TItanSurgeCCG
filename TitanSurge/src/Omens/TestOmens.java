package Omens;

import static org.junit.Assert.*;

import java.io.IOException;

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
		
		game.gethandcard(0).onplay(); 
		assertEquals(0, game.gethandlength());
		

}
	
	//Testing to see if campaigns 7 and 8 can play and give a winner
	@Test
	public void testCampaigns4() throws IOException{
		
		boolean winner;

		OmenPlayer campaign7 = FactoryProducer.getOmen("Campaign 7");
		OmenPlayer campaign8 = FactoryProducer.getOmen("Campaign 8");
		

		campaign7.setEnemy(campaign8);
		campaign8.setEnemy(campaign7);
		
		winner = Duel.battle(campaign7, campaign8);
		
		if(winner == false)
			assertTrue(campaign7.gethealth() <= 0);
		else
			assertTrue(campaign8.gethealth() <=0);
	}
	
	//Testing to see if campaigns 5 and 6 can play and give a winner
	@Test
	public void testCampaigns3() throws IOException{
		
		boolean winner;
		OmenPlayer campaign5 = FactoryProducer.getOmen("Campaign 5");
		OmenPlayer campaign6 = FactoryProducer.getOmen("Campaign 6");
	
		campaign5.setEnemy(campaign6);
		campaign6.setEnemy(campaign5);
		
		winner = Duel.battle(campaign5, campaign6);
		
		if(winner == false)
			assertTrue(campaign5.gethealth() <= 0);
		else
			assertTrue(campaign6.gethealth() <=0);
		
		
	}
	
	//Testing to see if campaigns 3 and 4 can play and give a winner
	@Test
	public void testCampaigns2() throws IOException{
		boolean winner;
		OmenPlayer campaign3 = FactoryProducer.getOmen("Campaign 3");
		OmenPlayer campaign4 = FactoryProducer.getOmen("Campaign 4");
		
		campaign3.setEnemy(campaign4);
		campaign4.setEnemy(campaign3);
		
		winner = Duel.battle(campaign3, campaign4);
		
		if(winner == false)
			assertTrue(campaign3.gethealth() <= 0);
		else
			assertTrue(campaign4.gethealth() <=0);
		
		
	}
	
	
	//Testing to see if campaigns 1 and 2 can play and give a winner
	@Test
	public void testCampaigns1() throws IOException{
	
	OmenPlayer campaign1 = new OmenPlayer(new OmenEnemy1("Campaign 1"));
	OmenPlayer campaign2 = new OmenPlayer(new OmenEnemy2("Campaign 2"));
	
	campaign1.setEnemy(campaign2);
	campaign2.setEnemy(campaign1);
	
	boolean winner = false;
	

	winner = Duel.battle(campaign1, campaign2);
	
	
	if(winner == false)
		assertTrue(campaign1.gethealth() <= 0);
	else
		assertTrue(campaign2.gethealth() <=0);
		
	
}
}
