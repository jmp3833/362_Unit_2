/**
 * @author: Alex Bogart
 * Display an image from a filename in a popup window.
 */

package Views;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;


public class ImagePanel extends JFrame{
	
	/**
	 * construct a popup window with the image displayed
	 * @param filename
	 */
	public ImagePanel(String filename) {              
		  
		//sort by occurance/place    
        BufferedImage image = null;
        try
        {
        	
			image = ImageIO.read(new File(filename)); 
			ImageIcon ii = new ImageIcon(image);
	        JLabel l = new JLabel();
	        l.setIcon(ii);
	        add(l);
	        
        	
        } catch (Exception e){
        	JTextPane tp = new JTextPane();
        	tp.setText("Sorry, no image found.");
        	add(tp);
        }
        pack();
        setVisible(true);
      }
}
		  


