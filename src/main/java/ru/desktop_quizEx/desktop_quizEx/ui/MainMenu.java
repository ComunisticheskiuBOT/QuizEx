package ru.desktop_quizEx.desktop_quizEx.ui;

import javax.swing.*;

public class MainMenu extends JFrame {
    /**
	 * Menu of application
	 */
	private static final long serialVersionUID = 2835048167582148112L;

	public MainMenu() {
        setTitle("Главное меню");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JButton levelSelectButton = new JButton("Карта уровней");
        JButton achievementsButton = new JButton("Достижения");
        JButton exitButton = new JButton("Выход");

        exitButton.addActionListener(e -> System.exit(0));

        add(levelSelectButton);
        add(achievementsButton);
        add(exitButton);

        setVisible(true);
    }
}
