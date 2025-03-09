package ru.desktop_quizEx.desktop_quizEx.ui;

import javax.swing.*;
import java.awt.*;

import ru.desktop_quizEx.desktop_quizEx.db.DatabaseManager;
import ru.desktop_quizEx.desktop_quizEx.styles.RoundJButton;
import ru.desktop_quizEx.desktop_quizEx.styles.RoundJPasswordField;
import ru.desktop_quizEx.desktop_quizEx.styles.RoundJTextField;

public class RoundedRegisterScreen extends JFrame {
    /**
	 *  Register Screen
	 */
	private static final long serialVersionUID = -5431221371915202006L;
	private final RoundJTextField usernameField;
    private final RoundJPasswordField passwordField;
    private final JLabel messageLabel;

    public RoundedRegisterScreen(JFrame loginScreen) {
        setTitle("Регистрация");
        setSize(350, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        usernameField = new RoundJTextField(15);
        passwordField = new RoundJPasswordField(15);
        RoundJButton registerButton = new RoundJButton("Зарегистрироваться");
        RoundJButton backButton = new RoundJButton("Назад");
        messageLabel = new JLabel("", SwingConstants.CENTER);

        messageLabel.setFont(new Font("Arial", Font.ITALIC, 12));
        messageLabel.setForeground(Color.RED);

        registerButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (DatabaseManager.addUser(username, password)) {
                messageLabel.setText("✅ Регистрация успешна!");
                messageLabel.setForeground(new Color(0, 128, 0));

                dispose();
                loginScreen.setVisible(true);
            } else {
                messageLabel.setText("❌ Ошибка! Возможно, логин или почта заняты.");
                messageLabel.setForeground(Color.RED);
            }
        });

        backButton.addActionListener(e -> {
            dispose();
            loginScreen.setVisible(true);
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
        add(backButton, gbc);

        gbc.gridx = 1;
        add(registerButton, gbc);

        gbc.gridy = 5;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        add(messageLabel, gbc);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
