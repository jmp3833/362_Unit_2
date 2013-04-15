/**
 * @author: Justin Peterson
 * @email: Jmp3833@rit.edu
 * UndoCaretaker.java stores memento objects for the purpose of restoring
 * the active text area if a user selects undo or redo from the edit menu.
 */

package Memento;
import java.util.ArrayList;

public class UndoCaretaker {
	
	ArrayList<Memento> mementos; //stores the mementos
	
	/**
	 * Generates a data structure to hold memento objects 
	 * in the constructor. 
	 */
	public UndoCaretaker(){
		this.mementos = new ArrayList<Memento>(); 
	}
	
	/**
	 * Adds a memento object to the collection of mementos
	 * @param m memento to add
	 */
	public void addMemento(Memento m){
		mementos.add(m);
	}
	
	/**
	 * Gets the most recently added memento off of the ArrayList
	 * @param index the index of the ArrayList with the desired memento
	 * @return the memento object
	 */
    public Memento getMemento(int index){
    		return mementos.get(index);
	}
}
