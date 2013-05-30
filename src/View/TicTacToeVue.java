package View;

import Observable.Observer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;

import language.Lang;


import Controler.AbstractTicTacToeController;

/**
 * <b>TicTacToeVue est la classe repr�sentant graphiquement la vue.</b>
 * <p>La classe impl�mente Observer afin d'�tre notifi� en cas de changement du mod�le.</p>
 * <p>
 * Un mod�le est caract�ris� par les informations suivantes :
 * <ul>
 * <li>Un controleur</li>
 * <li>Des objets graphiques</li>
 * </ul>
 * </p>
 * <p>
 * La vue �coute les changements sur le mod�le. 
 * </p>
 * 
 * @author Cyril MONSIEUX
 * @see Observer
 * @version 1.0
 */
public class TicTacToeVue extends JFrame implements Observer{
	
	private static final long serialVersionUID = 1L;
	
	/**Le controleur permettant d'acc�der au mod�le*/
	public AbstractTicTacToeController controler;
	/**Permet de num�roter les vues*/
	public String numeroVue;
	
	/**La taille de la zone de jeu*/
	int x, y, cote ;
	JLabel statut ;
	/**La zone de jeu*/
	MonCanvas monCanvas ;
	
    /** 
     * Constructeur permettant d'instancier une nouvelle vue.
     * 
     * @param controler : le controler qui permet de relier la vue et le mod�le
     * @param numeroVue : permet de donner un num�ro � la fen�tre
     * 
     * @see #TicTacToeVue(AbstractTicTacToeController, String)
	 * @since     1.0                 
	 */
	public TicTacToeVue(AbstractTicTacToeController controler, String numeroVue) {
		this.controler=controler;
		this.numeroVue=numeroVue;
		x = 40 ; y = 40 ; cote = 40;
		CreateAndShowGui();
	}

	public void MiseAJourVue(String str) {
		repaint() ;
		statut.setText(str);
	}

    /** 
     * Cette m�thode permet de construire l'interface graphique.
     * Elle a �t� s�par�e du constructeur pour s�parer le code.
     * Cette m�thode appelle Model.removeObserver(Observer obs).
     * 
     * @see #CreateAndShowGui()
	 * @since     1.0                 
	 */
	public void CreateAndShowGui() {
		
		JPanel panneau = new JPanel() ;
		panneau.setLayout (new BorderLayout()) ;
		
		JToolBar barreOutils = new JToolBar();
		JButton nouvelleVue = new JButton(Lang.getString("NouvelleVue"));
		barreOutils.add (nouvelleVue) ;
		nouvelleVue.addActionListener(new EcouteurNouvelleVue(controler)) ;
		JButton recommence = new JButton(Lang.getString("NouvellePartie"));
		barreOutils.add (recommence) ;
		recommence.addActionListener(new EcouteurRecommence(controler)) ;	
		JButton annule = new JButton(Lang.getString("AnnulerCoup"));
		barreOutils.add (annule) ;
		annule.addActionListener(new EcouteurAnnule(controler)) ;
		JButton fin = new JButton(Lang.getString("Fin"));
		barreOutils.add (fin) ;
		fin.addActionListener(new EcouteurFin(controler)) ;			
		panneau.add(barreOutils, BorderLayout.NORTH) ;
		
		monCanvas = new MonCanvas(this);
		MonEcouteurSouris monEcouteurSouris = new MonEcouteurSouris(controler,x,y,cote) ;
		monCanvas.addMouseListener (monEcouteurSouris) ;

		JScrollPane carreau = new JScrollPane(monCanvas) ;
				
		panneau.add("Center", carreau) ;
		
		statut = new JLabel (" ") ;
		panneau.add("South", statut) ;

		this.setContentPane(panneau) ;		
	
		addWindowListener (new EcouteurInterface(controler, this)) ;	
		
		this.setTitle("TicTacToe " + numeroVue) ;
		this.pack() ;
		this.show() ;
		
	}
	
	/** 
     * Cette m�thode permet de redessiner le plateau.
     * 
     * @param g
     * @see #CreateAndShowGui()
	 * @since     1.0                 
	 */
	public void redessineLePlateau (Graphics g) {
		int i, j; 		
		for (i = 0; i < 3; i = i + 1) {
		   for (j = 0; j < 3; j = j + 1) {
		       g.setColor (Color.yellow) ;
		       g.fillRect (x + i*cote, y+j*cote, cote, cote) ;
		       g.setColor (Color.black) ;
		       g.drawRect (x + i*cote, y+j*cote, cote, cote) ;
		    }
		 }
		 for (i = 0; i < 3; i = i + 1) {
		   for (j = 0; j < 3; j = j + 1) {
		       if (controler.getModel().plateauDeJeu[i][j] == controler.getModel().CASE_JOUEUR1) {
		          g.setColor (Color.red) ;
		          g.fillOval (x + i*cote + cote/5, y+j*cote+ cote/5, cote*2/3, cote*2/3) ;
		       }
		       else if (controler.getModel().plateauDeJeu[i][j] == controler.getModel().CASE_JOUEUR2) {
		          g.setColor (Color.black) ;
		          g.fillOval (x + i*cote + cote/5, y+j*cote+ cote/5, cote*2/3, cote*2/3) ;
		       }
		    }
		 }	    			
	}
}


