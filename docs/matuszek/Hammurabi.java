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
        announceGame();
        for (int i = 1; i <= 10 && people > 0; i++) {
            year = i;

            int acresBought = askHowManyAcresToBuy(price, bushels);
            int acresSold = 0;
            if (acresBought == 0){
                 acresSold = askHowManyAcresToSell(acres);
            }
            int grainToFeedPeople= askHowMuchGrainToFeedPeople(bushels);
            int acresPlanted = askHowManyAcresToPlant(acres, people, bushels);

            int plague = plagueDeaths(people);
            int starvedPeople = starvationDeaths(people, bushels);
            int visitors = immigrants(people, acres, bushels);
            int harvest = harvest(acres, bushels);
            int infestation = grainEatenByRats(bushels);
            int landCost = newCostOfLand();

            yearlySummary();
            if(people <= 0){
                endGame();
            }
        }
    }

    Random random = new Random();
    int year = 0;
    int temp = 0;
    int people = 100;
    int bushels = 2800;
    int acres = 1000;
    int price = 19;
    public boolean plague;
    int grainsEaten = 0;
    int acresToHarvest = 0;



    void announceGame() {
        System.out.println("HAMURABI!\n" + "TRY YOUR HAND AT GOVERNING ANCIENT SUMERIA\nSUCCESSFULLY FOR A TEN-YEAR TERM OF OFFICE.\n\n I BEG TO REPORT TO YOU, IN YEAR 1: \n  -0 PEOPLE STARVED.\n  -5 CAME TO THE CITY.\n" + "  -POPULATION IS NOW 100.\n" + "  -THE CITY NOW OWNS 1000 ACRES.\n" + "  -YOU HARVESTED 19 BUSHELS PER ACRE.\n" + "  -RATS ATE 200 BUSHELS.\n" + "  -YOU NOW HAVE 2800 BUSHELS IN STORE\n\n\nLAND IS TRADING AT 19 BUSHELS PER ACRE.");
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
    int askHowManyAcresToPlant(int acresOwned, int people, int bushels) {
        while (true) {
            try {
                System.out.print("HOW MANY ACRES DO YOU WISH TO PLANT WITH SEED?  ");
                Integer userInput = scanner.nextInt();

                int maxAcresByPeople = people * 10; // Each person can farm 10 acres
                int maxAcresByBushels = bushels / 2; // It takes 2 bushels to farm an acre

                if (userInput <= acresOwned && userInput <= maxAcresByPeople && userInput <= maxAcresByBushels) {
                    bushels -= userInput * 2; // Deduct the bushels used for planting
                    return userInput;
                } else {
                    if (userInput > acresOwned) {
                        System.out.println("THINK AGAIN. YOU OWN ONLY " + acres + " ACRES.");
                    } else if (userInput > maxAcresByPeople) {
                        System.out.println("THINK AGAIN. YOU HAVE ONLY " + people + " PEOPLE TO TEND THE FIELDS.");
                    } else if (userInput > maxAcresByBushels) {
                        System.out.println("THINK AGAIN. YOU HAVE ONLY " + bushels + " BUSHELS OF GRAIN.");
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number!");
                scanner.next(); // This is necessary to clear the buffer
            }
        }
    }

    public int plagueDeaths(int population){
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
        int peopleFed = bushelsFedToPeople / 20; // Each person needs 20 bushels
        int peopleStarved = population - peopleFed;
        return peopleStarved;
    }

    boolean uprising(int population, int howManyPeopleStarved) {
        double starvationRate = (double) howManyPeopleStarved / population * 100;
        if (starvationRate > 45) {
            System.out.println("DUE TO THIS EXTREME MISMANAGEMENT YOU HAVE NOT ONLY\n" + "BEEN IMPEACHED AND THROWN OUT OF OFFICE BUT YOU HAVE\n" + "ALSO BEEN DECLARED PERSONA NON GRATA!!\n");

            return true;
        }
        return false;
    }

    public int immigrants(int population, int acresOwned, int grainInStorage) {
        return ((20 * acresOwned + grainInStorage) / (100 * population)) + 1;
    }

    int harvest(int acres, int bushelsUsedAsSeed) {
        Random random = new Random();
        int randomNumber = random.nextInt(6) + 1;

        if (bushelsUsedAsSeed % 2 == 0) {
            this.acresToHarvest = bushelsUsedAsSeed / 2;
        } else {
            this.acresToHarvest = (bushelsUsedAsSeed - 1) / 2;
        }

        if (this.acresToHarvest <= acres) {
            return this.acresToHarvest * randomNumber;
        } else {
             return acres * randomNumber;
        }

    }

    public int grainEatenByRats(int bushels) {
        int ratInfestation = random.nextInt(100) + 1;
        int ratsEat = random.nextInt(21) + 10;

        if (ratInfestation < 40) {
            this.grainsEaten = bushels * ratsEat;
            this.grainsEaten = Math.round(this.grainsEaten);
        }
        return this.grainsEaten;
    }

    int newCostOfLand() {
        Random random  = new Random();
        int landPrice =  random.nextInt(7) + 17;

        return landPrice;
    }

    public void yearlySummary(){
        System.out.println("\n\nPOPULATION IS NOW " + people + ".\n" +
                "THE CITY NOW OWNS " + acres + " ACRES.\n" +
                "YOU HARVESTED " + this.acresToHarvest + " BUSHELS PER ACRE.\n" +
                "RATS ATE " + grainsEaten + " BUSHELS.\n" +
                "YOU NOW HAVE " + bushels + " BUSHELS IN STORE.\n\n" +
                "LAND IS TRADING AT " + price + " BUSHELS PER ACRE.");
    }
    public void endGame(){
            System.out.println("THANKS FOR PLAYING HAMMURABI!!!\n\n\n\n\n\n\n\n\n\n So long for now!");
    }
}

