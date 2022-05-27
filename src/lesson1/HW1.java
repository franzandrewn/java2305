package lesson1;

// Код для всех задач в ДЗ писать внутри соответствующих классов
// То есть в этом файле надо писать код внутри psvm
// Из-за большого количества точек входа psvm
// лучше всего запускать программы с помощью зеленых стрелок около строк кода
/*
Создать три переменные с любыми значениями:
    x целого типа short
    y целого типа int
    z целого типа long
Вывести в консоль результат их сложения и произведения в двух строках
Вывести в консоль результат сравнения на равенство произведения x и y с числом z
Пример: для чисел 2, 3 и 6 вывод будет
11 (потому что 2 + 3 + 6 = 11)
36 (потому что 2 * 3 * 6 = 36)
true (потому что 2 * 3 равно 6)
 */
public class HW1 {
    public static void main(String[] args) {
        short x = 4;
        int y = 16;
        long z = 10_000_000_000L;

        System.out.println(x + y + z);
        System.out.println(x * y * z);
        System.out.println(x * y == z);


        long sum = x + y + z;
        long prod = x * y * z;
        boolean eq = x * y == z;
        System.out.println(sum);
        System.out.println(prod);
        System.out.println(eq);
    }
}
