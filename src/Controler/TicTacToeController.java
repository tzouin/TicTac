package Controler;

import Model.AbstractTicTacToeModel;
import View.TicTacToeVue;

/**
 * <b>TicTacToeController est la classe abstraite représentant un controleur.</b>
 * <p>
 * Un controleur est caractérisé par les informations suivantes :
 * <ul>
 * <li>Un modèle</li>
 * </ul>
 * </p>
 * <p>
 * Les demandes sont transférés au modèle, afin qu'elles soient traitées.
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
