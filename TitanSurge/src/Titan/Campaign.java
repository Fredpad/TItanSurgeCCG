package Titan;
//PARENT CLASS used to store the changes we want to make in TitanPlayer classes
//to make them different and a little bit of a challenge for the campaign
public class Campaign {
	public int cementarysize = 10, cementarylength = 0; 
	public String[] cementary = new String[cementarysize]; 
	public String[] deck = new String[10], hand = new String[5], field = new String[5];
	public int health = 1000;
	public int handlength = 0;
	public int fieldlength = 0;
	public int decklength = 0;
	String name;
	
	//the method is to be changed by subclasses.
	//the string return tells the TitanPlayer class what changes to look for and
	//copy to be the campaign enemy we want in the game
	public String change(){return null;} 
}
