package lesson2;

import java.util.Arrays;
import java.util.Scanner;

/*
Спросить у пользователя целое положительное число m
Создать целочисленный массив длины m
С помощью цикла (for или while) заполнить этот массив из ввода пользователя,
т.е. спросить у пользователя целое число m раз и записать эти числа по очереди в массив
Вывести массив с помощью Arrays.toString()
Задание со "звёздочкой":
рассчитать сумму элементов в массиве и вывести её
 */
public class HW5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество элементов");
        int m = sc.nextInt();
        int[] ints = new int[m];

        int sum = 0;
        for (int i = 0; i < ints.length; i++) {
            System.out.println("Введите элемент по индексу " + i);
            int input = sc.nextInt();
            ints[i] = input;
            sum += input;
        }

        System.out.println(Arrays.toString(ints));
        System.out.println("Сумма элементов = " + sum);
    }
}
