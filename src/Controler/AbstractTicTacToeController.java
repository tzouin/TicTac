package Controler;

import Model.AbstractTicTacToeModel;
import Observable.Observer;
import View.TicTacToeVue;

/**
 * <b>AbstractTicTacToeController est la classe abstraite représentant un controleur.</b>
 * <p>
 * Un controleur est caractérisé par les informations suivantes :
 * <ul>
 * <li>Un modèle</li>
 * </ul>
 * </p>
 * <p>
 * Lorsqu'une modification sera effectuée sur la vue, c'est le controleur qui sera averti. 
 * Puis le controleur informera le modèle des demandes de changements.
 * </p>
 * 
 * @author Cyril MONSIEUX
 * @version 1.0
 */
public abstract class AbstractTicTacToeController {
	/**Le modèle*/
	protected AbstractTicTacToeModel Model;
	
	/**
	 * (Implicitement appelé par les sous classes)
	 * Construit un nouveau controleur.
	 *
	 *@param Model : le modèle 
	 * @see       #AbstractTicTacToeController(AbstractTicTacToeModel Model) 
	 * @since     1.0
	 */
	public AbstractTicTacToeController(AbstractTicTacToeModel Model){
		this.Model=Model;
	}
		
    /** 
     * Effectue, si possible, un nouveau coup à la position (i,j)
     * Cette méthode appelle Model.unNouveauCoup(int i, int j).
     *
     * @param i         l'indice de la rangée
     * @param j         l'indice de la colonne
     * 
     * @see #unNouveauCoup(int, int)
	 * @since     1.0                 
	 */
	public abstract void unNouveauCoup(int i, int j);
	
	/** 
     * Cette méthode permet de vider toutes les cases. 
     * Cette méthode appelle Model.unNouveauCoup(int i, int j).
     *
     * @see #recommence()
	 * @since     1.0                 
	 */
	public abstract void recommence();
	
    /** 
     * Effectue, si possible, la suppression du dernier coup.
     * Cette méthode appelle Model.annuleLeDernierCoup().
     * 
     * @see #annuleLeDernierCoup()
	 * @since     1.0                 
	 */
	public abstract void annuleLeDernierCoup();
	
    /** 
     * Créé une nouvelle vue.
     * Cette méthode appelle Model.addObserver().
     * 
     * @see #nouvelleVue()
	 * @since     1.0                 
	 */
	public abstract void nouvelleVue();			
	
    /** 
     * Ferme une vue.
     * Cette méthode appelle Model.removeObserver(Observer obs).
     * 
     * @param vue : la vue à supprimer
     * @see #cloreVue(TicTacToeVue vue)
	 * @since     1.0                 
	 */
	public abstract void cloreVue(TicTacToeVue vue); 		
	
	/** 
     * Cette méthode permet de quitter le jeu.
     * Tout les observateurs sont supprimés.
     * Cette méthode appelle Model.fin().
     *
     * @see #fin()
	 * @since     1.0                 
	 */
	public abstract void fin(); 							
	
	/** 
     * Getter du modèle
     *
     * @return Retourne le modèle.
     * @see #getModel()
	 * @since     1.0                 
	 */
	public abstract AbstractTicTacToeModel getModel();
}
