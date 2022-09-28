import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class CarRental {
    static String[] brands = {"Mercedes", "BMW", "Volkswagen", "Fiat", "Audi"};
    static String[] names = {"GLS", "X5", "Golf", "Punto", "SQ8"};
    static String[] colors = {"White", "Light Gray", "Dark Gray", "Black", "Blue", "Yellow", "Chrome"};
    Car[] cars;
    ArrayList<Car> rentedCars = new ArrayList<Car>();

    public CarRental(int carQuantity) {
        this.cars = new Car[carQuantity];

        Random rand = new Random();                //random generator

        for (int i = 0; i < carQuantity; i++)
            this.cars[i] = new Car(rand.nextInt(420), rand.nextInt(200), rand.nextInt(10) + 1, names[rand.nextInt(names.length)], colors[rand.nextInt(colors.length)], brands[rand.nextInt(brands.length)]);
    }

    public ArrayList<Car> findCars(String brand, String name, String color) {

        ArrayList<Car> filtered = new ArrayList<Car>();

        // add every car of cars[], remove again if search term is not blank and the search terms are equal (capitalisation & too many whitespace characters are ignored)
        for (int i = 0; i < cars.length; i++) {
            filtered.add(cars[i]);

            if (!brand.isBlank() && !cars[i].brand.toLowerCase().replaceAll("\\s+", "").equals(brand.toLowerCase().replaceAll("\\s+", "")))
                filtered.remove(cars[i]);
            if (!name.isBlank() && !cars[i].name.toLowerCase().replaceAll("\\s+", "").equals(name.toLowerCase().replaceAll("\\s+", "")))
                filtered.remove(cars[i]);
            if (!color.isBlank() && !cars[i].color.toLowerCase().replaceAll("\\s+", "").equals(color.toLowerCase().replaceAll("\\s+", "")))
                filtered.remove(cars[i]);
        }

        return filtered;
    }

    public boolean isAvailable(Car car) {
        return !rentedCars.contains(car);
    }

    public boolean rent(Car car) {
        if (isAvailable(car)) {
            rentedCars.add(car);
            return true;
        }
        return false;
    }

    public boolean returnCar(Car car) {
        return rentedCars.remove(car);
    }

    public void printCars() {
        for (int i = 0; i < cars.length; i++)
            System.out.printf("ID: [%d]\t|\t%s\t|\t%s\t|\t%s\n", i, cars[i].brand, cars[i].name, cars[i].color);
    }
}