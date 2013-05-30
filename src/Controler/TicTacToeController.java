package Controler;

import Model.AbstractTicTacToeModel;
import View.TicTacToeVue;

/**
 * <b>TicTacToeController est la classe abstraite repr�sentant un controleur.</b>
 * <p>
 * Un controleur est caract�ris� par les informations suivantes :
 * <ul>
 * <li>Un mod�le</li>
 * </ul>
 * </p>
 * <p>
 * Les demandes sont transf�r�s au mod�le, afin qu'elles soient trait�es.
 * </p>
 * 
 * @author Cyril MONSIEUX
 * @see AbstractTicTacToeController
 * @version 1.0
 */
public class TicTacToeController extends AbstractTicTacToeController{
	
	public TicTacToeController(AbstractTicTacToeModel Model){
		super(Model);
	}

	
	public void unNouveauCoup(int i, int j) {
		Model.unNouveauCoup(i, j);
	}

	
	public void recommence() {
		Model.recommence();
	}

	public void annuleLeDernierCoup() {
		Model.annuleLeDernierCoup();
		
	}

	@Override
	public void nouvelleVue() {
		Model.addObserver();	
	}

	@Override
	public void cloreVue(TicTacToeVue vue) {
		Model.removeObserver(vue);
	}

	@Override
	public void fin() {
		Model.fin();		
	}
	
	public AbstractTicTacToeModel getModel(){
		return Model;
	}
}
