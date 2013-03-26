/**
 * 
 */
package Tag;

/**
 * This is the tag class. It is built on the TagInterface. In
 * the composite pattern this would be considered the leaf of
 * the pattern. Tag stores the opening and closing tag flags.
 * @author Eric Majchrzak
 *
 */
public class Tag implements TagInterface {
	
	//Tag opening and closing and menu bar name
	String opening;
	String closing;
	String name;
	String type;
	
	/**
	 * This function will take in a tag name and create a tag object
	 * with an opening tag with that name and a closing tag with that
	 * name plus an end tag ("/")
	 * @param String name
	 */
	public Tag(String tagName, String menuName, String myType){
		String temp = "/";
		opening = tagName;
		closing = temp + tagName;
		name = menuName;
		type = myType;
	}

	/* (non-Javadoc)
	 * @see Tag.TagInterface#print()
	 */
	@Override
	public String print() {
		String temp = "<" + opening + ">\n";
		temp =  temp + "<" + closing + ">\n";
		return temp;
	}

	/* (non-Javadoc)
	 * @see Tag.TagInterface#compare(java.lang.String)
	 */
	@Override
	public boolean compare(String toCompare) {
		if(closing.equals(toCompare)){
			return true;
		} else if(opening.equals(toCompare)){
			return true;
		}
		return false;
	}
	
	/**
	 * This is a basic function used to return the opening tag.
	 * @return String (Opening tag)
	 */
	public String getOpening() {
		return "<" + opening + ">\n";
	}
	
	/**
	 * This is a basic function used to return the closing tag.
	 * @return String (Closing tag)
	 */
	public String getClosing() {
		return "<" + closing + ">\n";
	}

	/**
	 * This is the get name function. It will return the name of the tag
	 * for the menu bar to show.
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * Insert tag method used by the menu bar to insert a tag into the text
	 * @return String
	 */
	public String insertTag(){
		return opening + closing + "\n";
	}
	
	/**
	 * Insert tag method used by the menu bar to insert a tag into the text
	 * @return String
	 */
	public boolean isType(String testType){
		return type.equals(testType);
	}
}