package ru.desktop_quizEx.desktop_quizEx.ui;

import ru.desktop_quizEx.desktop_quizEx.db.DatabaseManager;
import ru.desktop_quizEx.desktop_quizEx.styles.RoundJButton;
import ru.desktop_quizEx.desktop_quizEx.styles.RoundJPasswordField;
import ru.desktop_quizEx.desktop_quizEx.styles.RoundJTextField;

import javax.swing.*;
import java.awt.*;

public class RoundedLoginScreen extends JFrame {
    /**
	 * Login screen
	 */
	private static final long serialVersionUID = -7015103178509207554L;
	private final RoundJTextField usernameField;
    private final RoundJPasswordField passwordField;
    private final JLabel messageLabel;

    public RoundedLoginScreen() {
        setTitle("Войти");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        usernameField = new RoundJTextField(15);
        passwordField = new RoundJPasswordField(15);
        RoundJButton loginButton = new RoundJButton("Авторизация");
        RoundJButton registerButton = new RoundJButton("Регистрация");
        messageLabel = new JLabel("", SwingConstants.CENTER);

        messageLabel.setFont(new Font("Arial", Font.ITALIC, 12));
        messageLabel.setForeground(Color.RED);

        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (DatabaseManager.authenticate(username, password)) {
                messageLabel.setText("✅ Вход успешен!");
                messageLabel.setForeground(new Color(0, 128, 0));
                openMainMenu();
            } else {
                messageLabel.setText("❌ Неверные данные!");
                messageLabel.setForeground(Color.RED);
            }
        });

        registerButton.addActionListener(e -> {
            new RoundedRegisterScreen(this); // Передаем текущее окно в конструктор регистрации
            setVisible(false); // Скрываем окно авторизации
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(new JLabel("Логин:"), gbc);

        gbc.gridy = 1;
        add(usernameField, gbc);

        gbc.gridy = 2;
        add(new JLabel("Пароль:"), gbc);

        gbc.gridy = 3;
        add(passwordField, gbc);

        gbc.gridy = 4;
        gbc.gridwidth = 1;
        add(registerButton, gbc);

        gbc.gridx = 1;
        add(loginButton, gbc);

        gbc.gridy = 5;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        add(messageLabel, gbc);

        setLocationRelativeTo(null); // Центрируем окно
        setVisible(true);
    }
    private void openMainMenu() {
        JOptionPane.showMessageDialog(this, "Добро пожаловать!");

        MainMenu mainMenu = new MainMenu();
        mainMenu.setVisible(true);
        dispose();
    }

}
