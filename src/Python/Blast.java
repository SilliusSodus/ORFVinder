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
/**
 * Statische klasse om sequenties te blasten.
 * blasts, simpele statische variabele om bij te houden hoe vaak er in een sessie geblast is.
 * @author sebastiaan
 *
 */
public abstract class Blast {
	private static int blasts = 1;
	
	
	
	/**
	 * Blast een sequentie met python code via de terminal. Python moet geïnstalleerd zijn.
	 * @param title, de titel die de blast results zal krijgen
	 * @param seq, de sequentie die geblast moet worden
	 * @param typeBlast, de soort blast die gedaan moet worden (tblastx, blastp, ...)
	 * @param matrix, welke matrix gebruikt moet worden voor de blast (PAM, BLOSUM, ...)
	 * @param dataBase, welke database gebruikt moet worden in de blast (nr, swiss, ...)
	 */
	public static void Blast(String title, String seq, String typeBlast, String matrix, String dataBase){
		//File sequences;
		title = "Sequence"+blasts+title;
		Runtime rt = Runtime.getRuntime();
		try {
			//System.out.println("python blast/autoblastnohtmlnext.py "+Blast.title+" "+seq+" "+typeBlast+" "+matrix+" "+dataBase);
			Process pr = Runtime.getRuntime().exec("python blast/autoblastnohtmlnext.py "+title+" "+seq+" "+typeBlast+" "+matrix+" "+dataBase);
			BufferedReader br = new BufferedReader(new InputStreamReader(pr.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//De database werkt (nog) niet
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
