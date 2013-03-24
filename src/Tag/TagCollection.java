/**
 * 
 */
package Tag;

import java.util.Hashtable;

/**
 * This is the collection of Tag types that will be created at runtime
 * and passed to the programs that need to print new tags or validate
 * existing ones. The tags are all stored in a hash with their names
 * as their keys.
 * @author Eric Majchrzak
 *
 */
public class TagCollection {
	
	//This is the table that will store all of the tags
	Hashtable<String, Tag> tags;
	
	public TagCollection(){
		
		//Make the new hashtable
		tags = new Hashtable<String, Tag>();
		
		//Add Emphasis Tags
		tags.put("Bold",new Tag("b"));
		tags.put("Italics",new Tag("i"));
		
		//Add Header tags
		tags.put("Header",new Tag("header"));
		tags.put("h1",new Tag("h1"));
		tags.put("h2",new Tag("h2"));
		tags.put("h3",new Tag("h3"));
		tags.put("h4",new Tag("h4"));
		tags.put("h5",new Tag("h5"));
		tags.put("h6",new Tag("h6"));
		
		//Define list Tags
		tags.put("Ordered List",new Tag("ol"));
		tags.put("Unordered List",new Tag("ul"));
		tags.put("List Item",new Tag("li"));
		tags.put("Defenition List",new Tag("dl"));
		tags.put("Defenition List Item",new Tag("dt"));
		tags.put("Defenition List Item Description",new Tag("dd"));
		
		//Tables
		tags.put("Table",new Tag("table"));
		tags.put("Table Row",new Tag("tr"));
		tags.put("Table Cell",new Tag("td"));
	}

}
