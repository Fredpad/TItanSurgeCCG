package Common;
import Omens.*;
import Titan.*;
import java.io.*;

public final class SaveLoad {
	
	
	public static void save(OmenPlayer one, OmenPlayer two) throws IOException{
		File file = new File("OmenSave.txt");
		
		if(file.exists() ==false){
			file.createNewFile();
		}
		
		FileOutputStream out  = new FileOutputStream(file);
		BufferedWriter write = new BufferedWriter(new OutputStreamWriter(out));
		
		write.write(one.getName() );
		write.newLine();
		write.write(String.valueOf(one.gethealth()));
		write.newLine();
		write.write(String.valueOf(one.getGoldAmount()));
		write.newLine();
		write.write(String.valueOf(one.getApplesAmount()));
		write.newLine();
		write.write(String.valueOf(one.getSkullAmount()));
		write.newLine();
		write.write(String.valueOf(one.getMagicAmount()));
		write.newLine();
		
		write.write(String.valueOf(one.getdecklength()));
		write.newLine();
		for(int i = 0; i < one.getdecksize(); i++){
			write.write(one.getdeckcard(i).getName());
			write.newLine();
		}
		write.flush();
		
		write.write(String.valueOf(one.gethandlength()));
		write.newLine();
		for(int i = 0; i < one.gethandsize(); i++){
			write.write(one.gethandcard(i).getName());
			write.newLine();}
		
		write.write(String.valueOf(one.getfieldlength()));
		write.newLine();
		for(int i = 0; i < one.getfieldsize(); i++){
			write.write(one.getfieldcard(i).getName());
			write.newLine();
		}
		
		write.write(String.valueOf(one.getBanklength()));
		write.newLine();
		for(int i = 0; i < one.getbanksize(); i++){
			write.write(one.getbankcard(i).getName());
			write.newLine();}
		
		write.flush();
	
		write.write(two.getName() );
		write.newLine();
		write.write(String.valueOf(two.gethealth()));
		write.newLine();
		write.write(String.valueOf(two.getGoldAmount()));
		write.newLine();
		write.write(String.valueOf(two.getApplesAmount()));
		write.newLine();
		write.write(String.valueOf(two.getSkullAmount()));
		write.newLine();
		write.write(String.valueOf(two.getMagicAmount()));
		write.newLine();
		
		write.write(String.valueOf(two.getdecklength()));
		write.newLine();
		for(int i = 0; i < two.getdecksize(); i++){
			write.write(two.getdeckcard(i).getName());
			write.newLine();
		}
		write.flush();
		
		write.write(String.valueOf(two.gethandlength()));
		write.newLine();
		for(int i = 0; i < two.gethandsize(); i++){
			write.write(two.gethandcard(i).getName());
			write.newLine();}
		
		write.write(String.valueOf(two.getfieldlength()));
		write.newLine();
		for(int i = 0; i < two.getfieldsize(); i++){
			write.write(two.getfieldcard(i).getName());
			write.newLine();
		}
		
		write.write(String.valueOf(two.getBanklength()));
		write.newLine();
		for(int i = 0; i < two.getbanksize(); i++){
			write.write(two.getbankcard(i).getName());
			write.newLine();}
		
		write.flush();
		write.close();
	}
	
	public static void printfile() throws IOException{
		File file = new File("OmenSave.txt");
		BufferedReader read = new BufferedReader(new FileReader(file));
		String line;
		
		while((line = read.readLine()) != null)
			System.out.println(line);
	}
	
	public static void load(OmenPlayer one, OmenPlayer two) throws IOException{
		File file = new File("OmenSave.txt");
		
		if(file.exists() == false)
			System.out.println("There is no save file");
		
		else{
			BufferedReader read = new BufferedReader(new FileReader(file));
			one.setName(read.readLine());
			one.sethealth(Integer.valueOf(read.readLine()));
			one.setgold(Integer.valueOf(read.readLine()));
			one.setapples(Integer.valueOf(read.readLine()));
			one.setskulls(Integer.valueOf(read.readLine()));
			one.setmagic(Integer.valueOf(read.readLine()));
			
			one.setdecklength(Integer.valueOf(read.readLine()));
			for(int i = 0; i < one.getdecksize(); i++){
				one.setdeckcard(read.readLine(), i);
			}
			
			one.sethandlength(Integer.valueOf(read.readLine()));
			for(int i = 0; i < one.gethandsize(); i++)
				one.sethandcard(read.readLine(), i);
			
			one.setfieldlength(Integer.valueOf(read.readLine()));
			for(int i = 0; i < one.getfieldsize(); i++)
				one.setfieldcard(read.readLine(), i);
			
			one.setbanklength(Integer.valueOf(read.readLine()));
			for(int i = 0; i < one.getbanksize(); i++){
				one.setbankcard(read.readLine(), i);}
			
			
			two.setName(read.readLine());
			two.sethealth(Integer.valueOf(read.readLine()));
			two.setgold(Integer.valueOf(read.readLine()));
			two.setapples(Integer.valueOf(read.readLine()));
			two.setskulls(Integer.valueOf(read.readLine()));
			two.setmagic(Integer.valueOf(read.readLine()));
			
			two.setdecklength(Integer.valueOf(read.readLine()));
			for(int i = 0; i < two.getdecksize(); i++){
				two.setdeckcard(read.readLine(), i);
			}
			
			two.sethandlength(Integer.valueOf(read.readLine()));
			for(int i = 0; i < two.gethandsize(); i++)
				two.sethandcard(read.readLine(), i);
			
			two.setfieldlength(Integer.valueOf(read.readLine()));
			for(int i = 0; i < two.getfieldsize(); i++)
				two.setfieldcard(read.readLine(), i);
			
			two.setbanklength(Integer.valueOf(read.readLine()));
			for(int i = 0; i < two.getbanksize(); i++)
				two.setbankcard(read.readLine(), i);
			
			read.close();
		}
	}

	public static void save(TitanPlayer one, TitanPlayer two) throws IOException{
		File file = new File("TitanSave.txt");
		
		if(file.exists() ==false){
			file.createNewFile();
		}
		
		FileOutputStream out  = new FileOutputStream(file);
		BufferedWriter write = new BufferedWriter(new OutputStreamWriter(out));
		
		write.write(one.getName());
		write.newLine();
		write.write(String.valueOf(one.gethealth()));
		write.newLine();
		
		write.write(String.valueOf(one.getdecklength()));
		write.newLine();
		for(int i = 0; i < one.getdecksize(); i++){
			write.write(one.getdeckcard(i).getName());
			write.newLine();}
		
		write.write(String.valueOf(one.gethandlength()));
		write.newLine();
		for(int i = 0; i < one.gethandsize(); i++){
			write.write(one.getHandcard(i).getName());
			write.newLine();
		}
		
		write.write(String.valueOf(one.getfieldlength()));
		write.newLine();
		for(int i = 0; i < one.getfieldsize(); i++){
			write.write(one.getFieldcard(i).getName());
			write.newLine();
		}
		
		write.write(String.valueOf(one.getcementarylength()));
		write.newLine();
		for(int i = 0; i < one.getcementarysize(); i++){
			write.write(one.getcementarycard(i).getName());
			write.newLine();
		}
			
		write.flush();
		
		write.write(two.getName());
		write.newLine();
		write.write(String.valueOf(two.gethealth()));
		write.newLine();
		
		write.write(String.valueOf(two.getdecklength()));
		write.newLine();
		for(int i = 0; i < two.getdecksize(); i++){
			write.write(two.getdeckcard(i).getName());
			write.newLine();}
		
		write.write(String.valueOf(two.gethandlength()));
		write.newLine();
		for(int i = 0; i < two.gethandsize(); i++){
			write.write(two.getHandcard(i).getName());
			write.newLine();
		}
		
		write.write(String.valueOf(two.getfieldlength()));
		write.newLine();
		for(int i = 0; i < two.getfieldsize(); i++){
			write.write(two.getFieldcard(i).getName());
			write.newLine();
		}
		
		write.write(String.valueOf(two.getcementarylength()));
		write.newLine();
		for(int i = 0; i < two.getcementarysize(); i++){
			write.write(two.getcementarycard(i).getName());
			write.newLine();
		}
		
		write.close();

	}
	
	public static void load(TitanPlayer one, TitanPlayer two) throws IOException{
		
		File file = new File("TitanSave.txt");
		
		if(file.exists() == false)
			System.out.println("There is no save file");
		
		else{
			BufferedReader read = new BufferedReader(new FileReader(file));
			one.setname(read.readLine());
			one.sethealth(Integer.valueOf(read.readLine()));
			
			one.setdecklength(Integer.valueOf(read.readLine()));
			for(int i = 0; i < one.getdecksize(); i++){
				one.setdeckcard(read.readLine(), i);
			}
			
			one.sethandlength(Integer.valueOf(read.readLine()));
			for(int i = 0; i < one.gethandsize(); i++)
				one.sethandcard(read.readLine(), i);
			
			one.setfieldlength(Integer.valueOf(read.readLine()));
			for(int i = 0; i < one.getfieldsize(); i++)
				one.setfieldcard(read.readLine(), i);
			
			one.setcementarylength(Integer.valueOf(read.readLine()));
			for(int i = 0; i < one.getcementarysize(); i++)
				one.setcementarycard(read.readLine(), i);
			
			
			
			two.setname(read.readLine());
			two.sethealth(Integer.valueOf(read.readLine()));
			
			two.setdecklength(Integer.valueOf(read.readLine()));
			for(int i = 0; i < two.getdecksize(); i++){
				two.setdeckcard(read.readLine(), i);
			}
			
			two.sethandlength(Integer.valueOf(read.readLine()));
			for(int i = 0; i < two.gethandsize(); i++)
				two.sethandcard(read.readLine(), i);
			
			two.setfieldlength(Integer.valueOf(read.readLine()));
			for(int i = 0; i < two.getfieldsize(); i++)
				two.setfieldcard(read.readLine(), i);
			
			two.setcementarylength(Integer.valueOf(read.readLine()));
			for(int i = 0; i < two.getcementarysize(); i++)
				two.setcementarycard(read.readLine(), i);
			
			read.close();
			
			
		}
	}

}
