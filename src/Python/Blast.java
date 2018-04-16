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
	
	
	
	/**
	 * Blast 
	 * @param title
	 * @param seq
	 * @param typeBlast
	 * @param matrix
	 * @param dataBase
	 */
	public static void Blast(String title, String seq, String typeBlast, String matrix, String dataBase){
		Runtime rt = Runtime.getRuntime();
		try {
			//System.out.println("python blast/autoblastnohtmlnext.py "+Blast.title+" "+seq+" "+typeBlast+" "+matrix+" "+dataBase);
			Process pr = Runtime.getRuntime().exec("python blast/autoblastnohtmlnext.py "+Blast.title+title+" "+seq+" "+typeBlast+" "+matrix+" "+dataBase);
			BufferedReader br = new BufferedReader(new InputStreamReader(pr.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//De database werkt nog niet
		/*
		try {
			DataUpload.xml_Reader(new File("BlastResults/"+title.substring(1)+typeBlast.toLowerCase()+".xml"), seq);
		} catch (XPathExpressionException | ClassNotFoundException
				| ParserConfigurationException | SAXException | IOException
				| SQLException e) {
			e.printStackTrace();
		}*/
		blasts++;
	}
}
