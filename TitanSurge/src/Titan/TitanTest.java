package Titan;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import Common.Duel;
import Common.FactoryProducer;

public class TitanTest {
	
	//By testing the campaign classes, all other complexities of the codes 
		//are also being tested. Thus if this works successfully and there is a winner
		//then all code works with no errors.
	@Test
	public void testCampaign1() throws IOException {
		boolean winner ;
		TitanPlayer campaign1 = FactoryProducer.getTitan("Campaign 1");
		TitanPlayer campaign2 = FactoryProducer.getTitan("Campaign 2");
		
		campaign1.setEnemy(campaign2);
		campaign2.setEnemy(campaign1);
		
		winner = Duel.battle(campaign1, campaign2);
		
		if(winner == false)
			assertTrue(campaign1.gethealth() <= 0);
		else
			assertTrue(campaign2.gethealth() <= 0);
	}
	
	//By testing the campaign classes, all other complexities of the codes 
		//are also being tested. Thus if this works successfully and there is a winner
		//then all code works with no errors.
	@Test
	public void testCampaign2() throws IOException{
		boolean winner ;
		TitanPlayer campaign1 = FactoryProducer.getTitan("Campaign 3");
		TitanPlayer campaign2 = FactoryProducer.getTitan("Campaign 4");
		
		campaign1.setEnemy(campaign2);
		campaign2.setEnemy(campaign1);
		
		winner = Duel.battle(campaign1, campaign2);
		
		if(winner == false)
			assertTrue(campaign1.gethealth() <= 0);
		else
			assertTrue(campaign2.gethealth() <= 0);
	}
	
	//By testing the campaign classes, all other complexities of the codes 
		//are also being tested. Thus if this works successfully and there is a winner
		//then all code works with no errors.
	@Test
	public void testCampaign3() throws IOException{
		boolean winner ;
		TitanPlayer campaign1 = FactoryProducer.getTitan("Campaign 5");
		TitanPlayer campaign2 = FactoryProducer.getTitan("Campaign 6");
		
		campaign1.setEnemy(campaign2);
		campaign2.setEnemy(campaign1);
		
		winner = Duel.battle(campaign1, campaign2);
		
		if(winner == false)
			assertTrue(campaign1.gethealth() <= 0);
		else
			assertTrue(campaign2.gethealth() <= 0);
	}
	
	//By testing the campaign classes, all other complexities of the codes 
	//are also being tested. Thus if this works successfully and there is a winner
	//then all code works with no errors.
	@Test
	public void testCampaign4() throws IOException{
		boolean winner ;
		TitanPlayer campaign1 = FactoryProducer.getTitan("Campaign 7");
		TitanPlayer campaign2 = FactoryProducer.getTitan("Campaign 8");
		
		campaign1.setEnemy(campaign2);
		campaign2.setEnemy(campaign1);
		
		winner = Duel.battle(campaign1, campaign2);
		
		if(winner == false)
			assertTrue(campaign1.gethealth() <= 0);
		else
			assertTrue(campaign2.gethealth() <= 0);
	}

}
