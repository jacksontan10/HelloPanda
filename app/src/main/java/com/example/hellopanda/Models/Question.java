package com.example.hellopanda.Models;

public class Question {
    private String QuestionText, QuestionImage, AnswerA, AnswerB, AnswerC, AnswerD, CorrectAnswer, CategoryId;

    public Question() {
    }

    public Question(String questionText, String questionImage, String answerA, String answerB, String answerC, String answerD, String correctAnswer, String categoryId) {
        QuestionText = questionText;
        QuestionImage = questionImage;
        AnswerA = answerA;
        AnswerB = answerB;
        AnswerC = answerC;
        AnswerD = answerD;
        CorrectAnswer = correctAnswer;
        CategoryId = categoryId;
    }

    public String getQuestionText() {
        return QuestionText;
    }

    public String getQuestionImage() {
        return QuestionImage;
    }

    public String getAnswerA() {
        return AnswerA;
    }

    public String getAnswerB() {
        return AnswerB;
    }

    public String getAnswerC() {
        return AnswerC;
    }

    public String getAnswerD() {
        return AnswerD;
    }

    public String getCorrectAnswer() {
        return CorrectAnswer;
    }

}


