/**
 * 
 */
package Tag;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * This is a class that will represent a tag with multiple fields
 *
 * @author Eric Majchrzak
 *
 */
public class FieldTag implements TagInterface {
	
	String name;
	String tag;
	String endTag;
	String type;
	ArrayList<String> fields;
	ArrayList<String> fieldValues;

	public FieldTag(String myName, String myTag, ArrayList<String> myFields,String myType){
		name = myName;
		tag = myTag;
		endTag = "</" + tag + ">";
		fields = myFields;
		fieldValues = new ArrayList<String>();
		type = myType;
	}
	
	/* (non-Javadoc)
	 * @see Tag.TagInterface#print()
	 */
	@Override
	public String print() {
		String temp = "<" + tag;
		
		for(int i = 0;i<fields.size();i++){
			temp = temp + " " + fields.get(i) + "=\"\"";
		}
		return temp + "><" + endTag + ">\n";
	}

	/* (non-Javadoc)
	 * @see Tag.TagInterface#compare(java.lang.String)
	 */
	@Override
	public boolean compare(String toCompare) {
		
		StringTokenizer st = new StringTokenizer(toCompare);
		
		String help = st.nextToken();
		
		//Check first part to see if it is the right tag
		if(!help.startsWith("<" + tag)){
			System.out.println("test: " + "<" + tag + " Failed: " + help);
			return false;
		}
		
		//Check the fields of the tag
		boolean found = true;
	    while (st.hasMoreTokens() && found) {
	        String temp = st.nextToken();
	        found = false;
	        for(int i = 0;i<fields.size();i++){
	        	if(temp.startsWith(fields.get(i))){
	        		found = true;
	        	}
	        }
	        if(found == false && temp.contains("=")){
	        	return false;
	        }
	    }
		return true;
	}

	/* (non-Javadoc)
	 * @see Tag.TagInterface#getClosing()
	 */
	@Override
	public String getClosing() {
		return "<" + endTag + ">";
	}

	/* (non-Javadoc)
	 * @see Tag.TagInterface#getOpening()
	 */
	@Override
	public String getOpening() {
		// TODO Auto-generated method stub
		return "<" + tag + ">";
	}

	/* (non-Javadoc)
	 * @see Tag.TagInterface#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	@Override
	public boolean isType(String string) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkEnd(String temp) {
		return temp.equals(endTag);
	}

}
