/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.culminatingproject2024;

/**
 *
 * @author AkSiv2439
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List; 

public class MainClass {

    static class Question {
        private String question;
        private String answer;
        private int points;
        private String difficulty;

        public Question(String question, String answer, int points, String difficulty) {
            this.question = question;
            this.answer = answer;
            this.points = points;
            this.difficulty = difficulty;
        }

        public String getQuestion() {
            return question;
        }

        public String getAnswer() {
            return answer;
        }

        public int getPoints() {
            return points;
        }

        public String getDifficulty() {
            return difficulty;
        }
    }

    static class Lifeline {
        public static String jumpTheQuestion() {
            return "You have chosen to jump the question.";
        }

        public static String getTheAnswer(String answer) {
            return "The correct answer is: " + answer;
        }
    }

    static class Game {
        private int score;
        private boolean mediumUnlocked;
        private boolean hardUnlocked;
        private ArrayList<Question> questions;
        private Scanner scanner;

        public Game(Scanner scanner) {
            this.score = 0;
            this.mediumUnlocked = false;
            this.hardUnlocked = false;
            this.scanner = scanner;
            this.questions = new ArrayList<>();
            questions.add(new Question("What is the capital of Japan?", "Tokyo", 3, "Easy"));
            java.util.Collections.shuffle(questions);
        }

        public void startGame() {
            System.out.println("Welcome to the Game Show!");

            for (Question question : questions) {
                System.out.println("\nQuestion: " + question.getQuestion());
                System.out.println("Points: " + question.getPoints());

                System.out.print("Your answer: ");
                String userAnswer = scanner.nextLine();

                if (userAnswer.equalsIgnoreCase(question.getAnswer())) {
                    System.out.println("Correct! You earned " + question.getPoints() + " points.");
                    score += question.getPoints();
                    System.out.println("Your score is: " + score);
                } else {
                    handleWrongAnswer(question);
                }

                if (score >= 30 && score < 50 && !mediumUnlocked) {
                    System.out.println("Congratulations! You've reached the Medium level!");
                    questions.addAll(getMediumQuestions());
                    mediumUnlocked = true;
                } else if (score >= 50 && score < 80 && !hardUnlocked) {
                    System.out.println("Congratulations! You've reached the Hard level!");
                    questions.addAll(getHardQuestions());
                    hardUnlocked = true;
                } else if (score >= 80) {
                    System.out.println("Congratulations! You've won the game!");
                    break;
                }
            }

            System.out.println("Game over. Your final score is: " + score);
        }

        private void handleWrongAnswer(Question question) {
            System.out.println("Incorrect answer!");

            if (mediumUnlocked) {
                System.out.println("You have 2 lifelines remaining.");
                System.out.println("1. Jump the Question");
                System.out.println("2. Get the Answer");

                System.out.print("Choose a lifeline (1 or 2): ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println(Lifeline.jumpTheQuestion());
                        break;
                    case 2:
                        System.out.println(Lifeline.getTheAnswer(question.getAnswer()));
                        break;
                    default:
                        System.out.println("Invalid choice. No lifeline used.");
                }
            } else {
                System.out.println("You have run out of lifelines.");
                System.out.println("Game over. Your final score is: " + score);
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game(scanner);
        game.startGame();
    }

    private static List<Question> getMediumQuestions() {
        List<Question> mediumQuestions = new ArrayList<>();
        // Add medium level questions here
        return mediumQuestions;
    }

    private static List<Question> getHardQuestions() {
        List<Question> hardQuestions = new ArrayList<>();
        // Add hard level questions here
        return hardQuestions;
    }
}