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
        for (int i = 1; i <= 10 && people > 0; i++) {
            year += i;
            int acresBought = askHowManyAcresToBuy(price, bushels);
            int acresSold = askHowManyAcresToSell(acres);
            int grainToFeedPeople= askHowMuchGrainToFeedPeople(bushels);
            int acresPlanted = askHowManyAcresToPlant(acres, people, bushels);
            yearlySummary();
//        } else (population <= 0)
//                endGame();
        }
    }

    Random random = new Random();  // this is an instance variable
    int year = 0;
    int temp = 0;
    int people = 100;
    int bushels = 2800;
    int acres = 1000;
    int price = 19;
    public boolean plague;
    int percentDied = 0;
    int totalDeaths = 0;

    //static int totalDeaths = 0, percentDied = 0, year = 0, population = 95, stores = 2800, immigrants = 5, deaths, harvest = 3000, yeild = 3, acres = harvest / yeild, eaten = harvest - stores, landPrice, fullPeople, temp;

    void announceGame() {
        System.out.println("HAMURABI!\n" + "TRY YOUR HAND AT GOVERNING ANCIENT SUMERIA\nSUCCESSFULLY FOR A TEN-YEAR TERM OF OFFICE.\n\n I BEG TO REPORT TO YOU, IN YEAR 1: \n  -0 PEOPLE STARVED.\n  -5 CAME TO THE CITY.\n" + "  -POPULATION IS NOW 100.\n" + "  -THE CITY NOW OWNS 1000 ACRES.\n" + "  -YOU HARVESTED 19 BUSHELS PER ACRE.\n" + "  -RATS ATE 200 BUSHELS.\n" + "  -YOU NOW HAVE 280 BUSHELS IN STORE\n\n\nLAND IS TRADING AT 19 BUSHELS PER ACRE.");
    }

    int askHowManyAcresToBuy(int price, int bushels) {
        while (true) {
            try {
                System.out.print("HOW MANY ACRES DO YOU WISH TO BUY?  ");
                Integer userInput = scanner.nextInt();
                if (userInput * price <= bushels) {
                    acres += userInput;
                    this.bushels -= userInput * price;
                    return userInput;
                } else {
                    System.out.println("HAMURABI:  THINK AGAIN. YOU HAVE ONLY\n" + this.bushels + " BUSHELS OF GRAIN. NOW THEN,");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number!");
                scanner.next();
            }
        }
    }
    int askHowManyAcresToSell(int acresOwned) {
        //Asks the player how many acres of land to sell, and returns that number. You can't sell more than you have.Do not ask this question if the player is buying land; it doesn't make sense to do both in one turn
        while (true) {
            try {
                System.out.print("HOW MANY ACRES DO YOU WISH TO SELL?  ");
                Integer userInput = scanner.nextInt();
                if (userInput <= acresOwned) {
                    acres -= userInput;
                    bushels += userInput * price;
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
    int askHowMuchGrainToFeedPeople(int bushels) {
        //Ask the player how much grain to feed people, and returns that number. You can't feed them more grain than you have. You can feed them more than they need to survive.
        while (true) {
            try {
                System.out.print("HOW MANY BUSHELS DO YOU WISH TO FEED YOUR PEOPLE?  ");
                Integer userInput = scanner.nextInt();
                if (userInput <= bushels) {
                    this.bushels -= userInput;
                    return userInput;
                } else {
                    System.out.println("THINK AGAIN. YOU HAVE ONLY\n" + this.bushels + " BUSHELS OF GRAIN. NOW THEN,");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number!");
                scanner.next();
            }
        }
    }
    int askHowManyAcresToPlant(int acresOwned, int people, int food) {
        //Ask the player how many acres to plant with grain, and returns that number. You must have enough acres, enough grain, and enough people to do the planting. Any grain left over goes into storage for next year.
        while (true) {
            try {
                System.out.print("HOW MANY ACRES DO YOU WISH TO PLANT WITH SEED?  ");
                Integer userInput = scanner.nextInt();

                if (userInput <= acres && userInput <= people * 10 && userInput <= bushels) {
                    return userInput;
                } else if (!(userInput <= acres)){
                    System.out.println("THINK AGAIN. YOU OWN ONLY " + acres + " ACRES.");
                } else if (!(userInput <= people * 10)){
                    System.out.println("THINK AGAIN. YOU HAVE ONLY" + people + "PEOPLE TO TEND THE FIELDS.");
                } else if (!(userInput <= bushels)){
                    System.out.println("THINK AGAIN. YOU HAVE ONLY OWN " + bushels + " BUSHELS OF GRAIN.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number!");
                scanner.next();
            }
        }
    }

    public int plagueDeaths(int population){
        //Each year, there is a 15% chance of a horrible plague. When this happens, half your people die. Return the number of plague deaths (possibly zero).}
        int plagueRandom = random.nextInt(100);
        int peopleDeadInPlague = 0;

        if (plagueRandom < 15){
            if (population % 2 == 0){
                peopleDeadInPlague = population / 2;
                people -= peopleDeadInPlague;
            } else {
                peopleDeadInPlague = (population - 1) / 2;
                people -= peopleDeadInPlague;
            }
            System.out.println("A HORRIBLE PLAGUE STRUCK! HALF THE PEOPLE DIED.\n");
        }
        return peopleDeadInPlague ;
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

    int grainEatenByRats(int bushels) {
        //There is a 40% chance that you will have a rat infestation. When this happens, rats will eat somewhere between 10% and 30% of your grain. Return the amount of grain eaten by rats (possibly zero).
//        int ratInfestation = random.nextInt(100) + 1;
//        int ratsEat = random.nextInt(21) + 10;
//        int grainsEaten = 0;
//        if (ratInfestation == true) {
//            grainsEaten = bushels - ratsEat;
//
//
//        }
        return 0;
    }

    int newCostOfLand() {
        //The price of land is random, and ranges from 17 to 23 bushels per acre. Return the new price for the next set of decisions the player has to make. (The player will need this information in order to buy or sell land.)
        Random random  = new Random();
        int landPrice =  random.nextInt(7) + 17;

        return landPrice;
    }

    public void yearlySummary(){
        System.out.println("\n HAMMURABI!\n" +
                "You are in year " + year + " of your ten year rule.\n" +
                "In the previous year " + temp + " people starved to death.\n" +
                "In the previous year " + temp + " people entered the kingdom.\n" +
                "The population is now " + people + ".\n" +
                "We harvested " + bushels + " bushels at " + price +  " bushels per acre.\n" +
                "Rats destroyed " + temp + " bushels, leaving " + temp + " bushels in storage.\n" +
                "The city owns " + temp + " acres of land.\n" +
                "Land is currently worth " + temp + " bushels per acre.");
    }
    public void endGame(){
        System.out.println("IN YOUR 10-YEAR TERM OF OFFICE, " + percentDied + " PERCENT OF THE\n" + "POPULATION STARVED PER YEAR ON AVERAGE, I.E., A TOTAL OF\n" + totalDeaths + " PEOPLE DIED!!\n" + "YOU STARTED WITH 10 ACRES PER PERSON AND ENDED WITH\n" + acres / people + " ACRES PER PERSON\n\n");

        if (percentDied > 33 || acres / people < 7){
            System.out.println("DUE TO THIS EXTREME MISMANAGEMENT YOU HAVE NOT ONLY\n" + "BEEN IMPEACHED AND THROWN OUT OF OFFICE BUT YOU HAVE\n" + "ALSO BEEN DECLARED PERSONA NON GRATA!!\n");
        }
        else if (percentDied > 10 || acres / people < 9) {
            System.out.println("YOUR HEAVY-HANDED PERFORMANCE SMACKS OF NERO AND IVAN IV.\n" + "THE PEOPLE (REMAINING) FIND YOU AN UNPLEASANT RULER, AND,\n" + "FRANKLY, HATE YOUR GUTS!");
        }
		else if (percentDied > 3 || acres / people < 10) {
            System.out.println("YOUR PERFORMANCE COULD HAVE BEEN SOMEWHAT BETTER, BUT\n" + "REALLY WASN'T TOO BAD AT ALL.\n" + Math.random() * people * .8 + " PEOPLE WOULD" + "DEARLY LIKE TO SEE YOU ASSASSINATED BUT WE ALL HAVE OUR" + "TRIVIAL PROBLEMS");
        } else {
            System.out.println("FANTASTIC PERFORMANCE!!!\n\n\n\n\n\n\n\n\n\n So long for now!");
        }
    }
}

