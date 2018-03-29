package Python;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

import database.DataUpload;

import sequentie.Sequentie;

public abstract class Blast {
	private static File sequences;
	private static int blasts = 1;
	private static String title = "Sequence"+blasts;
	
	
	public static void Blast(String title, String seq, String typeBlast, String matrix, String dataBase){
		Runtime rt = Runtime.getRuntime();
		try {
			Process pr = rt.exec("python blast/autoblastnohtmlnext.py "+title+" "+seq+" "+typeBlast+" "+matrix+" "+dataBase);
			BufferedReader br = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			System.out.println(br.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			DataUpload.xml_Reader(new File("BlastResults/"+title), seq);
		} catch (XPathExpressionException | ClassNotFoundException
				| ParserConfigurationException | SAXException | IOException
				| SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		blasts++;
	}
	
	
	
}
