package sequentie;
import filin.FileOpener;
import filin.FileOpener.Cancel;
import filin.FileOpener.notFasta;
import java.awt.Color;
import java.util.*;
import javax.swing.JOptionPane;
import main.GUI;


/**
 * @author Ruben, Sebastiaan
 * Klasse voor een sequentie waar ORF's op te vinden zijn.
 * sequentie1, de sequentie als string opgeslagen
 * titel, de naam van de sequentie (belangerijk voor de database)
 * orfLijst, lijst van 6 frames met lijsten van ORF's
 * FRAMES, het aantal mogelijke frames in een sequentie
 *
 */
public class Sequentie {
    String sequentie1,titel;
    ArrayList<ArrayList<ORF>> orflijst = new ArrayList<ArrayList<ORF>>() ;
    private final int FRAMES = 6;
   
    /**
     * getter voor sequentie1
     * @return sequentie1
     */
    public String getSequentie1()  {
		return sequentie1;
	}

    /**
     * setter voor sequentie1
     * @param sequentie1
     */
	public void setSequentie1(String sequentie1) {
		this.sequentie1 = sequentie1;
	}

	/**
	 * getter voor orfLijst
	 * @return orflijst
	 */
	public ArrayList<ArrayList<ORF>> getOrflijst() {
		return orflijst;
	}

	/**
	 * setter voor orfLijst
	 * @param orflijst
	 */
	public void setOrflijst(ArrayList<ArrayList<ORF>> orflijst) {
		this.orflijst = orflijst;
	}

	/**
	 * Constructor voor sequentie. Maakt de variabelen aan.
	 * @throws notFasta, wordt gegooid als het bestand niet gelezen is kunnen worden
	 */
	public Sequentie() throws notFasta, Cancel{
        String[] seq = FileOpener.FileOpener();
        this.titel = seq[0];
        this.sequentie1 = seq[1];
        

        for (int p =0; p <FRAMES;p++){
            findORF(p,p+1>FRAMES/2);
                
        }       
    }
    
	/**
	 * Getter voor titel
	 * @return titel
	 */
    public String getTitel() {
		return titel;
	}

    /**
     * Setter voor titel
     * @param titel
     */
	public void setTitel(String titel) {
		this.titel = titel;
	}

	/**
	 * Vindt de ORF's in de sequentie en zet die in in de klasse variabelen
	 * @param p, de frame in welke hij zoekt
	 * @param check, forward of reverse
	 */
	private void findORF( int p, boolean check){
    	String seq = this.sequentie1;
    	
	    if (check){
	      seq =new StringBuilder(this.sequentie1).reverse().toString();
	    }
	    ArrayList<ORF> ORFS = new ArrayList<ORF>();
	     for (int y=p; y+3<sequentie1.length();y+=3){
	    	 if (seq.substring(y, y+3).equals("ATG")){
	        	int end = findStopCodon(seq, y);
	        	if(end != -1){
	        		ORFS.add(new ORF(seq.substring(y,end),y,end));
	            	y = end;
	        	}
	    	 }
	     }
	     orflijst.add(ORFS);
    } 
    
    /**
     * Vindt het eerste stop codon vanaf een locatie in een sequentie
     * @param sequentie, de sequentie waarin hij moet zoeken
     * @param start, het punt waar hij moet beginnen met zoeken.
     * @return de locatie van het stop codon of -1 als er niks gevonden is.
     */
    private int findStopCodon(String sequentie,int start){
	    for(int i = start; i+3<sequentie.length();i+=3){
	        if(sequentie.substring(i,i+3).contains("TAG")||sequentie.substring(i,i+3).contains("TAA")||sequentie.substring(i,i+3).contains("TGA")){
	            return i+3;
	        }
	    }
	    return -1;
    }
    
    
}
