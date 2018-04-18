package sequentie;
import java.util.*;

/**
 * Klasse voor een ORF
 * begin, de eerste locatie van het orf op de sequentie waar hij op gevonden is.
 * end, de laatste locatie van het orf op de sequentie waar hij op gevonden is.
 * seq, de sequentie van het orf.
 * 
 * @author ,Ruben, Sebastiaan
 *
 */
public class ORF {
    int begin,end;
    String seq;
    /**
     * ORF constructor
     * @param seq, de sequentie van het orf
     * @param begin, de begin locatie van de sequentie op sequentie waar het ORF op gevonden is.
     * @param end, het de laatste locatie van de sequentie op de sequentie waar het ORF op gevonden is.
     */
    ORF(String seq,int begin, int end){
    	this.seq = seq;
    	this.begin = begin;
    	this.end = end;
    }

    
    /**Wordt gebruikt om de beginlocatie aan te vragen
     * geen input
     * output is de aangevraagde beginlocatie
     */

    public int getBegin() {
		return begin;
	}

    /**Wordt gebruikt om de beginlocatie te vervangen
     * input is een beginlocatie
     * geen output
     */


	public void setBegin(int begin) {
		this.begin = begin;
	}

    /**Wordt gebruikt om de eindlocatie aan te vragen
     * geen input
     * output is de aangevraagde eindlocatie
     */


	public int getEnd() {
		return end;
	}

    /**Wordt gebruikt om de eindlocatie te vervangen
     * input is een eindlocatie
     * geen output
     */


	public void setEnd(int end) {
		this.end = end;
	}

    /**Wordt gebruikt om de sequentie aan te vragen
     * geen input
     * output is de aangevraagde sequentie
     */


	public String getSeq() {
		return seq;
	}

    /**Wordt gebruikt om de sequentie te vervangen
     * input is een sequentie
     * geen output
     */
	public void setSeq(String seq) {
		this.seq = seq;
	}    
}
