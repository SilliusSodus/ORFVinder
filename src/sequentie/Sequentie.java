package sequentie;
import filin.FileOpener;
import java.awt.Color;
import java.util.*;
import main.GUI;

public class Sequentie {
    String sequentie1,titel;
    int locatie;
    boolean check; 
    ArrayList<ArrayList<ORF>> orflijst = new ArrayList<ArrayList<ORF>>() ;
   
   
    /**Wordt gebruikt om de sequentie aan te vragen
     * geen input
     * output is de aangevraagde sequentie
     */
    public String getSequentie1() {                                       
		return sequentie1;                                        
	}                                                                 

    /**Wordt gebruikt om de sequentie te vervangen
     * input is een sequentie
     * geen output
     */
	public void setSequentie1(String sequentie1) {
		this.sequentie1 = sequentie1;
	}

    /**Wordt gebruikt om de locatie aan te vragen
     * geen input
     * output is de aangevraagde locatie
     */
	public int getLocatie() {
		return locatie;
	}

    /**Wordt gebruikt om de locatie te vervangen
     * input is een locatie
     * geen output
     */
	public void setLocatie(int locatie) {
		this.locatie = locatie;
	}

    /**Wordt gebruikt om de lijst van ORF's aan te vragen
     * geen input
     * output is de lijst van ORF's
     */
	public ArrayList<ArrayList<ORF>> getOrflijst() {
		return orflijst;
	}

    /**Wordt gebruikt om de lijst van ORF's te vervangen
     * input is een lijst van ORF's
     * geen output
     */
	public void setOrflijst(ArrayList<ArrayList<ORF>> orflijst) {
		this.orflijst = orflijst;
	}


/**Sequentie methode wordt gebruikt om de ORF methode aan te roepen, en de gevonden ORF's toe te voegen in een lijst
 * input is sequentie
 * output is een lijst met ORF's van 6 frames
 */
	public Sequentie(){
        for (int i = 0; i<6;i++){
            orflijst.add(new ArrayList<ORF>());
        }
        check = false;
        String[] seq = FileOpener.FileOpener();
        this.titel = seq[0];
        this.sequentie1 = seq[1];
        //ORF a= new ORF();

        

        for (int p =0; p <orflijst.size();p++){
            check = p+1>(orflijst.size()/2);
            ORFA(p,check);   
        }
    }
    
     /**Wordt gebruikt om de titel op te vragen
     * geen input
     * output is de titel
     */
        
    public String getTitel() {
		return titel;
	}

    /**Wordt gebruikt om de titel te vervangen
     * input is een titel
     * geen output
     */
	public void setTitel(String titel) {
		this.titel = titel;
	}

    /** ORFA methode wordt gebruikt voor het vinden van het startcodon, en het knippen van de sequentie op basis van het startcodon en stopcodon
    * input is frame, frame forward/backward check, sequentie
    * output is orf die toegevoegd wordt in de orflijst
    */
	public void ORFA( int p, boolean check){
    	String seq = this.sequentie1;
    	
	    if (check){
	      seq =new StringBuilder(this.sequentie1).reverse().toString();
	    }
	     for (int y=p; y+3<sequentie1.length();y+=3){
	    	 if (seq.substring(y, y+3).equals("ATG")){
	        	int end = findStopCodon(seq, y);
	        	if(end != -1){
	        		orflijst.get(p).add(new ORF(seq.substring(y,end),y,end));
	            	y = end;
	        	}
	        }
	       }
    } 
    
    /**
     * Findstopcodon methode wordt gebruikt om een stopcodon te zoeken en de plaats te returnen
     * input is sequentie, en startcodon locatie
     * output is locatie van stopcodon 
     */
    public int findStopCodon(String sequentie,int start){
	    for(int i = start; i+3<sequentie.length();i+=3){
	        if(sequentie.substring(i,i+3).contains("TAG")||sequentie.substring(i,i+3).contains("TAA")||sequentie.substring(i,i+3).contains("TGA")){
	            return i+3;
	        }
	    }
	    return -1;
    }
    
    
}
