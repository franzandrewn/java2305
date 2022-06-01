package lesson3;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
Задание со "звездочкой"
Внутри класса HW4 написать метод quadraticEq в классе HW4, который принимает три дробных числа a, b и c
и решает квадратное уравнение
Тип возвращаемого значения - массив дробных чисел
(возможно три варианта: 0 корней, 1 корень и 2 корня,
в зависимости от того какой вариант, столько и должно быть элементов в массиве)
Например, аргументы 1 2 1 должны привести к массиву {-1},
потому что у x*x+2*x+1=0 только 1 корень = -1
Аргументы 1 7 12 должны привести к массиву {-3, -4},
потому что x*x+7*x+12=0 имеет два решения -3 и -4
В psvm проверить работу метода на примерах или любых других значениях
Результат работы метода выводить с помощью Arrays.toString()
 */
public class HW4 {
    static double[] quadraticEq(double a, double b, double c) {
        double[] result;
        double dis = b * b - 4 * a * c;
        if (dis > 0) {
            result = new double[2];
            result[0] = (Math.sqrt(dis) - b) / (2 * a);
            result[1] = (-Math.sqrt(dis) - b) / (2 * a);
        } else if (dis == 0) {
            result = new double[1];
            result[0] = -b / (2 * a);
        } else {
            result = new double[0];
        }
        return result;
    }

    static double[] quadraticEqShort(double a, double b, double c) {
        double dis = b * b - 4 * a * c;
        if (dis > 0) {
            double x1 = (Math.sqrt(dis) - b) / (2 * a);
            double x2 = (-Math.sqrt(dis) - b) / (2 * a);
            return new double[]{x1, x2};
        } else if (dis == 0) {
            return new double[]{-b / (2 * a)};
        } else {
            return new double[0];
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(quadraticEq(1, 2, 1)));
        System.out.println(Arrays.toString(quadraticEq(1, 7, 12)));

    }
}
