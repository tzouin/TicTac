package Controler;

import Model.AbstractTicTacToeModel;
import Observable.Observer;
import View.TicTacToeVue;

/**
 * <b>AbstractTicTacToeController est la classe abstraite repr�sentant un controleur.</b>
 * <p>
 * Un controleur est caract�ris� par les informations suivantes :
 * <ul>
 * <li>Un mod�le</li>
 * </ul>
 * </p>
 * <p>
 * Lorsqu'une modification sera effectu�e sur la vue, c'est le controleur qui sera averti. 
 * Puis le controleur informera le mod�le des demandes de changements.
 * </p>
 * 
 * @author Cyril MONSIEUX
 * @version 1.0
 */
public abstract class AbstractTicTacToeController {
	/**Le mod�le*/
	protected AbstractTicTacToeModel Model;
	
	/**
	 * (Implicitement appel� par les sous classes)
	 * Construit un nouveau controleur.
	 *
	 *@param Model : le mod�le 
	 * @see       #AbstractTicTacToeController(AbstractTicTacToeModel Model) 
	 * @since     1.0
	 */
	public AbstractTicTacToeController(AbstractTicTacToeModel Model){
		this.Model=Model;
	}
		
    /** 
     * Effectue, si possible, un nouveau coup � la position (i,j)
     * Cette m�thode appelle Model.unNouveauCoup(int i, int j).
     *
     * @param i         l'indice de la rang�e
     * @param j         l'indice de la colonne
     * 
     * @see #unNouveauCoup(int, int)
	 * @since     1.0                 
	 */
	public abstract void unNouveauCoup(int i, int j);
	
	/** 
     * Cette m�thode permet de vider toutes les cases. 
     * Cette m�thode appelle Model.unNouveauCoup(int i, int j).
     *
     * @see #recommence()
	 * @since     1.0                 
	 */
	public abstract void recommence();
	
    /** 
     * Effectue, si possible, la suppression du dernier coup.
     * Cette m�thode appelle Model.annuleLeDernierCoup().
     * 
     * @see #annuleLeDernierCoup()
	 * @since     1.0                 
	 */
	public abstract void annuleLeDernierCoup();
	
    /** 
     * Cr�� une nouvelle vue.
     * Cette m�thode appelle Model.addObserver().
     * 
     * @see #nouvelleVue()
	 * @since     1.0                 
	 */
	public abstract void nouvelleVue();			
	
    /** 
     * Ferme une vue.
     * Cette m�thode appelle Model.removeObserver(Observer obs).
     * 
     * @param vue : la vue � supprimer
     * @see #cloreVue(TicTacToeVue vue)
	 * @since     1.0                 
	 */
	public abstract void cloreVue(TicTacToeVue vue); 		
	
	/** 
     * Cette m�thode permet de quitter le jeu.
     * Tout les observateurs sont supprim�s.
     * Cette m�thode appelle Model.fin().
     *
     * @see #fin()
	 * @since     1.0                 
	 */
	public abstract void fin(); 							
	
	/** 
     * Getter du mod�le
     *
     * @return Retourne le mod�le.
     * @see #getModel()
	 * @since     1.0                 
	 */
	public abstract AbstractTicTacToeModel getModel();
}
