package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controler.AbstractTicTacToeController;

/**
 * <b>EcouteurNouvelleVue est la classe �coutant les actions sur le bouton "Nouvelle vue".</b>
 * <p>
 * Quand un clic est d�tect�, la demande est transmise au controleur.
 * </p>
 * 
 * @author Cyril MONSIEUX
 * @version 1.0
 */

public class EcouteurNouvelleVue implements ActionListener {
	
	private AbstractTicTacToeController controler;
	
	public EcouteurNouvelleVue(AbstractTicTacToeController controler){
		this.controler=controler;
	}
	
	/** 
     * Clic sur "Nouvelle vue"
     * 
     * @see #actionPerformed(ActionEvent e)
	 * @since     1.0                 
	 */
    public void actionPerformed (ActionEvent e) {
    	controler.nouvelleVue () ;
	}
}