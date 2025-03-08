package ru.desktop_quizEx.desktop_quizEx;

import ru.desktop_quizEx.desktop_quizEx.ui.RoundedLoginScreen;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(RoundedLoginScreen::new);
    }
}