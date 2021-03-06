/**
 * 
 */
package Tag;

/**
 * @author Eric Majchrzak
 *
 */
public interface TagInterface {
	
	/**
	 * This function takes in a string to compare against the tag to check and
	 * see if the string is equal to the tag's opening or closing.
	 * @param toCompare(String)
	 * @return boolean
	 */
	boolean compare(String toCompare);
	
	/**
	 * This is a basic function used to return the closing tag.
	 * @return String (Closing tag)
	 */
	String getClosing();
	
	/**
	 * This is a basic function used to return the opening tag.
	 * @return String (Opening tag)
	 */
	String getOpening();
	
	/**
	 * This is the get name function. It will return the name of the tag
	 * for the menu bar to show.
	 */
	String getName();

	/**
	 * This is the method to check what sub-type a string is
	 * 
	 * @param string
	 * @return
	 */
	boolean isType(String string);

	/**
	 * This is the function that a Tag or Collection of tags will use to print
	 * themselves to the html window. Each Tag will print it's opening tag, a
	 * new line, an ending tag and another new line.
	 * @return String
	 */
	String print();

	/**
	 * Checks to see if the tag is a valid end tag
	 * @param temp
	 * @return
	 */
	boolean checkEnd(String temp);

}