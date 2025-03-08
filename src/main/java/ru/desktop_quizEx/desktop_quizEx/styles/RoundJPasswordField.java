package ru.desktop_quizEx.desktop_quizEx.styles;

import javax.swing.*;
import java.awt.*;

public class RoundJPasswordField extends JPasswordField {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int radius;

    public RoundJPasswordField(int radius) {
        super();
        this.radius = radius;
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (!isOpaque()) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setColor(Color.WHITE);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
            g2.setColor(getForeground());
            super.paintComponent(g2);
            g2.dispose();
        } else {
            super.paintComponent(g);
        }
    }
}