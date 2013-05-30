package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controler.AbstractTicTacToeController;

/**
 * <b>EcouteurAnnule est la classe écoutant les actions sur le bouton "Annule".</b>
 * <p>
 * Quand un clic est détecté, la demande est transmise au controleur.
 * </p>
 * 
 * @author Cyril MONSIEUX
 * @version 1.0
 */
public class EcouteurAnnule implements ActionListener {
	
	/**Le controleur*/
	private AbstractTicTacToeController controler;
	
	public EcouteurAnnule(AbstractTicTacToeController controler){
		this.controler=controler;
	}
	/** 
     * Clic sur "Annuler coup"
     * 
     * @see #actionPerformed(ActionEvent e)
	 * @since     1.0                 
	 */
	public void actionPerformed (ActionEvent e) {
   		controler.annuleLeDernierCoup () ;
	}
}