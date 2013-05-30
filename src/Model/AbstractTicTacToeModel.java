package Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

import language.Lang;

import Controler.TicTacToeController;
import Observable.Observable;
import Observable.Observer;
import View.TicTacToeVue;

/**
 * <b>AbstractTicTacToeModel est la classe abstraite représentant un modèle.</b>
 * <p>
 * Un modèle est caractérisé par les informations suivantes :
 * <ul>
 * <li>Une collection d'observateurs</li>
 * <li>Des données représentant le modèle</li>
 * </ul>
 * </p>
 * <p>
 * Quand le modèle est modifié, il avertit tout ses observateurs afin qu'ils se mettent à jour.
 * </p>
 * 
 * @author Cyril MONSIEUX
 * @version 1.0
 */

public abstract class AbstractTicTacToeModel implements Observable {

	/**Les vues*/
	protected ArrayList<Observer> listObserver = new ArrayList<Observer>();
	
	protected final int CASE_VIDE = 0;
	public final int CASE_JOUEUR1 = 1;
	public final int CASE_JOUEUR2 = 2;

	protected final int partieEnCours = 0 ;
	protected final int victoireJoueur1 = 1 ;
	protected final int victoireJoueur2 = 2 ;
	protected final int matchNul = 3 ;

	protected boolean joueur1 ;
	protected boolean termine ;

	public int plateauDeJeu[][] ;

	/**Résultat de la partie, ex : "Le joueur 1 doit jouer", "Match nul !"*/
	String [] message = 
		{	Lang.getString("JouerJoueur1"),
			Lang.getString("JouerJoueur2"),
			Lang.getString("MatchNul"),
			Lang.getString("VictoireJoueur1"),
			Lang.getString("VictoireJoueur2")
		};
	
	Stack coups ;

	protected int nombreDeVues = 0 ;
	
	/**
	 * (Implicitement appelé par les sous classes)
	 * Construit un nouveau modèle.
	 * Le plateau est de taille 3, et le joueur 1 a le trait.
	 *
	 * @see       #AbstractTicTacToeModel() 
	 * @since     1.0
	 */
	
	protected AbstractTicTacToeModel() {	
		plateauDeJeu = new int[3][3] ;
		termine = false ;
		joueur1 = true ;
		coups = new Stack () ;		
		addObserver();
	}
	
	
	/**
	 * Vérifie le plateau de jeu. Si 3 pions de la même couleur sont sur la même rangée, la même diagonale, ou la même colonne alors la méthode renvoie un entier 
	 * représentant le vainqueur.
	 * <ul>Correspondance entre la valeur retournée et le résultat : 
	 * 		<li><b>1</b> : victoire joueur 1</li>      		
	 * 		<li><b>2</b> : victoire joueur 2 </li>
	 * 		<li><b>3</b> : match nul</li>
	 * </ul>
	 *
	 * @see       #verifie() 
	 * @since     1.0
	 */
	public abstract int verifie();
	
    /** 
     * Effectue, si possible, un nouveau coup à la position (i,j)
     * Cette méthode vérifie d'abord que le coup est valide.
     * Une fois le coup validé, les observateurs sont notifiés.
     *
     * @param i         l'indice de la rangée
     * @param j         l'indice de la colonne
     * 
     * @see #unNouveauCoup(int, int)
	 * @since     1.0                 
	 */
	public abstract void unNouveauCoup(int i, int j);
	
    /** 
     * Effectue, si possible, la suppression du dernier coup.
     * Une fois le coup annulé, les observateurs sont notifiés.
     * 
     * @see #annuleLeDernierCoup()
	 * @since     1.0                 
	 */
	public abstract void annuleLeDernierCoup ();
	
	/** 
     * Cette méthode permet de vider toutes les cases. 
     * Le trait revient au joueur 1.
     *
     * @see #recommence()
	 * @since     1.0                 
	 */
	public abstract void recommence ();
	
	/** 
     * Cette méthode permet de quitter le jeu.
     * Tout les observateurs sont supprimés.
     *
     * @see #fin()
	 * @since     1.0                 
	 */
	public void fin(){
		listObserver.clear();
		System.exit(0);
	}

/*Interface implementation*/
	
	public void addObserver(){
		this.listObserver.add(new TicTacToeVue(new TicTacToeController(this), new Integer(++nombreDeVues).toString()));
		notifyObserver();
	}


	public void removeObserver(Observer obs){
		listObserver.remove(obs);
		if (listObserver.isEmpty()) {fin();}
	}


	public void notifyObserver(){
		int i = 0 ;
		switch (verifie()) {
		case partieEnCours :
			termine = false ; 
			if (joueur1) { i = 0 ; }
			else  { i=1 ; }
			break ;
		case matchNul :
			termine = true ;
			i = 2 ; 
			break ;
		case victoireJoueur1 :
			termine = true ;
			i = 3 ;
			break  ;
		case victoireJoueur2 :
			termine = true ;
			i = 4  ; 
			break ;	    
		}
		Iterator it = listObserver.iterator() ;
		while (it.hasNext()) {
			((TicTacToeVue) it.next()).MiseAJourVue(message[i]) ;
		}
	}

}
