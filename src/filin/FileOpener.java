package filin;
import java.io.*;
import javax.swing.JFileChooser;

public class FileOpener {
public static String PATHWAY;
public static String sequentie;

public static String FileOpener(){
    JFileChooser fileChooser;
    fileChooser = new JFileChooser();
        File selectedFile;
        int reply = fileChooser.showOpenDialog(null);                       //openen van bestand + lezen
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
                sequentie = "";
        }
            else
                sequentie += sCurrentLine;
        }	
        } catch (IOException e) {
        e.printStackTrace();}
        return sequentie;
    }                                        
}

