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
        announceGame();
        askHowManyAcresToBuy(landValue,bushels);
        askHowManyAcresToSell(acres);
        askHowMuchGrainToFeedPeople(bushels);
        askHowManyAcresToPlant(population,acres,bushels);
        yearlySummary();
    }

    // declare local variables here: grain, population, etc.
    int population = 100;
    int bushels = 280;
    int acres = 1000;
    int landValue = 19;

    // statements go after the declarations
    void announceGame(){
        System.out.println("Congratulations, you are the newest ruler of ancient Sumer, elected for a ten year term of office. Your duties are to dispense food, direct farming, and buy and sell land as needed to support your people. Watch out for rat infestiations and the plague! Grain is the general currency, measured in bushels. The following will help you in your decisions:\n" +
                "\n" +
                "-Each person needs at least 20 bushels of grain per year to survive\n" +
                "-Each person can farm at most 10 acres of land\n" +
                "-It takes 2 bushels of grain to farm an acre of land\n" +
                "-The market price for land fluctuates yearly\n" +
                "-Rule wisely and you will be showered with appreciation at the end of your term.\n"+ "-Rule poorly and you will be kicked out of office!\n");
    }

    int askHowManyAcresToBuy(int price, int bushels){
        // Asks the player how many acres of land to buy, and returns that number. You must have enough grain to pay for your purchase.
        Scanner scanner = new Scanner(System.in);
        System.out.print("HOW MANY ACRES DO YOU WISH TO BUY?  ");
        Integer userInput = scanner.nextInt();

        return userInput;
    }


        int askHowManyAcresToSell(int acresOwned){
            //Asks the player how many acres of land to sell, and returns that number. You can't sell more than you have.Do not ask this question if the player is buying land; it doesn't make sense to do both in one turn
            Scanner scanner = new Scanner(System.in);
            System.out.print("HOW MANY ACRES DO YOU WISH TO SELL?  ");
            Integer userInput = scanner.nextInt();

            return userInput;
        }


        int askHowMuchGrainToFeedPeople(int bushels)
        {//Ask the player how much grain to feed people, and returns that number. You can't feed them more grain than you have. You can feed them more than they need to survive.
            Scanner scanner = new Scanner(System.in);
            System.out.print("HOW MANY BUSHELS DO YOU WISH TO FEED YOUR PEOPLE?  ");
            Integer userInput = scanner.nextInt();

            return userInput;
        }

        int askHowManyAcresToPlant(int acresOwned, int population, int bushels){
            //Ask the player how many acres to plant with grain, and returns that number. You must have enough acres, enough grain, and enough people to do the planting. Any grain left over goes into storage for next year.
            Scanner scanner = new Scanner(System.in);
            System.out.print("HOW MANY ACRES DO YOU WISH TO PLANT WITH SEED?  ");
            Integer userInput = scanner.nextInt();

            return userInput;
        }
        //other methods go here
        public void yearlySummary(){
            System.out.println("O great Hammurabi!\n" +
                    "You are in year 1 of your ten year rule.\n" +
                    "In the previous year 0 people starved to death.\n" +
                    "In the previous year 5 people entered the kingdom.\n" +
                    "The population is now 100.\n" +
                    "We harvested 3000 bushels at 3 bushels per acre.\n" +
                    "Rats destroyed 200 bushels, leaving 2800 bushels in storage.\n" +
                    "The city owns 1000 acres of land.\n" +
                    "Land is currently worth 19 bushels per acre.");
        }
}

