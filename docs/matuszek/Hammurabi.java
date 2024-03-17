package hammurabi.docs.matuszek;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
public class Hammurabi {
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) { // required in every Java program
        new Hammurabi().playGame();
    }

    void playGame() {
        //Need loop for 10 years as long as people are alive
        announceGame();
        for (int i = 1; i <= 10 && population > 0; i++) {
            year += i;
            askHowManyAcresToBuy(landValue, bushels);
            askHowManyAcresToSell(acres);
            askHowMuchGrainToFeedPeople(bushels);
            askHowManyAcresToPlant(population, acres, bushels);
            yearlySummary();
        }
//        else {
//            endGame()
//        }
    }

    Random random = new Random();  // this is an instance variable
    int year = 0;
    int temp = 0;
    int population = 100;
    int bushels = 280;
    int acres = 1000;
    int landValue = 19;
    boolean plague;
    int acresOwned = 0;
    int grainInStorage = 0;
    int fullPeople = 0;
    int percentDied = 0;
    int totalDeaths = 0;
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

    public int plagueDeaths(int population){
        //Each year, there is a 15% chance of a horrible plague. When this happens, half your people die. Return the number of plague deaths (possibly zero).}
        if (plague){
            population = population / 2;
            System.out.println("A HORRIBLE PLAGUE STRUCK!  HALF THE PEOPLE DIED.\n");
        }
        return population;
    }

    public int starvationDeaths(int population, int bushelsFedToPeople) {
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

    boolean uprising(int population, int howManyPeopleStarved) {
        //Return true if more than 45% of the people starve. (This will cause you to be immediately thrown out of office, ending the game.)
        double starvationRate = (double) howManyPeopleStarved / population * 100;
        if (starvationRate > 45) {System.out.println("DUE TO THIS EXTREME MISMANAGEMENT YOU HAVE NOT ONLY\n" + "BEEN IMPEACHED AND THROWN OUT OF OFFICE BUT YOU HAVE\n" + "ALSO BEEN DECLARED PERSONA NON GRATA!!\n");
        return true;
        }
        return false;
    }

    public int immigrants(int population, int acresOwned, int grainInStorage) {
        //Nobody will come to the city if people are starving (so don't call this method). If everyone is well fed, compute how many people come to the city as: (20 * _number of acres you have_ + _amount of grain you have in storage_) / (100 * _population_) + 1.
        //OLD CODE immigrants = (int) (Math.random() * 5 + 1) * (20 * acres + stores) / population / 100 + 1;
        if(population <= 0 || grainInStorage <= 0){
            return 0;
        }
        int cityVisitors = (int) ((20.0 * acresOwned + bushels) / (100.0 * population)) + 1;
        return cityVisitors;
    }

    int harvest(int acres, int bushelsUsedAsSeed){
        //Choose a random integer between 1 and 6, inclusive. Each acre that was planted with seed will yield this many bushels of grain. (Example: if you planted 50 acres, and your number is 3, you harvest 150 bushels of grain). Return the number of bushels harvested.
        Random random = new Random();
        int randomNumber = random.nextInt(6) + 1;
        return acres * randomNumber;
    }

    int grainEatenByRats(int bushels){
        //There is a 40% chance that you will have a rat infestation. When this happens, rats will eat somewhere between 10% and 30% of your grain. Return the amount of grain eaten by rats (possibly zero).
       // Random random40Percent;
        return 0;
    }

    int newCostOfLand() {
        //The price of land is random, and ranges from 17 to 23 bushels per acre. Return the new price for the next set of decisions the player has to make. (The player will need this information in order to buy or sell land.)
        return 0;
    }
    public void yearlySummary(){
        System.out.println("\n HAMMURABI!\n" +
                "You are in year " + year + " of your ten year rule.\n" +
                "In the previous year " + temp + " people starved to death.\n" +
                "In the previous year " + temp + " people entered the kingdom.\n" +
                "The population is now " + temp + ".\n" +
                "We harvested " + temp + " bushels at " + temp +  " bushels per acre.\n" +
                "Rats destroyed " + temp + " bushels, leaving " + temp + " bushels in storage.\n" +
                "The city owns " + temp + " acres of land.\n" +
                "Land is currently worth " + temp + " bushels per acre.");
    }
    public void endGame(){
        System.out.println("IN YOUR 10-YEAR TERM OF OFFICE, " + percentDied + " PERCENT OF THE\n" + "POPULATION STARVED PER YEAR ON AVERAGE, I.E., A TOTAL OF\n" + totalDeaths + " PEOPLE DIED!!\n" + "YOU STARTED WITH 10 ACRES PER PERSON AND ENDED WITH\n" + acres / population + " ACRES PER PERSON\n\n");

        if (percentDied > 33 || acres / population < 7){
            System.out.println("DUE TO THIS EXTREME MISMANAGEMENT YOU HAVE NOT ONLY\n" + "BEEN IMPEACHED AND THROWN OUT OF OFFICE BUT YOU HAVE\n" + "ALSO BEEN DECLARED PERSONA NON GRATA!!\n");
        }
        else if (percentDied > 10 || acres / population < 9) {
            System.out.println("YOUR HEAVY-HANDED PERFORMANCE SMACKS OF NERO AND IVAN IV.\n" + "THE PEOPLE (REMAINING) FIND YOU AN UNPLEASANT RULER, AND,\n" + "FRANKLY, HATE YOUR GUTS!");
        }
		else if (percentDied > 3 || acres / population < 10) {
            System.out.println("YOUR PERFORMANCE COULD HAVE BEEN SOMEWHAT BETTER, BUT\n" + "REALLY WASN'T TOO BAD AT ALL.\n" + Math.random() * population * .8 + " PEOPLE WOULD" + "DEARLY LIKE TO SEE YOU ASSASSINATED BUT WE ALL HAVE OUR" + "TRIVIAL PROBLEMS");
        } else {
            System.out.println("FANTASTIC PERFORMANCE!!!\n\n\n\n\n\n\n\n\n\n So long for now!");
        }
    }
}

