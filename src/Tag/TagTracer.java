/**
 * 
 */
package Tag;

import java.util.ArrayList;

/**
 * 
 * This class will take a tag in and search the entire buffer
 * for the associated tags and return them to the user.
 * @author Eric Majchrzak
 *
 */
public class TagTracer {

	TagInterface traceTarget;
	ArrayList<String> foundTags;
	
	/**
	 * Constructor for a tag tracer. Will take in a Tag type to search for.
	 */
	public TagTracer(TagInterface wantedTag){
		traceTarget = wantedTag;
		foundTags = new ArrayList<String>();
	}
	
	/**
	 * Function that will take in the text and return a list of the
	 * tags of that type.
	 * @param text
	 * @return
	 */
	public ArrayList<String> huntForTags(String text){
		foundTags = new ArrayList<String>();
		char[] textArray = text.toCharArray();
		boolean inTag = false;
		String temp = "";
		
		//loop through the text
			for(int i = 0; i<textArray.length;i++){
					
				//If character is the end of a tag
				if(inTag == true && textArray[i] == '>'){
						
					//convert temp into an array to check if end tag
					char[] tempArray = temp.toCharArray();
						
					//If it is an end tag
					if(tempArray[0] != '/'){
						//Check to see if the tag is valid
						if(traceTarget.compare('<' + temp + '>')){
							foundTags.add(temp);
						}
					}
						
					//no longer in a tag
					inTag = false;
					temp = "";
				}
					
				//If in a tag and not end append character to temp
				if(inTag == true && textArray[i] != '>'){
					temp = temp + textArray[i];
				}
					
				//If the character is the start of a tag put us into a tag
				if(inTag == false && textArray[i] == '<'){
					inTag = true;
				}
			}
		return foundTags;
	}
}
