package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controler.AbstractTicTacToeController;

/**
 * <b>EcouteurFin est la classe écoutant les actions sur le bouton "Fin".</b>
 * <p>
 * Quand un clic est détecté, la demande est transmise au controleur.
 * </p>
 * 
 * @author Cyril MONSIEUX
 * @version 1.0
 */
public class EcouteurFin implements ActionListener {
	
	private AbstractTicTacToeController controler;
	
	public EcouteurFin(AbstractTicTacToeController controler){
		this.controler=controler;
	}
	
	/** 
     * Clic sur "Fin"
     * 
     * @see #actionPerformed(ActionEvent e)
	 * @since     1.0                 
	 */
	public void actionPerformed (ActionEvent e) {
		controler.fin () ;
	}
}