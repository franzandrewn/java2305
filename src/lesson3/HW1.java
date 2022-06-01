package lesson3;

/*
Внутри класса HW1 добавить метод с именем div, который принимает два дробных числа
и возвращает их частное
В psvm проверить работу метода с помощью вывода в консоль результата работы метода с числами 5 и 7
Должно вывести 0.7142857142857143
 */
public class HW1 {
    static double div(double x, double y) {
        return x / y;
    }

    public static void main(String[] args) {
        System.out.println(div(5.0, 7.0));
        System.out.println(div(5.0, 0.0));
    }
}
