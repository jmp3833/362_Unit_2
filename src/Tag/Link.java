/**
 * 
 */
package Tag;

/**
 * @author Eric
 *
 */
public class Link {
	
	String link;
	int occurences;
	
	public Link(String thisLink){
		link = thisLink;
		occurences = 1;
	}

	public boolean compare(String newLink) {
		System.out.println(newLink);
		if(link.equals(newLink)){
			occurences++;
			return true;
		}
		return false;
	}
	
	public String getLink(){
		return link;
	}
	
	public int getNumber(){
		return occurences;
	}

}
