package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controler.AbstractTicTacToeController;

/**
 * <b>EcouteurRecommence est la classe écoutant les actions sur le bouton "Nouvelle partie".</b>
 * <p>
 * Quand un clic est détecté, la demande est transmise au controleur.
 * </p>
 * 
 * @author Cyril MONSIEUX
 * @version 1.0
 */
public class EcouteurRecommence implements ActionListener {
	
	private AbstractTicTacToeController controler;
	
	public EcouteurRecommence(AbstractTicTacToeController controler){
		this.controler=controler;
	}
	
	/** 
     * Clic sur "Nouvelle partie"
     * 
     * @see #actionPerformed(ActionEvent e)
	 * @since     1.0                 
	 */
    public void actionPerformed (ActionEvent e) {
    	controler.recommence () ;
	}
}