package Main;

import java.util.Locale;

import Controler.AbstractTicTacToeController;
import Controler.TicTacToeController;
import Model.AbstractTicTacToeModel;
import Model.TicTacToe;
import language.Lang;

public class TicTacToeLanceur {

	public static void main(String[] args) {
		AbstractTicTacToeModel Modele=new TicTacToe();
		AbstractTicTacToeController Controlleur=new TicTacToeController(Modele);
	}
}
