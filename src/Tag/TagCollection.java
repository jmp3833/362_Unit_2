/**
 * 
 */
package Tag;

import java.util.ArrayList;
import java.util.Enumeration;
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
	Hashtable<String, TagInterface> tags;
	TagInterface bufferTag;
	
	public TagCollection(){
		
		//Make the new hash table
		tags = new Hashtable<String, TagInterface>();
		
		//Add Emphasis Tags
		tags.put("b",new Tag("b","Bold","Emphasis"));
		tags.put("i",new Tag("i","Italics","Emphasis"));
		tags.put("p",new Tag("p","Paragraph","Emphasis"));
		
		//Add Header tags
		tags.put("header",new Tag("header","Header","Headers"));
		tags.put("h1",new Tag("h1","h1","Headers"));
		tags.put("h2",new Tag("h2","h2","Headers"));
		tags.put("h3",new Tag("h3","h3","Headers"));
		tags.put("h4",new Tag("h4","h4","Headers"));
		tags.put("h5",new Tag("h5","h5","Headers"));
		tags.put("h6",new Tag("h6","h6","Headers"));
		tags.put("html",new Tag("html","html","Headers"));
		
		//Define list Tags
		tags.put("ol",new Tag("ol","Ordered List","Lists"));
		tags.put("ul",new Tag("ul","Unordered list","Lists"));
		tags.put("li",new Tag("li","list item","Lists"));
		tags.put("dl",new Tag("dl","Definition List","Lists"));
		tags.put("dt",new Tag("dt","Definition List Item","Lists"));
		tags.put("dd",new Tag("dd","Definition List Item Description","Lists"));
		
		//Tables
		tags.put("table",new Tag("table","Table","Tables"));
		tags.put("tr",new Tag("tr","Table Row","Tables"));
		tags.put("td",new Tag("td","Table cell","Tables"));
		
		//Image FieldTag
		ArrayList<String> imageFields = new ArrayList<String>();
		imageFields.add("src");
		imageFields.add("alt");
		imageFields.add("height");
		imageFields.add("width");
		tags.put("img",new FieldTag("Image","img",imageFields,"Field Tag"));
		
		//A FieldTag
		ArrayList<String> aFields = new ArrayList<String>();
		aFields.add("href");
		aFields.add("target");
		aFields.add("types");
		aFields.add("sizes");
		tags.put("a",new FieldTag("Link","a",aFields,"Field Tag"));
	}
	
	/**
	 * This is the getNames method used by the menu bar to populate a list of insert
	 * commands for the menu bar. Returns an ArrayList of ArrayLists of Strings wit 
	 * the first String in each array being the category of the tag.
	 * @return ArrayList<ArrayList<String>>
	 */
	public ArrayList<ArrayList<String>> getNames(){
		ArrayList<String> emphasis = new ArrayList<String>();
		emphasis.add("Emphasis");
		ArrayList<String> headers = new ArrayList<String>();
		headers.add("Headers");
		ArrayList<String> lists = new ArrayList<String>();
		lists.add("Lists");
		ArrayList<String> tables = new ArrayList<String>();
		tables.add("Tables");
		ArrayList<String> fieldTags = new ArrayList<String>();
		fieldTags.add("Field Tags");
		
		ArrayList<ArrayList<String>> names = new ArrayList<ArrayList<String>>();
		
		//Sort by type
		for(Enumeration<TagInterface> temp = tags.elements(); temp.hasMoreElements();){
			TagInterface thisTag = temp.nextElement();
			if(thisTag.isType("Emphasis")){
				emphasis.add(thisTag.getName());
			} else if(thisTag.isType("Headers")){
				headers.add(thisTag.getName());
			} else if(thisTag.isType("Lists")){
				lists.add(thisTag.getName());
			} else if(thisTag.isType("Tables")){
				tables.add(thisTag.getName());
			} else if(thisTag.isType("Field Tag")){
				fieldTags.add(thisTag.getName());
			}
		}
		names.add(emphasis);
		names.add(headers);
		names.add(lists);
		names.add(tables);
		names.add(fieldTags);
		return names;
	}
	
	/**
	 * This is the get tag function. This function will get a tag from the hash
	 * and return the text to be inserted
	 * @return String
	 */
	public String getTag(String tagName){
		for (Enumeration<TagInterface> temp = tags.elements(); temp.hasMoreElements();){
			TagInterface current = temp.nextElement();
			if(current.getName() == tagName){
				return current.print();
			}
		}
		return null;	
	}

	/**
	 * This is the checkTag function. It will take text in and see if it is a valid
	 * tag in the tag collection.
	 * @return boolean
	 */
	public boolean checkTag(String tagToCheck){
		for (TagInterface current : tags.values()) {
			if(current.compare(tagToCheck)){
				bufferTag = current;
				return true;
			}
		}
		return false;
	}
	
	/**
	 * This is the make table function. It will make a table for the user to insert into the html window.
	 * It takes in the number of rows, columns and the tag size. It will return a string representation of
	 * the table in html.
	 * @return String
	 */
	public String makeTable(int rows, int columns, int tabLength){
		return new Table(rows,columns,tabLength).print();
	}
	
	/**
	 * Returns the buffered tag for the stack to use in the buffer
	 * @return
	 */
	public TagInterface getBufferedTag(){
		return bufferTag;
	}
}