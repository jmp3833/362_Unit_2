/**
 * 
 */
package Tag;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This is the composite tag, it will represent the entire text 
 * document with a composite for the sake of collapsed windows 
 * in the collapsed view.
 * 
 * @author Eric Majchrzak
 *
 */
public class CompositeTag{
	
	ArrayList<CompositeTag> tags;
	String startTag;
	ArrayList<String> normalText;
	String endTag;
	int i; 							//Counter for the composite, helps the previous composite pick up where this one left off
	
	/**
	 * Constructor for the composite tag, this is where almost 
	 * all of the processing work is done. It takes in the text 
	 * (represented by a String) and will go through and find 
	 * every instance of a tag and collapse it.
	 */
	public CompositeTag(String text){
		char[] textArray = text.toCharArray();
		CompositeTag tempTag;
		i = 1;
		String temp = "<";
		
		//loop through first tag
		while(textArray[i] != '>'){
			temp = temp + textArray[i];
			i++;
		}
		
		startTag = temp + '>';
		temp = "";
		i++;
		
		while(true){
			//How to treat regular text
			while(textArray[i] != '<'){
				temp += textArray[i];
				i++;
			}
			
			normalText.add(temp);
			temp = "";
			
			//End of this composite
			if(textArray[i+1] == '/'){
				while(textArray[i] != '>'){
					temp += textArray[i];
					i++;
				}
				endTag = temp + '>';
				i++;
				return;
			//Start of a new composite
			} else {
				char[] toSend = Arrays.copyOfRange(textArray,i,textArray.length);
				tempTag = new CompositeTag(new String(toSend));
				i = i + tempTag.getCount();
				tags.add(tempTag);
			}
		}
	}

	/**
	 * GetCount used in the construction of the composite
	 * @return
	 */
	private int getCount() {
		return i;
	}
	
	/**
	 * This is the iterator that will be used to print sections of the tag
	 * @return
	 */
	public String printNext(){
		return "";
	}
}