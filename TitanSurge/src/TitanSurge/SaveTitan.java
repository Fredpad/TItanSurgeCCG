package TitanSurge;
import java.io.*;
import java.util.ArrayList;
public class SaveTitan extends Game {
	public void saveGame(){
		//Try block in case we can't find the file the catch block will show error. 
		try {
			//open a file called Saveobj.save
		FileOutputStream saveFile=new FileOutputStream("SaveObj.sav");
		
		// Create an ObjectOutputStream to put objects into save file.
		ObjectOutputStream save = new ObjectOutputStream(saveFile);
		 // Getname will be implemented later. 
		save.writeObject(getname());
		
		}
		
		//catch block
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
