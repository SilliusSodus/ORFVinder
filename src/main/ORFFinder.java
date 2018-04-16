package main;

import Python.Blast;

public class ORFFinder extends GUI {

	/**
	 * The main dude, bowling on in this crazy universe of hours
	 * 
	 * Date created: 21 mar 2018
	 * 
	 * @authors Erik verweij, Sebastiaan te Molder, Ruben Kollen
	 * 
	 * De applicatie zal start codons in een sequentie vinden en de sequentie tot en met een stop codon aangeven.
	 * Deze sequentie kan dan geblast worden.
	 * 
	 * Aanpassingen vanuit het design: De database is lokaal gemaakt, omdat er niet met de server die ons gegeven is gecommuniceerd kan worden vannuit het programma.
	 * 
	 * bugs: De database werkt niet. Erik, eleborate?
	 * Als er een te lange sequentie in het programma wordt gedaan zal hij het eerste deel van de sequentie herhalen op het scherm. De String is wel goed als er gesyso'd wordt.
	 * 
	 */
	public static void main(String[] args) {
		GUI.draw();

	}

}
