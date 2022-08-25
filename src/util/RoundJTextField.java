package util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class RoundJTextField extends JTextField {
	private static final long serialVersionUID = 1L;
	private Color backgroundColor = Color.WHITE;
    public RoundJTextField() {
    	setBackground(new Color(255,255,255,0));
        setOpaque(false); // As suggested by @AVD in comment.
        setBorder(new EmptyBorder(5,10,5,50)); 
        setFont(new Font("Roboto", Font.PLAIN, 14));
        setSelectionColor(new Color(0, 173, 181 ,100));
        
    }
    
    @Override
    protected void paintComponent(Graphics g) {
    	int width = getWidth();
    	int height = getHeight();
    	Graphics2D g2= (Graphics2D) g;
    	g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    	g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    	g2.setColor(backgroundColor);
    	g2.fillRoundRect(0, 0, width, height, height, height);
    	super.paintComponent(g);
    }
}