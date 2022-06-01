package lesson2;

import java.util.Scanner;

/*
Спросить у пользователя число
Если оно попадает в диапазон от 1 до 100 или в диапазон от -1000 до -100, вывести в консоль "+"
Если оно не попадает ни в один из этих диапазонов, вывести "-"
 */
public class HW1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        if ((x >= 1 && x <= 100) || (x >= -1000 && x <= -100)) {
            System.out.println("+");
        } else {
            System.out.println("-");
        }

        if (x >= 1 && x <= 100) {
            System.out.println("+");
        } else if (x >= -1000 && x <= -100)  {
            System.out.println("+");
        } else {
            System.out.println("-");
        }
    }
}
