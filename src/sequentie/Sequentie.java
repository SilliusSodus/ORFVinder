package sequentie;
import filin.FileOpener;
import java.util.*;

public class Sequentie {
    String sequentie1;
    int locatie;
    List <ORF> ORFs = new ArrayList<ORF>();
    
    public Sequentie(){
        sequentie1 = FileOpener.FileOpener();
        System.out.println(sequentie1);
        ORF a= new ORF();
        int p =0;
                System.out.println("--------------------------------------------------------------------------------------------------------------------");
        System.out.println("\nshift 1:");
        a.ORFA(sequentie1,p);

        p+=1;
                System.out.println("--------------------------------------------------------------------------------------------------------------------");
        System.out.println("\nshift 2:");
        a.ORFA(sequentie1,p);

        p+=1;
                System.out.println("--------------------------------------------------------------------------------------------------------------------");
        System.out.println("\nshift 3:");
        a.ORFA(sequentie1, p);
        String seq1 =new StringBuilder(sequentie1).reverse().toString();
                System.out.println("--------------------------------------------------------------------------------------------------------------------");
        System.out.println("\nshift -3:");
        a.ORFA(seq1, p);
                System.out.println("--------------------------------------------------------------------------------------------------------------------");
        System.out.println("\nshift -2:");
        p-=1;
        a.ORFA(seq1, p);
                System.out.println("--------------------------------------------------------------------------------------------------------------------");
        System.out.println("\nshift -1:");
        p-=1;
        a.ORFA(seq1, p);
        

        
        
    }
}
