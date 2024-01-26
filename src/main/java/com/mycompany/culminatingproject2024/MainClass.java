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
        private int strikes; 
        private Scanner scanner;
        //private int lifeLinesRemaining=2;
        
       

        public Game(Scanner scanner) {
            this.score = 0;
            this.mediumUnlocked = false;
            this.hardUnlocked = false;
            this.strikes = 0;
            this.scanner = scanner;
            this.questions = new ArrayList<>();
            questions.add(new Question("What is the capital of Japan? a) Osaka b) Tokyo", "b", 5, "Easy"));
            questions.add(new Question("What is the capital of Canada? a) Ottawa b) Toronto ", "a", 5, "Easy"));
            questions.add(new Question("Who is known as the 'Father of Computer Science': a) Alan Turing or b) Albert Einstein?", "a", 5, "Easy"));
            questions.add(new Question("How many continents are there on Earth? a) 5 b) 7 ", "b", 5, "Easy"));
            questions.add(new Question("What is the currency of Japan: a) Dong or b) Yen c) yuan ?", "b", 5, "Easy"));
            questions.add(new Question("Who painted the 'Starry Night': a) Vincent van Gogh or b) Da Vinci ?", "a", 5, "Easy"));
            questions.add(new Question("What is the capital of Russia: a) Petrograd or b) Moscow or c) Keiv d) Smolensk ?", "b", 5, "Easy"));
            questions.add(new Question("Which is the smallest prime number: a) 2 or b) 3 pr b) 1 ?", "a", 5, "Easy"));
            questions.add(new Question("What is the main ingredient in guacamole: a) Pineaplle b)Apple c) Avocado?", "c", 5, "Easy"));
            questions.add(new Question("Who is known as the 'Father of Modern Physics'? a) Isaac Newton b) William Henry c)Albert Enistein ", "c", 5, "Easy"));
            questions.add(new Question("What is the capital of France: a) Bordeaux, b) Paris, c) Lyon ?", "b", 5, "Easy"));
            questions.add(new Question("Who discovered gravity? a)Isaac Newton b) Albert Einstein c) Thomas Edison  ", "a", 5, "Easy"));
            questions.add(new Question("What is the largest planet in our solar system: a) Saturn b) Jupiter?", "b", 5, "Easy"));
            questions.add(new Question("Which element has the chemical symbol 'H': a) Helium or b) Hydrogen?", "b", 5, "Easy"));
            questions.add(new Question("What is the process by which plants make their own food?:a)  Precipitation  b) Photosynthesis c) Photomyosis", "b", 5, "Easy"));
            questions.add(new Question("What is the capital of China: a)Seoul b) Beijing c)Shanghai?", "b", 5, "Easy"));
            questions.add(new Question("Who is credited with inventing the light bulb: a) Nikolas Tesla  b) Thomas Edison c) Wright Brothers?", "b", 5, "Easy"));
            questions.add(new Question("What is the boiling point of water in Celsius: a) 120, b) 101, c) 100, d) 140?", "c", 5, "Easy"));
            java.util.Collections.shuffle(questions);
        }

        public void startGame() {
            System.out.println("Welcome to the Game Show!");
            
            ArrayList<Question> myQuestions = new ArrayList();
            
           // add easy 
           myQuestions.addAll(questions.subList(0, 5)) ;
           
           //add medium 
           myQuestions.addAll(getMediumQuestions().subList(0, 3)) ;
           // add hard 
           myQuestions.addAll(getHardQuestions().subList(0, 3)) ;
            
                for (Question question : myQuestions) {
                System.out.println("\nQuestion: " + question.getQuestion());
                System.out.println("Points: " + question.getPoints());

                System.out.print("Your answer: ");
                String userAnswer = scanner.nextLine();

                if (userAnswer.equalsIgnoreCase(question.getAnswer())) {
                    System.out.println("Correct! You earned " + question.getPoints() + " points.");
                    score += question.getPoints();
                    System.out.println("Your score is: " + score);
                    
                    if (score >= 25 && score < 55 && !mediumUnlocked) {
                        System.out.println("Congratulations! You've reached the Medium level! You will now have 3 strikes");
                        //questions.addAll(getMediumQuestions());
                        mediumUnlocked = true;
                        continue;
                    } else if (score >= 55 && score < 100 && !hardUnlocked) {
                        System.out.println("Congratulations! You've reached the Hard level!");
                         
                        //questions.addAll(getHardQuestions());
                        hardUnlocked = true;
                        continue;
                    } else if (score >= 100) {
                        System.out.println("Congratulations! You've won the game!");
                        break;
                    }
                    
                } else {
                    //System.out.println("Oops. Incorrect answer!");
                      if (strikes >0) {
                        
                        boolean continuetheGame =handleWrongAnswer(question);
                        if (continuetheGame == false){
                            System.out.println("Game over. Your final score is: " + score);
                        }
                        else {
                           continue; 
                        }
                      } else {
                           System.out.println("Game over. Your final score is: " + score);
                      }
                      //
                }

                
            
            }

            //
        }

        private boolean handleWrongAnswer(Question question) {
            boolean continueGame =true;

            if (strikes > 0 ) {
                System.out.println("Oops, Incorrect Answer!");
                strikes--;
                System.out.println("You have +  + strikes remaining.");
              

                System.out.print("Do you want to continue? (yes/no): ");
                String choice = scanner.nextLine();

                if (choice.equalsIgnoreCase("no")) {
                    continueGame = false; 
                }
                if (choice.equalsIgnoreCase("yes")) { 
                    continueGame = true; 
                }
                
                } else {
                System.out.println("You have run out of strikes.");
                continueGame = false;
            }
                
                return continueGame;
            
                //System.out.println("You have run out of lifelines.");
                //System.exit(0);
            }
        }
    
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game(scanner);
        game.startGame();
    }

    /**
     * 
     * 
     * @return 
     */
    private static List<Question> getMediumQuestions() {
        
        List<Question> mediumQuestions = new ArrayList<>();
         mediumQuestions.add(new Question("Who wrote 'Romeo and Juliet'? a) William Penn b) William Henry c) William Shakespeare", "c", 10, "Medium"));
         mediumQuestions.add(new Question("What is the most commonly played instrument: a) Guitar, b) Drums or c) Piano?", "c",10, "Medium")); 
         mediumQuestions.add(new Question("Who painted the Mona Lisa? a)Leonardo Di Capri b)Leonardo da Vinci ", "b", 10, "Medium"));
         mediumQuestions.add(new Question("Which planet is known as the 'Red Planet': a) Saturn  b) Mars c) Sun?", "b", 10, "Medium"));
         mediumQuestions.add(new Question("In what year did the Titanic sink: a) 1914 b) 1899 c) 1912?", "c", 10, "Medium"));
         mediumQuestions.add(new Question("In what year did the Great Depression Begin: a) 1919 b) 1927 c) 1923?", "c", 10, "Medium"));
         mediumQuestions.add(new Question("What is the capital of Australia: a) Syndey  b) Canberra?", "b", 10, "Medium"));
         mediumQuestions.add(new Question("Who wrote '1984': a) George Orwell b) Aldous Huxley?", "a", 10, "Medium"));
         mediumQuestions.add(new Question("What is the speed of light in a vacuum in KM? a) 299792 or b) 300198 ", "a", 10, "Medium"));

        return mediumQuestions;
    }

    private static List<Question> getHardQuestions() {
        List<Question> hardQuestions = new ArrayList<>();
         hardQuestions.add(new Question("Which river is often considered the cradle of civilization in ancient Mesopotamia a)Black Sea, b)Tigris ,c) Niles ?", "b", 15, "Hard"));
         hardQuestions.add(new Question("What is the currency of Switzerland? a) Swiss Chalet b) Swiss Franc c) Swiss Knife", "b", 15, "Hard"));
         hardQuestions.add(new Question("In physics, what is the Heisenberg Uncertainty Principle related to a) Quantum Mechanics, b) Probability, c) Statistics ?", "b", 15, "Hard"));
         hardQuestions.add(new Question("Which mountain is the highest in North America? a) Denali, b) Pike speak c) Arizona mount", "a", 15, "Hard"));
         hardQuestions.add(new Question("Who is the author of the philosophical work 'Meditations' ? a) Abraham Aurelius, b) Marcus Aurelius c) Rene Markham", "b", 15, "Hard"));
         hardQuestions.add(new Question("Which Russian czar is known as the 'Father of the Fatherland'? a) Bon Jovi b) Ivan the Terrible", "b", 15, "Hard"));
         hardQuestions.add(new Question("In which year did the Chernobyl nuclear disaster occur? a) 1982 b) 1986 c) 1983 d) 1987 ", "b", 15, "Hard"));
         hardQuestions.add(new Question("What is the only planet in our solar system that rotates clockwise? a) Mars b) Venus c) Jupiter", "b", 15, "Hard"));
         hardQuestions.add(new Question("Which ancient wonder of the world was located in the city of Babylon: a) Statue of Zues b)Hanging Gardens of Babylon ?", "b", 15, "Hard"));
         hardQuestions.add(new Question("Who painted the 'Mona Lisa'?", "Leonardo da Vinci", 15, "Hard"));


        return hardQuestions;
    }
}