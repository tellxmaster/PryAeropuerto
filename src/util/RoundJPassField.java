
package util;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

public class RoundJPassField extends JPasswordField {

    private static final long serialVersionUID = 1L;
    private Color backgroundColor = Color.WHITE;

    public RoundJPassField() {
        setBackground(new Color(255, 255, 255, 0));
        setOpaque(false); // As suggested by @AVD in comment.
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setFont(new Font("Roboto", Font.PLAIN, 14));
        setSelectionColor(new Color(0, 173, 181, 100));
        setLayout(new BorderLayout());
        setEchoChar('•');
        add(chek, BorderLayout.EAST);
        chek.setIcon(new ImageIcon(getClass().getResource("/img/oculto-icon.png")));
        chek.setFocusable(false);
        chek.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                if (chek.isSelected()) {
                    chek.setIcon(new ImageIcon(getClass().getResource("/img/visible-icon.png")));
                } else {
                    chek.setIcon(new ImageIcon(getClass().getResource("/img/oculto-icon.png")));
                }
                chek.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                if (chek.isSelected()) {
                    chek.setIcon(new ImageIcon(getClass().getResource("/img/visible-icon.png")));
                } else {
                    chek.setIcon(new ImageIcon(getClass().getResource("/img/oculto-icon.png")));
                }
                chek.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        chek.addActionListener(
                (ActionEvent e) -> {
                    if (chek.isSelected()) {
                        chek.setIcon(new ImageIcon(getClass().getResource("/img/visible-icon.png")));
                    } else {
                        chek.setIcon(new ImageIcon(getClass().getResource("/img/oculto-icon.png")));
                    }

                    if (chek.isSelected()) {
                        setEchoChar((char) 0);
                        requestFocus();
                    } else {
                        setEchoChar('•');
                    }
                }
        );
    }

    @Override
    protected void paintComponent(Graphics g) {
        int width = getWidth();
        int height = getHeight();
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.setColor(backgroundColor);
        g2.fillRoundRect(0, 0, width, height, height, height);

        super.paintComponent(g);
    }

    private final Dimension d = new Dimension(250, 28);
    private final JCheckBox chek = new JCheckBox();
}

