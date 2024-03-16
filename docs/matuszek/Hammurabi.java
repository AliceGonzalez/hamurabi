package hammurabi.docs.matuszek;

import java.util.Random;         // imports go here
import java.util.Scanner;
public class Hammurabi {         // must save in a file named Hammurabi.java
    Random rand = new Random();  // this is an instance variable
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) { // required in every Java program
        new Hammurabi().playGame();
    }

    void playGame() {
        askHowManyAcresToBuy(landValue,bushels);

    }

    // declare local variables here: grain, population, etc.
    int population = 100;
    int bushels = 280;
    int acres = 1000;
    int landValue = 19;

    // statements go after the declarations

    int askHowManyAcresToBuy(int price, int bushels){
        // Asks the player how many acres of land to buy, and returns that number. You must have enough grain to pay for your purchase.
        Scanner scanner = new Scanner(System.in);
        System.out.print("HOW MANY ACRES DO YOU WISH TO BUY?  ");
        Integer userInput = scanner.nextInt();

        return userInput;
    }


//        int askHowManyAcresToSell(int acresOwned){
//            //Asks the player how many acres of land to sell, and returns that number. You can't sell more than you have.Do not ask this question if the player is buying land; it doesn't make sense to do both in one turn
//        }
//
//
//        int askHowMuchGrainToFeedPeople(int bushels)
//        {//Ask the player how much grain to feed people, and returns that number. You can't feed them more grain than you have. You can feed them more than they need to survive.
//        }
//
//        int askHowManyAcresToPlant(int acresOwned, int population, int bushels){
//            //Ask the player how many acres to plant with grain, and returns that number. You must have enough acres, enough grain, and enough people to do the planting. Any grain left over goes into storage for next year.
//        }
//        //other methods go here
//        public void yearlySummary(){
//            System.out.println("O great Hammurabi!\n" +
//                    "You are in year 1 of your ten year rule.\n" +
//                    "In the previous year 0 people starved to death.\n" +
//                    "In the previous year 5 people entered the kingdom.\n" +
//                    "The population is now 100.\n" +
//                    "We harvested 3000 bushels at 3 bushels per acre.\n" +
//                    "Rats destroyed 200 bushels, leaving 2800 bushels in storage.\n" +
//                    "The city owns 1000 acres of land.\n" +
//                    "Land is currently worth 19 bushels per acre.");
//        }
}

