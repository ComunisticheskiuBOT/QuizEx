package ru.desktop_quizEx.desktop_quizEx.styles;

import javax.swing.*;
import java.awt.*;

public class RoundJButton extends JButton {
    /**
	 * Style of Button
	 */
	private static final long serialVersionUID = 2473536501600511565L;
	private int radius = 15;
    public RoundJButton(String text) {
        super(text);
        setOpaque(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
    }

	@Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(new Color(0, 122, 255));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        g2.setColor(Color.WHITE);
        g2.setFont(getFont());
        FontMetrics fm = g2.getFontMetrics();
        int x = (getWidth() - fm.stringWidth(getText())) / 2;
        int y = (getHeight() + fm.getAscent()) / 2 - 2;
        g2.drawString(getText(), x, y);
        g2.dispose();
    }
}