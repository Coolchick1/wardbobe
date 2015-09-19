package mywardrobeprogram.ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
/**
 * Helper class to display image in background panel
 * 
 * @author Natalia
 */
public class ImagePanel extends JPanel {

  private Image img;
/**
 * Constructor
 * 
 * @param img path to image to display 
 */
  public ImagePanel(String img) {
    this(new ImageIcon(img).getImage());
  }
/**
 * Constructor 
 * 
 * @param img image to display 
 */
  public ImagePanel(Image img) {
    this.img = img;
    Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
    setPreferredSize(size);
    setMinimumSize(size);
    setMaximumSize(size);
    setSize(size);
    setLayout(null);
  }
/**
 * Paint UI component 
 * 
 * @param g graphics component to draw on  
 */
  @Override
  public void paintComponent(Graphics g) {
    g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
  }

}