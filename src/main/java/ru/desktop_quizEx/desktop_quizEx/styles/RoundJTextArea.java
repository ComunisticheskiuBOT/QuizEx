package ru.desktop_quizEx.desktop_quizEx.styles;

import javax.swing.*;
import java.awt.*;

public class RoundJTextArea extends JTextArea {
    private static final long serialVersionUID = 1L;
    private final int radius;

    public RoundJTextArea(String text, int radius) {
        super(text);
        this.radius = radius;
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
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

