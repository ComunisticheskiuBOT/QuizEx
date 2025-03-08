package ru.desktop_quizEx.desktop_quizEx.styles;

import javax.swing.*;
import java.awt.*;

public class RoundJPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private final int radius;

    public RoundJPanel(int radius) {
        this.radius = radius;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (!isOpaque()) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
            super.paintComponent(g2);
            g2.dispose();
        } else {
            super.paintComponent(g);
        }
    }
}
