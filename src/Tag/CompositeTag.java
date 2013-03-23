/**
 * 
 */
package Tag;

import java.util.ArrayList;

/**
 * This is the composite tag, it stores several tags so that if
 * the user wanted to have a construct that printed several tags
 * at once the program would build a composite to do so.
 * @author Eric Majchrzak
 *
 */
public class CompositeTag implements TagInterface {
	
	ArrayList<TagInterface> tags;
	
	/**
	 * Constructor for the composite tag, just initializes the
	 * ArrayList.
	 */
	public CompositeTag(){
		tags = new ArrayList<TagInterface>();
	}

	/* (non-Javadoc)
	 * @see Tag.TagInterface#print()
	 */
	@Override
	public String print() {
		String temp = "";
		for(int i = 0;i < tags.size(); i++){
			temp = temp + tags.get(i).getOpening();
		}
		for(int i = 0;i < tags.size(); i++){
			temp = temp + tags.get(i).getClosing();
		}
		return temp;
	}

	/* (non-Javadoc)
	 * @see Tag.TagInterface#compare(java.lang.String)
	 */
	@Override
	public boolean compare(String toCompare) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * This function adds a tag to the composite
	 * @param tagToAdd
	 */
	public void addTag(TagInterface tagToAdd){
		tags.add(tagToAdd);
	}

	/**
	 * Prints nothing in the case of the composite because all
	 * closing tags are printed when opening is called.
	 * @return null
	 */
	@Override
	public String getClosing() {
		return null;
	}

	/**
	 * Goes through and prints all of the tags openings and closings
	 * because it is in a composite.
	 */
	@Override
	public String getOpening() {
		return(this.print());
	}

}
