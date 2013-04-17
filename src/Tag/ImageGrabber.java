/**
 * 
 */
package Tag;

import java.util.ArrayList;

/**
 * This is the class that will utilize TagTracer to grab images
 * @author Eric Majchrzak
 *
 */
public class ImageGrabber {
	
	TagTracer test;
	
	public ImageGrabber(){
		ArrayList<String> imageFields = new ArrayList<String>();
		imageFields.add("src");
		imageFields.add("alt");
		imageFields.add("height");
		imageFields.add("width");
		test = new TagTracer(new FieldTag("Image","img",imageFields,"Field Tag"));
	}
	
	public ArrayList<Source> search(String text){
		String tempSource = " ";
		boolean foundSource = false;
		String tempAlt = " ";
		boolean foundAlt = false;
		ArrayList<String> theList = test.huntForTags(text);
		ArrayList<Source> tags = new ArrayList<Source>();
		
		for(int i=0;i < theList.size();i++){
			String[] current = theList.get(i).split("\\s");
			
			for(int j=0;j < current.length;j++){
				
				//If string found source
				if(current[j].startsWith("src=")){
					tempSource = current[j].substring(5);
					foundSource = true;
				} else if (foundSource && !current[j].contains("=")){
					tempSource += " " + current[j];
				} else if (foundSource && current[j].contains("=")){
					foundSource = false;
					j--;
				} else if(current[j].startsWith("alt=")){
					tempAlt = current[j].substring(5);
					foundAlt = true;
				} else if (foundAlt && !current[j].contains("=")){
					tempAlt += " " + current[j];
				} else if (foundAlt && current[j].contains("=")){
					foundAlt = false;
					j--;
				}
			}
			
			Source tempSourceObject = new Source(tempSource.substring(0, tempSource.length()-1),tempAlt.substring(0, tempAlt.length()-1));
			tags.add(tempSourceObject);
		}
		
		return tags;
	}
}
