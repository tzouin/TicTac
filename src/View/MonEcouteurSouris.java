package View;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Controler.AbstractTicTacToeController;

/**
 * <b>MonEcouteurSouris est la classe permettant de détecter les évènements de la souris.</b>
 * <p>
 * Quand un clic est détecté, on vérifie que le clic est bien dans une case. 
 * Si c'est bien le cas, on notifie le controleur.
 * </p>
 * 
 * @author Cyril MONSIEUX
 * @version 1.0
 */

public class MonEcouteurSouris extends MouseAdapter {

	private AbstractTicTacToeController controler;
	int x,y,cote;

	public MonEcouteurSouris(AbstractTicTacToeController controler, int x, int y, int cote){
		this.controler=controler;
		this.x=x;
		this.y=y;
		this.cote=cote;
	}

	public void mousePressed (MouseEvent e) {
		int xSouris = e.getX() ;
		int ySouris = e.getY() ;
		if (alinterieur(xSouris,ySouris)) {
			int i = numeroCaseColonne(xSouris) ;
			int j = numeroCaseLigne(ySouris) ;
			controler.unNouveauCoup (i, j) ;
		}
	}
	/** 
     * Cette méthode vérifie que le clic à la position xPos, et yPos
     * est bien dans la zone de jeu.
     * 
     * @param xPos : la position X au moment du clic
     * @param yPos : la position Y au moment du clic
     * 
     * @return <b>true</b> si la position est correct, <b>false</b> sinon.
     * @see #alinterieur(int xPos, int yPos)
	 * @since     1.0                 
	 */
	private boolean alinterieur (int xPos, int yPos) {
		if ((x < xPos) && (xPos < x+3*cote)
				&& (y < yPos) && (yPos < y+3*cote)) {
			return true ;
		}
		else {
			return false ;
		}
	}

	/** 
     * Cette méthode renvoie la colonne par rapport à la position X du clic
     * 
     * @param xPos : la position X au moment du clic
     * 
     * @return Le numéro de la colonne
     * @see #numeroCaseColonne(int xPos)
	 * @since     1.0                 
	 */
	private int numeroCaseColonne(int Xpos) {
		return (Xpos-x)/cote ;
	}

	/** 
     * Cette méthode renvoie la rangée par rapport à la position Y du clic
     * 
     * @param yPos : la position Y au moment du clic
     * 
     * @return Le numéro de la rangée
     * @see #numeroCaseLigne(int YPos)
	 * @since     1.0                 
	 */
	private int numeroCaseLigne(int Ypos) {
		return (Ypos-y)/cote ;
	}
}