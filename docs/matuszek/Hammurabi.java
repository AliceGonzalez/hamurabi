package hammurabi.docs.matuszek;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
public class Hammurabi {
    public static void main(String[] args) { // required in every Java program
        new Hammurabi().playGame();
    }

    void playGame() {
        //Need loop for 10 years as long as people are alive
        announceGame();
        askHowManyAcresToBuy(landValue, bushels);
        askHowManyAcresToSell(acres);
        askHowMuchGrainToFeedPeople(bushels);
        askHowManyAcresToPlant(population, acres, bushels);
        yearlySummary();
    }

    Random random = new Random();  // this is an instance variable
    int year;
    int population = 100;
    int bushels = 280;
    int acres = 1000;
    int landValue = 19;
    boolean plague;
    //static int totalDeaths = 0, percentDied = 0, year = 0, population = 95, stores = 2800, immigrants = 5, deaths, harvest = 3000, yeild = 3, acres = harvest / yeild, eaten = harvest - stores, landPrice, fullPeople, temp;

    void announceGame() {
        System.out.println("Congratulations, you are the newest ruler of ancient Sumer, elected for a ten year term of office. Your duties are to dispense food, direct farming, and buy and sell land as needed to support your people. Watch out for rat infestiations and the plague! Grain is the general currency, measured in bushels. The following will help you in your decisions:\n" +
                "\n" +
                "-Each person needs at least 20 bushels of grain per year to survive\n" +
                "-Each person can farm at most 10 acres of land\n" +
                "-It takes 2 bushels of grain to farm an acre of land\n" +
                "-The market price for land fluctuates yearly\n" +
                "-Rule wisely and you will be showered with appreciation at the end of your term.\n" + "-Rule poorly and you will be kicked out of office!\n");
    }

    int askHowManyAcresToBuy(int price, int bushels) {
        // Asks the player how many acres of land to buy, and returns that number. You must have enough grain to pay for your purchase.
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("HOW MANY ACRES DO YOU WISH TO BUY?  ");
                Integer userInput = scanner.nextInt();
                if (userInput <= bushels) {
                    return userInput;
                } else {
                    System.out.println("HAMURABI:  THINK AGAIN. YOU HAVE ONLY\n" + bushels + " BUSHELS OF GRAIN. NOW THEN,");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number!");
                scanner.next();
            }
        }
    }
    int askHowManyAcresToSell(int acresOwned) {
        //Asks the player how many acres of land to sell, and returns that number. You can't sell more than you have.Do not ask this question if the player is buying land; it doesn't make sense to do both in one turn
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("HOW MANY ACRES DO YOU WISH TO SELL?  ");
                Integer userInput = scanner.nextInt();
                if (userInput <= acres) {
                    return userInput;
                } else {
                    System.out.println("HAMURABI:  THINK AGAIN. YOU OWN ONLY " + acres + " ACRES. NOW THEN,");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number!");
                scanner.next();
            }
        }

    }
    int askHowMuchGrainToFeedPeople(int bushels) {//Ask the player how much grain to feed people, and returns that number. You can't feed them more grain than you have. You can feed them more than they need to survive.
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("HOW MANY BUSHELS DO YOU WISH TO FEED YOUR PEOPLE?  ");
                Integer userInput = scanner.nextInt();
                if (userInput <= bushels) {
                    return userInput;
                } else {
                    System.out.println("HAMURABI:  THINK AGAIN. YOU HAVE ONLY\n" + bushels + " BUSHELS OF GRAIN. NOW THEN,");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number!");
                scanner.next();
            }
        }
    }
    int askHowManyAcresToPlant(int acresOwned, int population, int bushels) {
        //Ask the player how many acres to plant with grain, and returns that number. You must have enough acres, enough grain, and enough people to do the planting. Any grain left over goes into storage for next year.
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("HOW MANY ACRES DO YOU WISH TO PLANT WITH SEED?  ");
                Integer userInput = scanner.nextInt();
                if (userInput <= acres) {
                    return userInput;
                } else {
                    System.out.println("HAMURABI:  THINK AGAIN. YOU OWN ONLY " + acres + " ACRES. NOW THEN,");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number!");
                scanner.next();
            }
        }

    }

    int plagueDeaths(int population){
        //Each year, there is a 15% chance of a horrible plague. When this happens, half your people die. Return the number of plague deaths (possibly zero).}
        return population / 2;
    }

    int starvationDeaths(int population, int bushelsFedToPeople) {
        //Each person needs 20 bushels of grain to survive. If you feed them more than this, they are happy, but the grain is still gone. You don't get any benefit from having happy subjects. Return the number of deaths from starvation (possibly zero).
        int peopleFed = 0;
        int bushelCounter = bushelsFedToPeople;

        for (int i = 0; i <= population; i++ ){
            if(bushelCounter >= 20){
                peopleFed++;
                bushelCounter -= 20;
            }
        }

        int peopleStarved = population - peopleFed;
        return peopleStarved;
    }

    boolean uprising(int population, int howManyPeopleStarved){
        //Return true if more than 45% of the people starve. (This will cause you to be immediately thrown out of office, ending the game.)
        return true;
    }

    int immigrants(int population, int acresOwned, int grainInStorage) {
        //Nobody will come to the city if people are starving (so don't call this method). If everyone is well fed, compute how many people come to the city as: (20 * _number of acres you have_ + _amount of grain you have in storage_) / (100 * _population_) + 1.
        return 0;
    }

    int harvest(int acres, int bushelsUsedAsSeed){
        //Choose a random integer between 1 and 6, inclusive. Each acre that was planted with seed will yield this many bushels of grain. (Example: if you planted 50 acres, and your number is 3, you harvest 150 bushels of grain). Return the number of bushels harvested.
        return 0;
    }

    int grainEatenByRats(int bushels){
        //There is a 40% chance that you will have a rat infestation. When this happens, rats will eat somewhere between 10% and 30% of your grain. Return the amount of grain eaten by rats (possibly zero).
        return 0;
    }

    int newCostOfLand() {
        //The price of land is random, and ranges from 17 to 23 bushels per acre. Return the new price for the next set of decisions the player has to make. (The player will need this information in order to buy or sell land.)
        return 0;
    }
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

