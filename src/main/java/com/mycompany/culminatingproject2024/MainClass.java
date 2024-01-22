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

public class MainClass {

    public static class Question {
        private String question;
        private String answer;
        private int points;

        public Question(String question, String answer, int points) {
            this.question = question;
            this.answer = answer;
            this.points = points;
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
    }

    public static class Lifeline {
        public static String jumpTheQuestion() {
            return "You have chosen to jump the question.";
        }

        public static String getTheAnswer(String answer) {
            return "The correct answer is: " + answer;
        }
    }

    public static class Game {
        private int score;
        private int lifelinesRemaining;
        private ArrayList<Question> questions;
        private Scanner scanner;

        public Game(Scanner scanner) {
            this.score = 0;
            this.lifelinesRemaining = 3;
            this.scanner = scanner;
            this.questions = new ArrayList<>();

            questions.add(new Question("What is the capital of Japan?", "Tokyo", 3));
            questions.add(new Question("Which planet is known as the Red Planet?", "Mars", 3));
            questions.add(new Question("Who wrote 'Romeo and Juliet'?", "William Shakespeare", 3));
            questions.add(new Question("In what year did World War II end?", "1945", 3));
            questions.add(new Question("What is the largest mammal in the world?", "Blue Whale", 3));
            questions.add(new Question("What is the square root of 144?", "12", 3));
            questions.add(new Question("What is the capital of Australia?", "Canberra", 3));
            questions.add(new Question("Which element has the chemical symbol 'O'?", "Oxygen", 3));
            questions.add(new Question("What is the biggest State in the United States?", "Alaska", 10)); 
            questions.add(new Question("Which river is the longest in the world?", "Nile", 3));
            
            questions.add(new Question("Who painted the 'Mona Lisa'?", "Leonardo da Vinci", 10));
            questions.add(new Question("What is the most commonly played instrument?", "Piano",10)); 
            questions.add(new Question("Who composed 'Ode to Joy'", "Beethoven", 10)); 
            questions.add(new Question("What is the currency of Brazil?", "Brazilian Real", 10));
            questions.add(new Question("What is the longest side of the right-angle triangle called?", "Hypotenuse", 10));
            questions.add(new Question("Who has scored the most goals in Football/Soccer?", "Ronaldo", 10));
            questions.add(new Question("Who is Simba's uncle?", "Scar", 10));
            questions.add(new Question("When was the first star wars movie released? 1970 or 1977?", "1970", 10));
            questions.add(new Question("What is the most populous country in the world(2024)", "India", 10)); 
            questions.add(new Question("Who is the richest man on Earth(2024)", "Elon Musk", 10));
            java.util.Collections.shuffle(questions);
        }

        public void startGame() {
            System.out.println("Welcome to the Game Show!");

            for (Question question : questions) {
                System.out.println("\nQuestion: " + question.getQuestion());
                System.out.println("This Question is worth Points: " + question.getPoints());

                System.out.print("Your answer: ");
                String userAnswer = scanner.nextLine();

                if (userAnswer.equalsIgnoreCase(question.getAnswer())) {
                    System.out.println("Correct! You earned " + question.getPoints() + " points.");
                    score += question.getPoints();
                    System.out.println("Your score is: " + score);
                } else {
                    handleWrongAnswer(question);
                }

                if (score >= 30) {
                    System.out.println("Congratulations! You've won the game!");
                    break;
                }
            }

            System.out.println("Game over. Your final score is: " + score);
        }

        private void handleWrongAnswer(Question question) {
            System.out.println("Incorrect answer!");

            if (lifelinesRemaining > 0) {
                System.out.println("You have " + lifelinesRemaining + " lifelines remaining.");
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

                lifelinesRemaining--;
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
}