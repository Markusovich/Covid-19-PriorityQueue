package source;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Driver {

	public static void main(String[] args) {
		
		Queue<Patient> x = new Queue<Patient>();
		x.enqueue(new Patient(null, null, 0, null));
		
		try{
			FileReader fr = new FileReader("PatientRecord.txt");
			BufferedReader br = new BufferedReader(fr);
			
			Scanner scan = new Scanner(br);
			String[] str = new String[4];
	        while(scan.hasNextLine()){
				String line = scan.nextLine();
		        if((line.length() > 0)){
		        	str = line.split(" ");
			        String fstnme = str[0];
			        String lstnme = str[1];
			        int age = Integer.parseInt(str[2]);
			        String risklevel = str[3];
			        x.enqueue(new Patient(fstnme, lstnme, age, risklevel));
		        }
	        }
			br.close();
			scan.close();
		}
		catch(IOException e){
			System.out.println("Not working");
		}
		
		while(!x.isEmpty()) {
			Patient var = x.dequeue();
			System.out.println("-----------------------------");
			System.out.println(var.getLstnme() + ", " + var.getFstnme()
					+ " | " + var.getAge() + " | " + var.getRisklevel() + " |");
		}
		System.out.println("-----------------------------");

	}

}
