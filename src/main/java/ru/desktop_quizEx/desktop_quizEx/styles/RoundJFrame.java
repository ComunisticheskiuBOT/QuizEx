package ru.desktop_quizEx.desktop_quizEx.styles;

import javax.swing.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;

public class RoundJFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    private final int radius;
    private final RoundJButton closeButton;
    private final RoundJButton minimizeButton;
    private int mouseX, mouseY;
    
    public RoundJFrame(String text, int radius) {
    	super(text);
        this.radius = radius;
        setUndecorated(true);
        setSize(500, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        // Кнопка закрытия
        closeButton = new RoundJButton("x");
        styleButton(closeButton, Color.RED);
        closeButton.addActionListener(e -> System.exit(0));

        // Кнопка сворачивания
        minimizeButton = new RoundJButton("-");
        styleButton(minimizeButton, Color.GRAY);
        minimizeButton.addActionListener(e -> setState(RoundJFrame.ICONIFIED));

        add(closeButton);
        add(minimizeButton);

        // Обработчик изменения размеров окна
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                updateComponents();
            }

            @Override
            public void componentShown(ComponentEvent e) {
                updateComponents();
            }
        });

        // Перемещение окна мышкой
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                setLocation(e.getXOnScreen() - mouseX, e.getYOnScreen() - mouseY);
            }
        });

        // Первоначальное обновление
        SwingUtilities.invokeLater(this::updateComponents);
    }

    private void styleButton(JButton button, Color color) {
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setOpaque(true);
        button.setBackground(color);
        button.setForeground(Color.WHITE);
    }

    private void updateComponents() {
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), radius, radius));

        int padding = 5;
        int buttonSize = 15;

        closeButton.setBounds(getWidth() - buttonSize - padding, padding, buttonSize, buttonSize);
        minimizeButton.setBounds(getWidth() - 2 * buttonSize - 2 * padding, padding, buttonSize, buttonSize);

        setComponentZOrder(closeButton, 0);
        setComponentZOrder(minimizeButton, 1);
    }
}
