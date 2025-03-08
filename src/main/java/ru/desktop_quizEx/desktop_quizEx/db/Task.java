package ru.desktop_quizEx.desktop_quizEx.db;

public class Task {
    private int taskId;
    private String description;
    private String correctAnswer;

    public Task(int taskId, String description, String correctAnswer) {
        this.taskId = taskId;
        this.description = description;
        this.correctAnswer = correctAnswer;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getDescription() {
        return description;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", description='" + description + '\'' +
                ", correctAnswer='" + correctAnswer + '\'' +
                '}';
    }
}
