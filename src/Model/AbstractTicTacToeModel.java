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
 * <b>AbstractTicTacToeModel est la classe abstraite repr�sentant un mod�le.</b>
 * <p>
 * Un mod�le est caract�ris� par les informations suivantes :
 * <ul>
 * <li>Une collection d'observateurs</li>
 * <li>Des donn�es repr�sentant le mod�le</li>
 * </ul>
 * </p>
 * <p>
 * Quand le mod�le est modifi�, il avertit tout ses observateurs afin qu'ils se mettent � jour.
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

	/**R�sultat de la partie, ex : "Le joueur 1 doit jouer", "Match nul !"*/
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
	 * (Implicitement appel� par les sous classes)
	 * Construit un nouveau mod�le.
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
	 * V�rifie le plateau de jeu. Si 3 pions de la m�me couleur sont sur la m�me rang�e, la m�me diagonale, ou la m�me colonne alors la m�thode renvoie un entier 
	 * repr�sentant le vainqueur.
	 * <ul>Correspondance entre la valeur retourn�e et le r�sultat : 
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
     * Effectue, si possible, un nouveau coup � la position (i,j)
     * Cette m�thode v�rifie d'abord que le coup est valide.
     * Une fois le coup valid�, les observateurs sont notifi�s.
     *
     * @param i         l'indice de la rang�e
     * @param j         l'indice de la colonne
     * 
     * @see #unNouveauCoup(int, int)
	 * @since     1.0                 
	 */
	public abstract void unNouveauCoup(int i, int j);
	
    /** 
     * Effectue, si possible, la suppression du dernier coup.
     * Une fois le coup annul�, les observateurs sont notifi�s.
     * 
     * @see #annuleLeDernierCoup()
	 * @since     1.0                 
	 */
	public abstract void annuleLeDernierCoup ();
	
	/** 
     * Cette m�thode permet de vider toutes les cases. 
     * Le trait revient au joueur 1.
     *
     * @see #recommence()
	 * @since     1.0                 
	 */
	public abstract void recommence ();
	
	/** 
     * Cette m�thode permet de quitter le jeu.
     * Tout les observateurs sont supprim�s.
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
