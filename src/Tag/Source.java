/**
 * 
 */
package Tag;

/**
 * @author Eric Majchrzak
 *
 */
public class Source {
	
	String source;
	String alt;
	
	public Source(String theSource, String theAlt){
		source = theSource;
		alt = theAlt;
	}
	
	public String getSource(){
		return source;
	}
	
	public String getAlt(){
		return alt;
	}

}
