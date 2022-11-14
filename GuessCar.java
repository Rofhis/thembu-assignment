import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class GuessCar {

    private String selectRandomCar(List<String> list) {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }

    private void displayCars(List<String> cars) {
        System.out.printf("+======+====================+%n");
        System.out.printf("| %-4s | %-18s |%n", "#", "NAMES OF THE CARS");
        System.out.printf("+======+====================+%n");

        for (int i = 0; i < cars.size(); i++) {
            System.out.printf("| %-4d | %-18s |%n", (i + 1), cars.get(i));
            System.out.printf("+------+--------------------+%n");
        }
    }

    public void guessTheCar() {
        ArrayList<String> cars = new ArrayList<>();
        cars.add("Toyota");
        cars.add("Mazda");
        cars.add("Hyundai");
        cars.add("Kia");
        cars.add("Audi");
        cars.add("Ford");
        cars.add("Isuzu");
        cars.add("Volkswagen");
        cars.add("Porch");
        cars.add("BMW");

        String userInput = "";
        int nextInt = -1;

        int totalTries = 3;
        int tryNumber = 0;
        boolean canPlay = true;
        Scanner scanner = new Scanner(System.in);

        String selectedCar = selectRandomCar(cars);

        displayCars(cars);

        System.out.println("\nA car is chosen randomly from the list above.\n\nGuess the car within 3 tries.");
        System.out.println("\nEnter '1' to quit");

        while (canPlay) {
            tryNumber++;

            if (tryNumber == 1) {
                System.out.println("==============================================================================");
                System.out.println("\nEnter the name of the car selected?\n");
            }

            if (scanner.hasNextInt()) {
                userInput = "";
                nextInt = scanner.nextInt();
            } else {
                nextInt = -1;
                userInput = scanner.next();
            }

            if (selectedCar.equalsIgnoreCase(userInput)) {
                cars.remove(selectedCar);
                System.out.printf("\nCongratulations, you've guessed the correct car\nNumber of car: %s", cars.size());
                System.out.println("\nEnter 0 to play again\nEnter 1 to quit");
            } else if (nextInt == 0) {
                guessTheCar();
            } else if (nextInt == 1) {
                System.out.println("\nThank you for playing!!");
                scanner.close();
                break;
            } else {
                if (tryNumber == 1) {
                    System.out.printf(
                            "\nIncorrect car entered, please try again.\n\nHint: It starts with the letter '%s'\n",
                            String.valueOf(selectedCar.charAt(0)).toUpperCase());
                } else if (tryNumber == 2) {
                    System.out.printf("\nIncorrect car entered, please try again.\n\nHint: It has %s letters\n",
                            selectedCar.length());
                } else if (tryNumber == totalTries) {
                    System.out.printf("\nYou have exhausted %s tries.", totalTries);
                    System.out.printf("\nThe selected car is %s", selectedCar);
                    System.out.println("\nEnter 0 to play again\nEnter 1 to quit\n");
                }
            }
        }
    }

    public static void main(String[] args) {
        GuessCar cars = new GuessCar();
        cars.guessTheCar();
    }
}