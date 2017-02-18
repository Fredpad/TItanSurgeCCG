package Common;

public class Main {

	public static void main(String[] args) {
		double d = (Math.random()*100);
	
		for(int i = 0; i < 5; i+=1){
			d= Math.random()*100;
			System.out.println(d);
		}

	}

}
