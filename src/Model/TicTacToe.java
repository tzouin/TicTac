package Model;

import java.awt.Point;

/**
 * <b>TicTacToe est la classe représentant l'implémentation du modèle.
 * Elle implémente implicitement le pattern Observer</b>
 * <p>
 * La classe permet d'implementer les méthodes abstraites.
 * </p>
 * 
 * @author Cyril MONSIEUX
 * @see AbstractTicTacToeModel
 * @version 1.0
 */

public class TicTacToe extends AbstractTicTacToeModel {

	public TicTacToe(){
		super();
	}

	public int verifie() {
		if ((plateauDeJeu[0][0]==CASE_JOUEUR1) && (plateauDeJeu[0][1]==CASE_JOUEUR1) && (plateauDeJeu[0][2]==CASE_JOUEUR1)) { return victoireJoueur1 ; }
		if ((plateauDeJeu[1][0]==CASE_JOUEUR1) && (plateauDeJeu[1][1]==CASE_JOUEUR1) && (plateauDeJeu[1][2]==CASE_JOUEUR1)) { return victoireJoueur1 ; }
		if ((plateauDeJeu[2][0]==CASE_JOUEUR1) && (plateauDeJeu[2][1]==CASE_JOUEUR1) && (plateauDeJeu[2][2]==CASE_JOUEUR1)) { return victoireJoueur1 ; }
		if ((plateauDeJeu[0][0]==CASE_JOUEUR1) && (plateauDeJeu[1][0]==CASE_JOUEUR1) && (plateauDeJeu[2][0]==CASE_JOUEUR1)) { return victoireJoueur1 ; }
		if ((plateauDeJeu[0][1]==CASE_JOUEUR1) && (plateauDeJeu[1][1]==CASE_JOUEUR1) && (plateauDeJeu[2][1]==CASE_JOUEUR1)) { return victoireJoueur1 ; }
		if ((plateauDeJeu[0][2]==CASE_JOUEUR1) && (plateauDeJeu[1][2]==CASE_JOUEUR1) && (plateauDeJeu[2][2]==CASE_JOUEUR1)) { return victoireJoueur1 ; }

		if ((plateauDeJeu[0][0]==CASE_JOUEUR2) && (plateauDeJeu[0][1]==CASE_JOUEUR2) && (plateauDeJeu[0][2]==CASE_JOUEUR2)) { return victoireJoueur2 ; }
		if ((plateauDeJeu[1][0]==CASE_JOUEUR2) && (plateauDeJeu[1][1]==2) && (plateauDeJeu[1][2]==2)) { return victoireJoueur2 ; }
		if ((plateauDeJeu[2][0]==CASE_JOUEUR2) && (plateauDeJeu[2][1]==2) && (plateauDeJeu[2][2]==2)) { return victoireJoueur2 ; }
		if ((plateauDeJeu[0][0]==CASE_JOUEUR2) && (plateauDeJeu[1][0]==2) && (plateauDeJeu[2][0]==2)) { return victoireJoueur2 ; }
		if ((plateauDeJeu[0][1]==CASE_JOUEUR2) && (plateauDeJeu[1][1]==2) && (plateauDeJeu[2][1]==2)) { return victoireJoueur2 ; }
		if ((plateauDeJeu[0][2]==CASE_JOUEUR2) && (plateauDeJeu[1][2]==2) && (plateauDeJeu[2][2]==2)) { return victoireJoueur2 ; }

		if ((plateauDeJeu[0][0]==CASE_JOUEUR2) && (plateauDeJeu[1][1]==CASE_JOUEUR2) && (plateauDeJeu[2][2]==CASE_JOUEUR2)) { return victoireJoueur2 ; }
		if ((plateauDeJeu[2][0]==CASE_JOUEUR2) && (plateauDeJeu[1][1]==CASE_JOUEUR2) && (plateauDeJeu[0][2]==CASE_JOUEUR2)) { return victoireJoueur2 ; }

		if ((plateauDeJeu[0][0]==CASE_JOUEUR1) && (plateauDeJeu[1][1]==CASE_JOUEUR1) && (plateauDeJeu[2][2]==1)) { return victoireJoueur1 ; }
		if ((plateauDeJeu[2][0]==CASE_JOUEUR1) && (plateauDeJeu[1][1]==CASE_JOUEUR1) && (plateauDeJeu[0][2]==1)) { return victoireJoueur1 ; }

		for (int i = 0; i < 3; i += 1) {
			for (int j = 0; j < 3; j += 1) {
				if (plateauDeJeu[i][j] == CASE_VIDE) { return partieEnCours ; }
			}
		}

		return matchNul ;
	}

	public void unNouveauCoup(int i, int j) {
		if (!termine) {
			if (plateauDeJeu[i][j] == CASE_VIDE) {
				if (joueur1) {
					plateauDeJeu[i][j]= CASE_JOUEUR1 ;
					joueur1 = false ; 
				}
				else {
					plateauDeJeu[i][j]= CASE_JOUEUR2 ;
					joueur1 = true ;
				} 
				coups.push(new Point(i,j)) ;
				notifyObserver() ;
			}
		}
	}

	public void annuleLeDernierCoup() {
		if (!coups.empty()) {
			Point p = (Point) coups.pop () ;
			plateauDeJeu[p.x][p.y] = CASE_VIDE ;
			if (joueur1) {joueur1 = false ; }
			else { joueur1 = true ; }
		}
		notifyObserver() ;
	}

	
	public void recommence() {
		int i, j ;
		for (i = 0; i < 3; i = i + 1) {
			for (j = 0; j < 3; j = j + 1) {
				plateauDeJeu[i][j] = CASE_VIDE ;
			}
		}
		termine = false ;
		joueur1 = true ;
		while (!coups.empty()) {
			coups.pop () ;
		}
		notifyObserver();
		
	}

}
