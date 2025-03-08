package ru.desktop_quizEx.desktop_quizEx.ui;

import javax.swing.*;

import ru.desktop_quizEx.desktop_quizEx.styles.RoundJButton;
import ru.desktop_quizEx.desktop_quizEx.styles.RoundJFrame;
import ru.desktop_quizEx.desktop_quizEx.styles.RoundJTextArea;

import java.awt.*;

public class QuastionWindow {
	
    public static void main(String[] args) {
        SwingUtilities.invokeLater(QuastionWindow::QuastionWindow);
    }
    
    private static void QuastionWindow() {
        RoundJFrame frame = new RoundJFrame("QuizEx",15);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 300);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new CardLayout());

        JPanel binaryQuestionPanel = createBinaryQuestionPanel();
        JPanel multipleChoicePanel = createMultipleChoiceQuestionPanel();

        frame.add(binaryQuestionPanel, "Binary");
        frame.add(multipleChoicePanel, "MultipleChoice");

        frame.setVisible(true);
    }

    private static JPanel createBinaryQuestionPanel() {
        JPanel panel = new JPanel(null);
        
        JLabel questionLabel = new JLabel("Вопрос ?:");
        questionLabel.setBounds(20, 20, 100, 30);
        panel.add(questionLabel);

        RoundJTextArea questionText = new RoundJTextArea("Текст вопроса...", 15);
        questionText.setBounds(150, 20, 400, 100);
        panel.add(questionText);
        
        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 5, 5));
        buttonPanel.setBounds(20, 70, 120, 100);
        RoundJButton[] answerButtons = new RoundJButton[2];
        for (int i = 0; i < 2; i++) {
            answerButtons[i] = new RoundJButton("Вариант " + (i + 1));
            buttonPanel.add(answerButtons[i]);
        }
        panel.add(buttonPanel);
        
        addHiddenButtons(panel);

        return panel;
    }

    private static JPanel createMultipleChoiceQuestionPanel() {
        JPanel panel = new JPanel(null);

        JLabel questionLabel = new JLabel("Вопрос N:");
        questionLabel.setBounds(20, 20, 100, 30);
        panel.add(questionLabel);

        RoundJTextArea questionText = new RoundJTextArea("Текст вопроса...", 15);
        questionText.setBounds(150, 20, 400, 100);
        panel.add(questionText);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 5, 5));
        buttonPanel.setBounds(20, 70, 120, 100);

        RoundJButton[] answerButtons = new RoundJButton[4];
        for (int i = 0; i < 4; i++) {
            answerButtons[i] = new RoundJButton("Вариант " + (i + 1));
            buttonPanel.add(answerButtons[i]);
        }
        panel.add(buttonPanel);

        addHiddenButtons(panel);

        return panel;
    }

    private static void addHiddenButtons(JPanel panel) {
        JButton exitButton = createHiddenButton(0, 0);
        exitButton.addActionListener(e -> System.exit(0));
        panel.add(exitButton);

        JButton prevQuestionButton = createHiddenButton(0, panel.getHeight() - 10);
        panel.add(prevQuestionButton);

        JButton nextQuestionButton = createHiddenButton(panel.getWidth() - 10, 0);
        panel.add(nextQuestionButton);

        JButton examButton = createHiddenButton(panel.getWidth() - 10, panel.getHeight() - 10);
        panel.add(examButton);
    }

    private static JButton createHiddenButton(int x, int y) {
    	JButton button = new JButton();
        button.setBounds(x, y, 10, 10);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        return button;
    }
}
