package View;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * <b>MonCanvas est la classe permettant de dessiner la grille de jeu.</b>
 * <p>
 * Quand un clic est détecté, la demande est transmise au controleur.
 * </p>
 * 
 * @author Cyril MONSIEUX
 * @version 1.0
 */

public 	class MonCanvas extends JPanel {
	private static final long serialVersionUID = 1L;
	private TicTacToeVue vue;
	
	public MonCanvas (TicTacToeVue vue) {
		setPreferredSize(new Dimension(200, 200));
		this.vue=vue;
	}	
	
	/**Permet de dessiner le plateau*/
	public void paintComponent (Graphics g) {
		super.paintComponent (g) ;
		vue.redessineLePlateau (g) ;
	}
	
}