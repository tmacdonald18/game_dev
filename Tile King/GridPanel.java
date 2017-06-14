package tileKing;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GridPanel extends JPanel {

	private int width;
	private int height;
	
	public GridPanel(int width, int height) 
	/*
	 * This is the constructor, needed to get the width and height arguments
	 */
	{
		width = this.width;
		height = this.height;
	}
	
    @Override
    public void paintComponent(Graphics g) 
    /*
     * Paint override so that I can draw the lines
     */
    {
        super.paintComponent(g);

        drawGrid(g, width, height);
    }

    private void drawGrid(Graphics g, int columns, int rows) 
    /*
     * Precondition: Show grid is true
     * Postcondition: Grid is drawn according to the chosen width and height
     */
    {
    	rows = 10;
    	columns = 10;
    	
    	Dimension size = getSize();
        int w = (int) size.getWidth();
        int h = (int) size.getHeight();
        int i;
        
        Graphics2D g2d = (Graphics2D) g;
    	
        int heightOfRow = (int) (h / rows);
        for (i = 0; i < rows; i++)
    		g2d.drawLine(0, i * heightOfRow, (int) w, i * heightOfRow);
		
        int widthOfRow = (int) (w / columns);
        for (i = 0; i < columns; i++)
        	g2d.drawLine(i * widthOfRow, 0, i * widthOfRow, (int) h);
    }
    
    @SuppressWarnings("unused")
	private void establishGrid(int width, int height)
    /*
     * This function should be part of the constructor and
     * should create tile objects over the canvas
     */
    {
    	//TODO
    }
 
}