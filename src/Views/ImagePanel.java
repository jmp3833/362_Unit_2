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
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;


public class ImagePanel extends JFrame{
	
	public ImagePanel(final ArrayList<String> filenames) {              
		  
		//sort by occurance/place    
        BufferedImage image = null;
        try
        {
        	for (String filename : filenames) { 
        		image = ImageIO.read(new File(filename)); 
        		ImageIcon ii = new ImageIcon(image);
		        JLabel l = new JLabel();
		        l.setIcon(ii);
		        getContentPane().add(l);
        	}
        } catch (Exception e){}
        pack();
        setVisible(true);
      }
}
		  


