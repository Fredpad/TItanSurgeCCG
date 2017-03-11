package Common;
import Omens.*;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import Titan.*;
//import Titan.Player;1

//import Omens.Player;
import Omens.*;

public class Main {

	public static void main(String[] args) throws IOException { 
		
		Scanner read = new Scanner(System.in);
		String input;
		System.out.println("Welcome! We have two games to play: TitanSurge and War of Omens. \nWhich do you want to play? Input Titan or Omens");
		input = read.next(); 
		
		
		if(input.equalsIgnoreCase("Titan")){
			TitanPlay.play();
			}
			
		else if(input.equalsIgnoreCase("Omens")){
			OmensPlay.play();
			
		}
		else{
			while(input.equalsIgnoreCase("Titan") ==false && input.equalsIgnoreCase("Omens") == false){
			System.out.println("That input did not match Titan or Omens. Try again: ");
			input  = read.next();}
			
		}
	}}


