package Observable;

/**
 * <b>Observable est l'interface qui devra �tre impl�ment� sur le mod�le.
 * Le pattern Observer permet de faire communiquer le mod�le avec les autres objets.</b>
 * <p>
 * Cette interface permet :
 * <ul>
 * 		<li>d'ajouter un observateur</li>
 * 		<li>de supprimer un observateur</li>
 * 		<li>de notifier tout les observateurs</li>
 * </ul>
 * </p>
 * 
 * @author Cyril MONSIEUX
 * @version 1.0
 */
public interface Observable {
	
	/** 
     * Cette m�thode permet d'ajouter un observateur.
     *
     * @see #addObserver() Observer
	 * @since     1.0                 
	 */
	public void addObserver();
	
	/** 
     * Cette m�thode permet de supprimer un observateur.
     * Si il n'y a plus d'observateur, l'application se ferme.
     * 
     * @see #removeObserver(Observer obs) Observer
	 * @since     1.0                 
	 */
	public void removeObserver(Observer obs);
	
	/** 
     * Cette m�thode permet de notifier tout les observateurs.
     * Le status de la partie (Victoire joueur 1, Victoire joueur2, ...) sont transmises aux observateurs.
     * 
     * @see #notifyObserver() Observer
	 * @since     1.0                 
	 */
	public void notifyObserver();
}