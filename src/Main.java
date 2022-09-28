import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean end = false;

        System.out.println("How many cars would you like to create?");
        while (!sc.hasNextInt()) {
            System.out.println(colorCodes.red + "Invalid input. Try again!" + colorCodes.reset);
            sc.nextLine();
        }

        int carQuantity = sc.nextInt();

        CarRental carRental = new CarRental(carQuantity);


        while (!end) {
            System.out.println("\nWhat do you like to do?\n\t[0] Terminate Program\n\t[1] Search for a Car\n\t[2] Print all Cars\n\t[3] Check if a car is available for renting\n\t[4] Rent a car\n\t[5] Give back a rented Car\n");

            while (!sc.hasNextInt()) {
                System.out.println(colorCodes.red + "Invalid input. Try again!" + colorCodes.reset);
                sc.nextLine();
            }

            int in = sc.nextInt();

            int IDChooser = -1;

            switch (in) {
                case 0 -> {
                    end = true;
                    break;
                }
                case 1 -> {
                    //TODO: SEARCH DOESNT WORK
                    System.out.println("\nInput your desired car brand, car name and car color in a row! | Press enter to confirm each time! | Leave empty if not interested in!");
                    ArrayList<Car> filtered = carRental.findCars(sc.nextLine(), sc.nextLine(), sc.nextLine());
                    System.out.println("The following cars were found: " + filtered);
                    break;
                }
                case 2 -> {
                    System.out.println("List of all cars:\n");
                    carRental.printCars();
                    break;
                }
                case 3 -> {
                    System.out.println("Enter the ID of the car to check for it's availability: ");
                    while (IDChooser < 0 || IDChooser > carQuantity - 1) {
                        System.out.println(colorCodes.red + "Invalid ID entered. Try again!\n" + colorCodes.reset);
                        IDChooser = sc.nextInt();
                    }
                    sc.nextLine();
                    System.out.printf("%s!", (carRental.isAvailable(carRental.cars[IDChooser])) ? colorCodes.green + "Car available!" + colorCodes.reset : colorCodes.red + "Unfortunately the car isn't available" + colorCodes.reset);
                    break;
                }
                case 4 -> {
                    carRental.printCars();
                    System.out.println("Enter the ID of the car you want to rent: ");
                    IDChooser = sc.nextInt();
                    while (IDChooser < 0 || IDChooser > carQuantity - 1) {
                        System.out.println(colorCodes.red + "Invalid input. Try again!\n" + colorCodes.reset);
                        IDChooser = sc.nextInt();
                    }
                    sc.nextLine();
                    System.out.printf((carRental.rent(carRental.cars[IDChooser])) ? colorCodes.green + "The car was successfully rented." + colorCodes.reset : colorCodes.red + "The car couldn't be rented." + colorCodes.reset);
                    break;
                }
                case 5 -> {

                    System.out.println("Enter the ID of the car you want to return:");
                    System.out.println(carRental.returnCar(carRental.cars[sc.nextInt()]) ? colorCodes.green + "The car was successfully returned." + colorCodes.reset : colorCodes.red + "The car couldn't be returned." + colorCodes.reset);
                    break;
                }
            }
        }
    }
}