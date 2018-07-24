// Author: Amanda Hoesman-Foley
// Date: 11.17.16
// Final Project

// Import Statements: Scanner class, io, Random class
import java.util.Scanner; 
import java.io.*;
import java.util.Random;

// public class
public class TheEmeraldRuins {

   // Create a method called displayIntroMessage, receives no arguments
   // and returns void. Body contains a series of System.out.print & 
   // System.out.println statements that output #1 of story
   public static void displayIntroMessage(){
      System.out.println("\nHello, and welcome to The Emerald Ruins. ");
      System.out.print("If you are new to Choose Your own Adventure ");
      System.out.println("games, the idea is pretty simple.");
      System.out.print("You will be told a story and provided choices ");
      System.out.println("along the way (spelling and capitalization matters).");
      System.out.print("Be careful though, those choices may affect ");
      System.out.println("the outcome of the story!");
      System.out.println("Time to begin! \n");
   }
   
   // Create a method called displayFailMessage, receives no arguments
   // and returns void. Body contains a System.out.println statement 
   // that outputs "Your journey ends here. Thank you for playing
   // and please try again." System.exit(0).
   public static void displayFailMessage(){
      System.out.println("Your journey ends here. Thank you for playing and please try again.");
      System.exit(0);
   }
   
   // Create a method called calculateStoryPartTwo, receives an
   // array and returns String. Create a new Scanner object
   // called methodScanner. Declare a variable to store user input
   // for choice one of type String. Declare a variable to store
   // user weapon choice of type String. Use Sytem.out.print 
   // statements to evaluate choice. Use an enhanced for loop to
   // print array to screen. If input.equals "no" then call
   // the displayFailMessage method. Else, use System.out.print to 
   // output #2.b of story and further gain input on weapon choice.
   // Return weapon choice. 
   public static String calculateStoryPartTwo(String[] myArray){
      Scanner methodScanner = new Scanner(System.in);
      String userInput = "";
      String weaponChoice = "";
      System.out.println("You are the famed adventurer Sveo Whitemane.");
      System.out.print("While wandering through the forests of Falkreath ");
      System.out.println("Hold one day you come upon the Emerald Ruins.");
      System.out.print("Do you wish to explore its depths? (Choose 'yes' or 'no'): ");
      userInput = methodScanner.nextLine();
      if (userInput.equals("no")) {
         displayFailMessage();
      } else if (userInput.equals("yes")) {
         System.out.println("\nYou proceed inside.");
         System.out.println("You find a fallen adventurer with a note by his side:");
         System.out.println("'Whoever enters here, be warned.");
         System.out.println("Draugr roam the halls - take one of these if you want to survive.'");
         System.out.print("By his side lay three weapons, which will you choose? \n");
         for (String i : myArray) {
            System.out.print("'" + i + "' ");
         }
         weaponChoice = methodScanner.nextLine();
      } else {
         System.out.println("You have entered an incorrect option.");
         displayFailMessage();
      }
      return weaponChoice;
   }
   
   // Create a method called calculateFightingLogic, receives a 
   // parameter of type int, namely "sveoHealth", and a parameter
   // of type String, namely "sveoWeapon", and returns int.
   // Body is the following: Create a new random object called
   // randomNumber. Declare variables enemyHealth and sveoDamage
   // both of type int. Switch statement, on
   // the variable that stored your chosen weapon (type String) to
   // determine how much damage you do. "elven bow" sets sveoDamage
   // to 13. "ebony mace" sets sveoDamage to 15. "dwarven greatsword"
   // sets sveoDamage to 19. For loop to determine outcome of battle. 
   // For (enemyHealth = 40; enemyHealth > 0; enemyHealth - sveoDamage).
   // Body of for loop: sveoHealth -= randomNumber.nextInt(30). If 
   // statement: If (sveoHealth) <= 0) call the displayFailMessage
   // method. Return sveoHealth.
   public static int calculateFightingLogic (int sveoHealth, String sveoWeapon) {
      Random randomNumber = new Random();
      int sveoDamage = 0;
      int enemyHealth = 0;
      switch (sveoWeapon) {
         case "elven bow":
            sveoDamage = 13;
            break;
         case "ebony mace":
            sveoDamage = 15;
            break;
         case "dwarven greatsword":
            sveoDamage = 19;
            break;
      }
      for (enemyHealth = 40; enemyHealth > 0; enemyHealth -= sveoDamage) {
         sveoHealth -= randomNumber.nextInt(30);
         if (sveoHealth <= 0) {
            displayFailMessage();
         }
      }
      System.out.println("You won the battle!");
      return sveoHealth;
   }
   
   // Create a method called calculateStoryPartFive, receives 
   // sveoHealth and returns int. Create a Scanner and declare
   // a variable, partFiveChoice for user input of type String. Use
   // system.out.print and .println statements to output #5 of story
   // and obtain user input. If partFiveChoice.equals("maxhealth")
   // then set sveoHealth equal to 100. Return sveoHealth.
   public static int calculateStoryPartFive(int sveoHealth) {
      Scanner methodScanner = new Scanner(System.in);
      String partFiveChoice = "";
      System.out.println("\nThe path leads into a room with barrels full of health potions.");
      System.out.print("You've explored enough caves to know what this means -");
      System.out.println(" the boss is up ahead.");
      System.out.println("Are you confident in your battle skills or do you take the potions?");
      System.out.print("(Choose 'maxhealth' or 'forgeahead'): ");
      partFiveChoice = methodScanner.nextLine();
      if (partFiveChoice.equals("maxhealth")) {
         System.out.println("\nYou choose to max out your health.");
         sveoHealth = 100;
      } else if (partFiveChoice.equals("forgeahead")) {
         System.out.println("\nYou choose not to max out your health.");
      } else {
         System.out.println("\nYou have entered an incorrect option.");
         displayFailMessage();
      }
      return sveoHealth;
   }
   
   // Create a method called calculateBossFightingLogic, receives a 
   // parameter of type int, namely "sveoHealth", and a parameter
   // of type String, namely "sveoWeapon", and returns void. Body
   // is the same as calculateFightingLogic method except for the
   // following: Set enemyHealth to 75. If statement is the same,
   // but ELSE use Sytem.out.print statements to output #6.b.ii
   // of story and then call the displayFailMessage method. 
   public static void calculateBossFightingLogic (int sveoHealth, String sveoWeapon) {
      Random randomNumber = new Random();
      int sveoDamage = 0;
      int enemyHealth = 0;
      switch (sveoWeapon) {
         case "elven bow":
            sveoDamage = 13;
            break;
         case "ebony mace":
            sveoDamage = 15;
            break;
         case "dwarven greatsword":
            sveoDamage = 19;
            break;
      }
      for (enemyHealth = 75; enemyHealth > 0; enemyHealth -= sveoDamage) {
         sveoHealth -= randomNumber.nextInt(30);
         if (sveoHealth <= 0) {
            displayFailMessage();
         }
      }
      System.out.println("\nThe battle is over, and you fill your pockets with the gems.");
      System.out.println("It wasn't easy but another worthwhile adventure is complete.");
      displayFailMessage();
   }
   
   // the main method
   public static void main (String[] args) throws IOException {
   
      // let the user know that the README file is being displayed
      System.out.println("To begin this program, the README file will be printed so that you are aware of the program's details:\n");
         
      // Set up variables/logic to read from a file
      String fileName = "README.txt";
      File myFile = new File(fileName);
      Scanner inputFile = new Scanner(myFile);
      while (inputFile.hasNext()){
         System.out.println(inputFile.nextLine());
      }
      inputFile.close();
     
      // Create a Scanner object called mainScanner
      Scanner mainScanner = new Scanner(System.in);
      
      // Create a random object
      Random randomObject = new Random();
      
      // Create an array to hold weapon choices
      String[] weaponChoices = {"elven bow", "ebony mace", "dwarven greatsword"};
      
      // Declare variable for weaponChoice, partThreeChoice,
      // partThreeAChoice, partThreeBChoice, partFourChoice, 
      // and partSixChoice all of type String
      String weaponChoice = "";
      String partThreeChoice = "";
      String partThreeAChoice = "";
      String partThreeBChoice = "";
      String partFourChoice = "";
      String partSixChoice = "";
            
      // Declare variable threeBIOutcome of type Boolean
      Boolean threeBIOutcome;
      
      // Declare a variable myHealth of type int and assign it 100
      int myHealth = 100;
      
      // Call the displayIntroMessage method
      displayIntroMessage();
      
      // Set weaponChoice equal to the value when you call
      // calculateStoryPartTwo
      weaponChoice = calculateStoryPartTwo(weaponChoices);
      
      // Use system.out.print statements to ouput #3 of story and obtain user input.
      System.out.println("\nCautiously you proceed further into the ruins.");
      System.out.print("The path branches, but which way will you go? (Choose 'left' or 'right'): ");
      partThreeChoice = mainScanner.nextLine();
      // if else statement to determine next part of story.
      if (partThreeChoice.equals("left")) {
         System.out.println("\nYou come to a room with two levers.");
         System.out.print("There appears to be no way out, and back tracking ");
         System.out.println("is too easy, so you must pull one.");
         System.out.print("Which will lead you to good fortune? (Choose 'left' or 'right'): ");
         partThreeAChoice = mainScanner.nextLine();
         // if statement to determine next branch
         if (partThreeAChoice.equals("left")) {
            System.out.println("\nA hidden path opens up which leads to a treasure room.");
            System.out.println("Emeralds and septims fill the chests.");
            System.out.println("Your pockets full, you exit the ruins.");
            displayFailMessage();
         } else if (partThreeAChoice.equals("right")) {
            System.out.println("\nThe floor falls out from under you, and you land in a pit of spikes.");
            displayFailMessage();
         } else {
            System.out.println("You have entered an incorrect option.");
            displayFailMessage();
         }
      } else if (partThreeChoice.equals("right")) {
         System.out.print("\nFollowing the path, you come to a room with ");
         System.out.println("a restless draugr sleeping in its crypt.");
         System.out.println("You can either sneak past it or fight it.");
         System.out.print("What course of action will you take? (Choose 'sneak' or 'fight'): ");
         partThreeBChoice = mainScanner.nextLine();
         // if statement to determine next branch
         if (partThreeBChoice.equals("sneak")) {
            threeBIOutcome = randomObject.nextBoolean();
            // if statement to determine if succssful or not
            if (threeBIOutcome == true) {
               System.out.println("\nYou are successful!");
               System.out.println("You proceed further into the cave.");
            } else {
               System.out.println("\nYou are unsuccessful and the restless draugr engages you in combat.");
               myHealth = calculateFightingLogic(myHealth, weaponChoice);
            }
         } else if (partThreeBChoice.equals("fight")) {
            System.out.println("\nYou decide to fight the restless draugr.");
            myHealth = calculateFightingLogic(myHealth, weaponChoice);
         } else {
            System.out.println("You have entered an incorrect option.");
            displayFailMessage();
         }
      } else {
         System.out.println("You have entered an incorrect option.");
         displayFailMessage();
      }
            
      // Use System.out.print(println) statements to output story #4 and receive user input
      System.out.print("\nThe next room has a draugr scourge lurking within, ");
      System.out.println("but there is no chance to sneak past it this time.");
      System.out.print("Do you engage in combat or turn back? (Choose 'fight' or 'flee'): ");
      partFourChoice = mainScanner.nextLine();
      // if else statement to determine outcome
      if (partFourChoice.equals("fight")) {
         System.out.println("You choose to battle the draugr!");
         myHealth = calculateFightingLogic(myHealth, weaponChoice);
      } else if (partFourChoice.equals("flee")) {
         displayFailMessage();
      } else {
         System.out.println("You have entered an incorrect option.");
         displayFailMessage();
      }      
            
      // Call the calculateStoryPartFive method
      myHealth = calculateStoryPartFive(myHealth);
      
      // Use System.out.print and .println methods to output #6 of story
      // and receive user input.
      System.out.println("A draugr death overlord sits upon a throne, a pile of emeralds by his side.");
      System.out.print("Is the sight too much to bear or do you engage in your ");
      System.out.print("final battle of the day? (Choose 'giveup' or 'endthis'): ");
      partSixChoice = mainScanner.nextLine();
      // if else statement
      if (partSixChoice.equals("giveup")) {
         displayFailMessage();
      } else if (partSixChoice.equals("endthis")) {
         calculateBossFightingLogic(myHealth, weaponChoice);
      } else {
         System.out.println("You have entered an incorrect option.");
         displayFailMessage();
      }
   }
}