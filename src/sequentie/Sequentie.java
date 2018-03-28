package sequentie;
import filin.FileOpener;
import java.awt.Color;
import java.util.*;
import main.GUI;

public class Sequentie {
    String sequentie1;
    int locatie;
    boolean check; 
    ArrayList<ArrayList<ORF>> orflijst = new ArrayList<ArrayList<ORF>>() ;
   
    
    public Sequentie(){
        for (int i = 0; i<6;i++){
            orflijst.add(new ArrayList<ORF>());
        }
        check = false;
        sequentie1 = FileOpener.FileOpener();
        System.out.println(sequentie1);
        ORF a= new ORF();
        

        for (int p =0; p <orflijst.size();p++){
            check = p+1>(orflijst.size()/2);
            ORFA(p,check);
                
            
        }
   
        
        a.ORFC(sequentie1,check);
        
        
        
        
    }
    
    
    public String[] ORFA( int p, boolean check){
    if (check){
      String sequentie1 =new StringBuilder(this.sequentie1).reverse().toString();
    }
     boolean t = false;
        String sequentie2 ="";
     for (int y=p; y+3<sequentie1.length();y+=3){
        if (t==false && sequentie1.substring(y, y+3).equals("ATG")){
            orflijst.add(new ORF());
           t = true;
            sequentie2 = sequentie1.substring(y);
        }
       }
     
        if (t==true){
        System.out.println("Lengte ingevoerde sequentie:"+sequentie1.length());
        int l = sequentie1.length();
        String b = this.ORFB(sequentie2,sequentie1,l,check);
        
    }else System.out.println("geen orf gevonden");
    } 
    
    
}
