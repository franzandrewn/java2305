package lesson13;

import java.util.Comparator;
import java.util.LinkedList;

public class Main {
    static void multithreading() {
        System.out.println("Main thread starts");
        MyThread myThread1 = new MyThread("myThread1");
        myThread1.start();
        MyThread myThread2 = new MyThread("myThread2");
        myThread2.start();
        for (int i = 1; i <= 5; i++) {
            System.out.println("Main " + i);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            try {
                myThread1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Main thread ends");
    }

    static void comparable() {
        Car car1 = new Car("Porsche", 300, 2);
        Car car2 = new Car("BMW", 290, 4);
        Car car3 = new Car("Mercedes", 290, 2);

        System.out.println(car1.compareTo(car2));
        System.out.println(car2.compareTo(car3));

        LinkedList<Car> cars = new LinkedList<>();
        cars.add(car2);
        cars.add(car3);
        cars.add(car1);
        System.out.println(cars);

        cars.sort(Comparator.comparingInt(c -> c.seats));
        System.out.println(cars);

        cars.sort(Comparator.naturalOrder());
        System.out.println(cars);

        cars.sort(Comparator.comparingDouble(c -> -c.maxSpeed));
        System.out.println(cars);
    }

    public static void main(String[] args) {
//        multithreading();
        comparable();
    }
}
