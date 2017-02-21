package Common;
import Omens.*;

import java.io.IOException;
import java.util.Random;
import Titan.*;
import Omens.*;

public class Main {

	public static void main(String[] args) {
		Player one = new Player(new Enemy3());
		
		one.printresources();
		System.out.println(one.getGoldAmount());
	}

}
