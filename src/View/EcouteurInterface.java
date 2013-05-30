package View;

import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import Controler.AbstractTicTacToeController;
/**
 * <b>EcouteurInterface est la classe écoutant les actions sur la vue.</b>
 * <p>
 * Quand un clic est détecté, la demande est transmise au controleur.
 * </p>
 * 
 * @author Cyril MONSIEUX
 * @version 1.0
 */

public class EcouteurInterface extends WindowAdapter {

	private AbstractTicTacToeController controler;
	private TicTacToeVue vue;
	public EcouteurInterface(AbstractTicTacToeController controler, TicTacToeVue vue){
		this.controler=controler;
		this.vue=vue;
	}
	
	/** 
     * Clic sur la croix de la fenetre
     * 
     * @see #windowClosing(WindowEvent e)
	 * @since     1.0                 
	 */
	public void windowClosing(WindowEvent e) {
		controler.cloreVue(vue);
	}	
}
