import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean end = false;

        System.out.println("How many cars would you like to create?\n");
        int carQuantity = sc.nextInt(); //TODO: Check for valid input
        CarRental carRental = new CarRental(carQuantity);

        while (!end) { //TODO: Check for valid input
            sc.nextLine();

            System.out.println("\nWhat do you like to do?\n\t[0] Terminate Program\n\t[1] Search for a Car\n\t[2] Print all Cars\n\t[3] Check if a car is available for renting\n\t[4] Rent a car\n\t[5] Give back a rented Car\n");

            int in = sc.nextInt();

            int whichID = -1;

            switch (in) {
                case 0 -> {
                    end = true;
                    break;
                }
                case 1 -> {
                    System.out.println("\nInput your desired car brand, car name and car color in a row! | Press enter to confirm each time! | Leave empty if not interested in!");
                    ArrayList<Car> filtered = carRental.findCars(sc.nextLine(), sc.nextLine(), sc.nextLine());
                    System.out.println("The following cars were found: " + filtered);
                }
                case 2 -> {
                    System.out.println("List of all cars:\n");
                    for (int i = 0; i < carQuantity; i++)
                        System.out.printf("ID: [%d]\t|\t%s\t|\t%s\t|\t%s\n", i, carRental.cars[i].brand, carRental.cars[i].name, carRental.cars[i].color);
                }
                case 3 -> {
                    System.out.println("Enter the ID of the car to check for it's availability: ");
                    while (whichID < 0 || whichID > carQuantity - 1) whichID = sc.nextInt(); //TODO: CHANGE
                    sc.nextLine();
                    System.out.printf("%s!", (carRental.isAvailable(carRental.cars[whichID])) ? colorCodes.green + "Car available!" + colorCodes.reset : colorCodes.red + "Unfortunately the car isn't available" + colorCodes.reset);
                }
                case 4 -> {
                    System.out.println("Which car (enter the ID) do you want to rent?");
                    while (whichID < 0 || whichID > carQuantity - 1) {
                        whichID = sc.nextInt();
                        System.out.println(colorCodes.red + "Invalid input. Try again!\n" + colorCodes.reset);
                    }
                    sc.nextLine();
                    System.out.printf((carRental.rent(carRental.cars[whichID])) ? colorCodes.green + "The was successfully rented." + colorCodes.reset : colorCodes.red + "The car couldn't be rented." + colorCodes.reset);
                }
            }
        }
    }
}