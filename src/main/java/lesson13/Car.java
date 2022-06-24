package lesson13;

public class Car implements Comparable<Car> {
    String brand;
    double maxSpeed;
    int seats;

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", seats=" + seats +
                '}';
    }

    public Car() {
    }

    public Car(String brand, double maxSpeed, int seats) {
        this.brand = brand;
        this.maxSpeed = maxSpeed;
        this.seats = seats;
    }

    @Override
    public int compareTo(Car car) {
        // Сравнение машин по максимальной скорости
//        return Double.compare(maxSpeed, car.maxSpeed);
        // Сравнение машин по количеству сидений
//        return seats - car.seats;
        // Сравнение по скорости и если она совпадает, то сравнение по количеству сидений
        int compareSpeed = Double.compare(maxSpeed, car.maxSpeed);
        if (compareSpeed != 0) {
            return compareSpeed;
        }
        return Integer.compare(seats, car.seats);
    }
}
