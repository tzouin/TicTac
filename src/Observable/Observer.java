package Observable;
/**
 * <b>Observer est l'interface qui devra �tre impl�ment� chez les observateurs.
 * Les objets qui sont ajout�s comme observateur devront impl�menter cette interface.</b>
 * <p>
 * Cette interface permet :
 * <ul>
 * 		<li>de mettre � jour la vue</li>
 * </ul>
 * </p>
 * 
 * @author Cyril MONSIEUX
 * @version 1.0
 */
public interface Observer {
	
	/** 
     * Cette m�thode permet de mettre � jour les vues.
     *
     *@param str : le status de la partie ("Victoire joueur 1", "Match nul !", "Trait au joueur 1", ...)
     * @see #MiseAJourVue(String str) 
	 * @since     1.0                 
	 */
	public void MiseAJourVue(String str);
}