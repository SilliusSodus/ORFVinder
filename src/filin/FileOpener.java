package filin;
import java.io.*;
import javax.swing.JFileChooser;

public class FileOpener {
public static String PATHWAY;
public static String[] sequentie = new String[2];

/**De file open methode wordt gebruikt voor het inlezen van een bestand, en het eruit halen van de sequentie
 * input is een bestand
 * output is een sequentie
 */
public static String[] FileOpener(){
    JFileChooser fileChooser;
    fileChooser = new JFileChooser();
        File selectedFile;
        int reply = fileChooser.showOpenDialog(null);                       
        selectedFile = fileChooser.getSelectedFile();
        PATHWAY = selectedFile.toString();

        
        BufferedReader br = null;
        FileReader fr = null;
        
        try{
	        fr = new FileReader(PATHWAY);
	        br = new BufferedReader(fr);
	        String sCurrentLine;
	        while ((sCurrentLine = br.readLine()) != null) {
	            if (sCurrentLine.startsWith(">")){
	                sequentie[0] = sCurrentLine;
	            }
	            else
	                sequentie[1] = sCurrentLine;
	        }	
        } catch (IOException e) {
        e.printStackTrace();}
        return sequentie;
    }                                        
}

