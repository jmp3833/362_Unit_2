/**
 * @author: Justin Peterson
 * @email: Jmp3833@rit.edu
 * Memento.java
 */


package Memento;

public class Memento {
	
	String article;
	
	/**
	 * Generates the active window's text for restoration.
	 * @param article the string in the active text window
	 */
	public Memento(String article){
		this.article = article;
	}
	
	/**
	 * Gets the saved value to be changed with undo/redo use.
	 * @return the string article
	 */
	public String getSavedArticle(){
		return article;
	}
}
