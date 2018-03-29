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
   
    
    public String getSequentie1() {
		return sequentie1;
	}


	public void setSequentie1(String sequentie1) {
		this.sequentie1 = sequentie1;
	}


	public int getLocatie() {
		return locatie;
	}


	public void setLocatie(int locatie) {
		this.locatie = locatie;
	}


	public ArrayList<ArrayList<ORF>> getOrflijst() {
		return orflijst;
	}


	public void setOrflijst(ArrayList<ArrayList<ORF>> orflijst) {
		this.orflijst = orflijst;
	}


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
   
        
        //a.ORFC(sequentie1,check);
        
        
        
        
    }
    
    
    public String getTitel() {
		return titel;
	}


	public void setTitel(String titel) {
		this.titel = titel;
	}


	public void ORFA( int p, boolean check){
    	String seq = this.sequentie1;
    	
	    if (check){
	      seq =new StringBuilder(this.sequentie1).reverse().toString();
	    }
	     //boolean t = false;
	        //String sequentie2 ="";
	     for (int y=p; y+3<sequentie1.length();y+=3){
	    	 if (seq.substring(y, y+3).equals("ATG")){
	        	int end = findStopCodon(seq, y);
	        	if(end != -1){
	        		orflijst.get(p).add(new ORF(seq.substring(y,end),y,end));
	            	y = end;
	        	}
	            //t = true;
	            //sequentie2 = seq.substring(y);
	        }
	       }
	     /*
	        if (t==true){
	        System.out.println("Lengte ingevoerde sequentie:"+sequentie1.length());
	        int l = sequentie1.length();
	        String b = this.ORFB(sequentie2,sequentie1,l,check);
	        
	    }else System.out.println("geen orf gevonden");*/
    } 
    
    
    public int findStopCodon(String sequentie,int start){
	    for(int i = start; i+3<sequentie.length();i+=3){
	        if(sequentie.substring(i,i+3).contains("TAG")||sequentie.substring(i,i+3).contains("TAA")||sequentie.substring(i,i+3).contains("TGA")){
	            return i+3;
	        }
	    }
	    return -1;
    }
    
    
}
