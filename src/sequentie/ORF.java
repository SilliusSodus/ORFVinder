package sequentie;
import java.util.*;
public class ORF {
    int n;
    int k;
    int a = 0;
    int begin,end;
    String seq;
    String[] linesa = new String [10];
    String[] linesb = new String [10];
    
    ORF(String seq,int begin, int end){
    	this.seq = seq;
    	this.begin = begin;
    	this.end = end;
    }

    
    

    public int getBegin() {
		return begin;
	}




	public void setBegin(int begin) {
		this.begin = begin;
	}




	public int getEnd() {
		return end;
	}




	public void setEnd(int end) {
		this.end = end;
	}




	public String getSeq() {
		return seq;
	}




	public void setSeq(String seq) {
		this.seq = seq;
	}




	public void ORFB(String sequentie2,String sequentie1, int l,boolean check){
        k = 0;
        String orf = "";
        int r = l-sequentie2.length();
        for(int i = 0; i+3<sequentie2.length();i+=3){
            if(k!=i&& sequentie2.substring(i,i+3).contains("TAG")){
                k = i;
                a+=1;
                i+=sequentie2.length();
                //System.out.println("stopcodon TAG gevonden");
            }
            else if(k!=i && sequentie2.substring(i,i+3).contains("TAA")){
                k = i;
                a+=1;
                i+=sequentie2.length();
                //System.out.println("stopcodon TAA gevonden");
            }
            else if(k!=i && sequentie2.substring(i,i+3).contains("TGA")){
                k = i;
                a+=1;
                i+=sequentie2.length();
                //System.out.println("stopcodon TGA gevonden");
            }
        }
        
        if (k>0){
            orf = sequentie2.substring(0, k+3);
            
            String sequentie3 = sequentie2.substring(k+3);
            int Beginpunt = r;
            int Eindpunt = (k+3+r);
            System.out.println("gevonden reading frame:"+orf + " , locatie:"+Beginpunt +"-"+Eindpunt);
            boolean m = false;
                                                                                            
                                                                                                
                                                                                                
                                                                        
                                                
             linesa[a]="";
             linesb[a]="";
             
             if(!check){                       
            for(int b=0;b<Beginpunt;b++){
                for (int a= 0; a<linesa.length;a++){
                linesa[a]+=" ";
                }}}
             
             
             if(check){
                for(int b=0;b<(sequentie1.length()-Eindpunt);b++){
                for (int a= 0; a<linesb.length;a++){
                linesb[a]+=" "; 
                }}}
             
                if (check){
                     String x =new StringBuilder(orf).reverse().toString();
                     linesb[a]+=x;
                    
                    }else{
                    linesa[a]+=orf;}
                           
               
            for (int j = 0; j+3<sequentie3.length();j+=3){
                if (m==false && sequentie3.substring(j,j+3).equals("ATG")){
                    m = true;
                    sequentie2 = sequentie3.substring(j);
                    this.ORFB(sequentie2,sequentie1,l,check);
                }
               
            }
        }
        else{
            //System.out.println("geen stop codon gevonden");
        } seq =  orf;
    }
    public void ORFC(String sequentie1, boolean check){
        System.out.println("forward");
        for (int i = linesa.length-1;i>0;i--){
            if(linesa[i].contains("A")){
             System.out.println(linesa[i]);    
            }
        }
        System.out.println(sequentie1);
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        System.out.println("backward");
        for (int i = linesb.length-1;i>0;i--){
            if(linesb[i].contains("A")){
             System.out.println(linesb[i]);    
            }
        }
        System.out.println(sequentie1);
        //return linesa, linesb;
    }
    
    
    
    
}
