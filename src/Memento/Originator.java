/**
 * @author: Justin Peterson
 * @email: Jmp3833@rit.edu
 * Originator.java creates mementos when invoked by any command
 * of the Command interface.
 */


package Memento;

public class Originator {
	
	String article;
	  
	/**
	* Replaces the active text window's text with the new updated version
	* @param newArticle new text that should be int he window.
	*/
	public void set(String newArticle){
		article = newArticle;
	}
		  
	/**
	 * Stores the new information in a Memento object
	 * @return the newly created memento object
	 */
	 public Memento store(){
		 return new Memento(article);
	 }
	  
	/**
	 * Restores the current state of the active window through a memento.
	 * @return The previous text stored in the active window.
	 */
	public String restore(Memento memento){
		article = memento.getSavedArticle();
		return article;
	}
 }
