package model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class DirectDrawDemo extends JPanel {

    private BufferedImage canvas;
    private int[][] matrix;
    private int greyscale;

    public DirectDrawDemo(int width, int height, int grey, int[][] matrix) {
        this.matrix = matrix;
        this.greyscale = grey;
        canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        paint_canvas(width, height);
   } 
    
    public void paint_canvas(int width, int height) {
	// TODO Auto-generated method stub 
        int pixel;
        for (int w = 0; w < canvas.getWidth(); w++) {
            for (int h = 0; h < canvas.getHeight(); h++) {    
                
                //pixel = (matrix[w][h] / greyscale) * 255;                
                
                pixel = matrix[w][h];               
                
                if(pixel > greyscale)
                    pixel = greyscale;

                Color grey = new Color(pixel,pixel,pixel);
                
                //canvas.setRGB(y, x, get_RGBcolor(((float) (matrix[x][y]))));//(new Color(pixel ,pixel ,pixel )).getRGB());//((float) (matrix[x][y])));// / Math.pow(2, 5.456548)))); 
                //canvas.setRGB(y, x, (new Color((int)pixel ,(int)pixel ,(int)pixel )).getRGB());//((float) (matrix[x][y])));// / Math.pow(2, 5.456548)))); 
                //canvas.setRGB(y, x, grey.getRGB());//((float) (matrix[x][y])));// / Math.pow(2, 5.456548)))); 
                
                
                canvas.setRGB(h, w, grey.getRGB());
            }
        } 
        
        repaint();
    }


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(canvas.getWidth(), canvas.getHeight());
    }

    @Override
    public void paintComponent(Graphics g) {       
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(canvas, null, null);
    }
}