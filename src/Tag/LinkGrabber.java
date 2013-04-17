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
public class LinkGrabber {
	
	TagTracer test;
	
	public LinkGrabber(){
		ArrayList<String> aFields = new ArrayList<String>();
		aFields.add("href");
		aFields.add("target");
		aFields.add("types");
		aFields.add("sizes");
		test = new TagTracer(new FieldTag("Link","a",aFields,"Field Tag"));
	}
	
	public ArrayList<Link> search(String text){
		boolean foundHref = false;
		boolean duplicate = false;
		ArrayList<String> theList = test.huntForTags(text);
		ArrayList<Link> tags = new ArrayList<Link>();
		
		for(int i=0;i < theList.size();i++){
			String[] current = theList.get(i).split("\\s");
			
			String tempHREF = " ";
			
			for(int j=0;j < current.length;j++){
				
				//If string found source
				if(current[j].startsWith("href=")){
					tempHREF = current[j].substring(6);
					foundHref = true;
				} else if (foundHref && !current[j].contains("=")){
					tempHREF += " " + current[j];
				} else if (foundHref && current[j].contains("=")){
					foundHref = false;
					j--;
				}
			}
			
			Link tempLinkObject = new Link(tempHREF.substring(0, tempHREF.length()-1));
			for(int k=0;k<tags.size();k++){
				if(tags.get(k).compare(tempHREF.substring(0, tempHREF.length()-1))){
					duplicate = true;
				}
			}
			
			if(!duplicate){
				tags.add(tempLinkObject);
			}
			duplicate = false;
		}
		
		return tags;
	}
}
