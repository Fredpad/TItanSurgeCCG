package Omens;
import Common.*;
import java.util.ArrayList;
import java.util.List;

//the parent class that is used by subclasses to store 
//the differences between a normal Player class and the campaign classes
//as a bit of a challenge.
public class Campaign {
	int gold = 0, skulls = 0, apples = 0, magic = 0, health = 0;
	public String name;
	public String[] hand = new String[6];
	public String[] deck = new String[20]; 
	public String[] field = new String[50];
	public String[] bank = new String[5];
	public int handlength =0, decklength =0, fieldlength =0, banklength =0;
	
	
	//the string returned, changed by the subclasses
	//is used to let the OmenPlayer class know what changes to make to 
	//reflect the campaign class
	public String change(){
		return null;
	}
	
	
}
