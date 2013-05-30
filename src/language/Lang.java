package language;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * <b>Lang est la classe permettant de changer la langue de l'application.</b>
 * 
 * <p>
 * Pour modifier la langue de l'application, il faut modifier la variable "langue".
 * Les langues prises en charge sont le français (new Locale("fr","FR")) et l'anglais ("en","US").
 * </p>
 * <p>
 * Pour ajouter des mots clés, il faut modifier les fichiers de type properties à la racine du projet.
 * </p>
 * 
 * @author Cyril MONSIEUX
 * @version 1.0
 */
public class Lang {
	
	/**La variable permettant de modifier la langue*/
	public static Locale langue=new Locale("en","US");
	
	
	/** 
     * Retourne la traduction du mot clé.
     * Cette méthode utilise les fichiers "PROPERTIES" présents à la racine du projet.
     *
     * @param cle      Une clé du fichier "MessagesBundle.properties" (ex : NouvellePartie)
     * 
     * @see #getString(String cle)
	 * @since     1.0                 
	 */
	public static String getString(String cle){
		return ResourceBundle.getBundle("MessagesBundle", langue).getString(cle);	
	}
}
