
package assets;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BGPanel extends JPanel{
    private Image imagen;

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }
    
    public void paint(Graphics g)
    {
        g.drawImage(imagen, 0, 0, getWidth(),getHeight(),this);
        setOpaque(false);
        super.paint(g);
    }
}
