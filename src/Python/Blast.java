package Python;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import sequentie.Sequentie;

public abstract class Blast {
	private static File sequences;
	private static int blasts = 1;
	private static String title = "Sequence"+blasts;
	
	
	public static void Blast(String title, String seq, String typeBlast, String matrix, String dataBase){
		Runtime rt = Runtime.getRuntime();
		try {
			System.out.println("python blast/autoblastnohtmlnext.py "+title+" "+seq+" "+typeBlast+" "+matrix+" "+dataBase);
			Process pr = rt.exec("python blast/autoblastnohtmlnext.py "+title+" "+seq+" "+typeBlast+" "+matrix+" "+dataBase);
			BufferedReader br = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			System.out.println(br.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		blasts++;
	}
	
	
	
}
