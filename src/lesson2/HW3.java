package lesson2;

import java.util.Scanner;

/*
Спросить у пользователя одно целое число типа int
С помощью цикла while вывести столько же раз фразу "Цикл while"
 */
public class HW3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 0) {
            n = -n;
        }
        n = n < 0 ? -n: n;
        n = Math.abs(n);


        while (n > 0) {
            System.out.println("Цикл while");
            n--;
        }
    }
}
