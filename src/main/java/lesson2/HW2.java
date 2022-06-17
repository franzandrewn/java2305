package lesson2;

import java.util.Arrays;

/*
Создать массив дробных чисел double длиной 5 с именем doubles
Вывести массив с помощью Arrays.toString()
Заполнить по очереди все элементы с помощью операции получения элемента по индексу
Вывести массив с помощью Arrays.toString()
Изменить первый элемент на 1.00001, последний элемент на -0.189
Вывести массив с помощью Arrays.toString()
 */
public class HW2 {
    public static void main(String[] args) {
        double[] doubles = new double[5];
        System.out.println(Arrays.toString(doubles));

        doubles[0] = 1.1;
        doubles[1] = 1.0001;
        doubles[2] = -100.23;
        doubles[3] = 7.9;
        doubles[4] = 1023.1023;
        System.out.println(Arrays.toString(doubles));

        doubles[0] = 1.00001;
        doubles[doubles.length - 1] = -0.189;
        System.out.println(Arrays.toString(doubles));
    }
}
