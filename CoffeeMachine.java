package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static int water = 400;
    static int milk = 540;
    static int coffeeBeans = 120;
    static int cups = 9;
    static int money = 550;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String action;
        do {
            System.out.println("Write action (buy, fill, take, remaining, exit)");
        action = scanner.next();
            switch (action) {
                case "buy" -> {
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                    String typeOfCoffee = scanner.next();
                    switch (typeOfCoffee) {
                        case "1" -> {
                            if (water >= 250 && coffeeBeans >= 16 && cups >= 1) {
                                System.out.println("I have enough resources, making you a coffee!\n");
                                water -= 250;
                                coffeeBeans -= 16;
                                money += 4;
                                cups -= 1;
                            } else {
                                if (water < 250) {
                                    System.out.println("Sorry, not enough water!");
                                } else if (coffeeBeans < 16) {
                                    System.out.println("Sorry not enough coffeeBeans!");
                                } else {
                                    System.out.println("Sorry, not enough cups!");
                                }
                            }
                            scanner.nextLine();
                        }
                        case "2" -> {
                            if (water >= 350 && milk >= 75 && coffeeBeans >= 20 && cups >= 1) {
                                System.out.println("I have enough resources, making you a coffee!\n");
                                water -= 350;
                                milk -= 75;
                                coffeeBeans -= 20;
                                money += 7;
                                cups -= 1;
                            } else {
                                if (water < 350) {
                                    System.out.println("Sorry, not enough water!");
                                } else if (milk < 75) {
                                    System.out.println("Sorry, not enough milk!");
                                } else if (coffeeBeans < 20) {
                                    System.out.println("Sorry not enough coffeeBeans!");
                                } else {
                                    System.out.println("Sorry, not enough cups!");
                                }
                            }
                            scanner.nextLine();
                        }
                        case "3" -> {
                            if (water >= 200 && milk >= 100 && coffeeBeans >= 12 && cups >= 1) {
                                System.out.println("I have enough resources, making you a coffee!\n");
                                water -= 200;
                                coffeeBeans -= 12;
                                milk -= 100;
                                money += 6;
                                cups -= 1;
                            } else {
                                if (water < 200) {
                                    System.out.println("Sorry, not enough water!");
                                } else if (milk < 100) {
                                    System.out.println("Sorry, not enough milk!");
                                } else if (coffeeBeans < 12) {
                                    System.out.println("Sorry not enough coffeeBeans!");
                                } else {
                                    System.out.println("Sorry, not enough cups!");
                                }
                            }
                            scanner.nextLine();
                        }
                    }
                }
                case "fill" -> {
                    System.out.println("Write how many ml of water you want to add:");
                    int addWater = scanner.nextInt();
                    water += addWater;
                    System.out.println("Write how many ml of milk you want to add:");
                    int addMilk = scanner.nextInt();
                    milk += addMilk;
                    System.out.println("Write how many grams of coffee beans you want to add:");
                    int addCoffeeBeans = scanner.nextInt();
                    coffeeBeans += addCoffeeBeans;
                    System.out.println("Write how many disposable cups you want to add:");
                    int addCups = scanner.nextInt();
                    cups += addCups;
                    System.out.println();
                }
                case "take" -> {
                    System.out.printf("I gave you $%d", money);
                    money = 0;
                    System.out.println("\n");
                }
                case "remaining" -> {
                    System.out.println();
                    printResources();
                }
                case "exit" -> {
                    return;
                }
            }
        }
        while (!action.equals("exit"));
    }
        public static void printResources () {
            System.out.printf("""
                    The coffee machine has:
                    %d ml of water
                    %d ml of milk
                    %d g of coffee beans
                    %d disposable cups
                    $%d of money\n\n""", water, milk, coffeeBeans, cups, money);
        }
}
