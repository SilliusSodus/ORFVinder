package sequentie;
import java.util.*;
public class ORF {
    int n;
    int k;

    public void ORFA(String sequentie1, int p){
     boolean t = false;
        String sequentie2 ="";
     for (int y=p; y+3<sequentie1.length();y+=3){
        if (t==false && sequentie1.substring(y, y+3).equals("ATG")){
           t = true;
            sequentie2 = sequentie1.substring(y);
            k +=sequentie1.length();
        }
       }
     
        if (t==true){
        System.out.println("Lengte ingevoerde sequentie:"+sequentie1.length());

        System.out.println("seq2:"+sequentie2);
        int l = sequentie1.length();
        this.ORFB(sequentie2,sequentie1,l);
        
    }else System.out.println("geen orf gevonden");}
    

    public void ORFB(String sequentie2,String sequentie1, int l){
        k = 0;
        int r = l-sequentie2.length();
        for(int i = 0; i+3<sequentie2.length();i+=3){
            if(k!=i&& sequentie2.substring(i,i+3).contains("TAG")){
                k = i;
                i+=sequentie2.length();
                //System.out.println("stopcodon TAG gevonden");
            }
            else if(k!=i && sequentie2.substring(i,i+3).contains("TAA")){
                k = i;
                i+=sequentie2.length();
                //System.out.println("stopcodon TAA gevonden");
            }
            else if(k!=i && sequentie2.substring(i,i+3).contains("TGA")){
                k = i;
                i+=sequentie2.length();
                //System.out.println("stopcodon TGA gevonden");
            }
        }
        
        if (k>0){
        String orf = sequentie2.substring(0, k+3);
            String sequentie3 = sequentie2.substring(k+3);
            int Beginpunt = r;
            int Eindpunt = (k+3+r);
            System.out.println("gevonden reading frame:"+orf + " , locatie:"+Beginpunt +"-"+Eindpunt);
            boolean m = false;
            String line1="";
            for(int b=0;b<Beginpunt;b++){
                line1+=" ";
            }
            line1+=orf;
            System.out.println("\n"+line1);
            System.out.println(sequentie1+"\n");
            for (int j = 0; j+3<sequentie3.length();j+=3){
                if (m==false && sequentie3.substring(j,j+3).equals("ATG")){
                    m = true;
                    sequentie2 = sequentie3.substring(j);
                    this.ORFB(sequentie2,sequentie1,l);
                }
                else{
                    //System.out.println("done");
                }
               
            }
        }
        else{
            //System.out.println("geen stop codon gevonden");
        }
    }
}
