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
         mediumQuestions.add(new Question("Who wrote 'Romeo and Juliet'?", "William Shakespeare", 3, "Medium"));
         mediumQuestions.add(new Question("What is the most commonly played instrument?", "Piano",3, "Medium")); 
         

        return mediumQuestions;
    }

    private static List<Question> getHardQuestions() {
        List<Question> hardQuestions = new ArrayList<>();
         hardQuestions.add(new Question("Which river is often considered the cradle of civilization in ancient Mesopotamia?", "Tigris River", 7, "Hard"));
         hardQuestions.add(new Question("What is the currency of Switzerland?", "Swiss Franc", 7, "Hard"));
         hardQuestions.add(new Question("In physics, what is the Heisenberg Uncertainty Principle related to?", "Quantum mechanics", 7, "Hard"));
         hardQuestions.add(new Question("Which mountain is the highest in North America?", "Denali (formerly known as Mount McKinley)", 7, "Hard"));
         hardQuestions.add(new Question("Who is the author of the philosophical work 'Meditations'?", "Marcus Aurelius", 7, "Hard"));
         hardQuestions.add(new Question("Which Russian czar is known as the 'Father of the Fatherland'?", "Ivan the Terrible", 7, "Hard"));
         hardQuestions.add(new Question("In which year did the Chernobyl nuclear disaster occur?", "1986", 7, "Hard"));
         hardQuestions.add(new Question("What is the only planet in our solar system that rotates clockwise?", "Venus", 7, "Hard"));
         hardQuestions.add(new Question("Which ancient wonder of the world was located in the city of Babylon?", "Hanging Gardens of Babylon", 7, "Hard"));
         hardQuestions.add(new Question("Who painted the 'Mona Lisa'?", "Leonardo da Vinci", 7, "Hard"));


        return hardQuestions;
    }
}