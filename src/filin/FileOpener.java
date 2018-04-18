package filin;
import java.io.*;
import javax.swing.JFileChooser;

public class FileOpener {
public static String PATHWAY;
public static String[] sequentie = new String[2];

/**
 * @author Ruben, Sebastiaan
 * De file open methode wordt gebruikt voor het inlezen van een bestand, en het eruit halen van de sequentie
 * input is een bestand
 * output is een sequentie
 */
public static String[] FileOpener() throws notFasta, Cancel{
	try{
		JFileChooser fileChooser;
		fileChooser = new JFileChooser();
        File selectedFile;
        int reply = fileChooser.showOpenDialog(null);                       
        selectedFile = fileChooser.getSelectedFile();
        PATHWAY = selectedFile.toString();
	}
	catch(NullPointerException e){
		throw new Cancel("Be more decisive!");
	}
    if (!(PATHWAY.contains(".fasta") || PATHWAY.contains(".fa"))){
        throw new notFasta("File is not a fasta file.");
    }

    BufferedReader br = null;
    FileReader fr = null;

    try{
            fr = new FileReader(PATHWAY);
            br = new BufferedReader(fr);
            String sCurrentLine;
            sequentie[1]="";
            while ((sCurrentLine = br.readLine()) != null) {
                if (sCurrentLine.startsWith(">")){
                    sequentie[0] = sCurrentLine;
                }
                else
                    sequentie[1] += sCurrentLine;
            }	
    } catch (IOException e) {
    e.printStackTrace();}
    return sequentie;
}                                        
    
	/**
	 * Wordt gegooid als er een bestand ingeladen wordt dat geen .fa of .fasta in de bestandsnaam te vinden is.
	 * @author Sebastiaan, Ruben
	 *
	 */
    public static class notFasta extends Exception {

        public notFasta(String bericht) {
            super(bericht);
        }
    }
    
    public static class Cancel extends Exception {

        public Cancel(String bericht) {
            super(bericht);
        }
    }
}

