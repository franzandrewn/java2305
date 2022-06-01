package lesson3;

/*
Внутри класса HW2 написать метод с именем repeatString, который принимает строку s и целое число num как аргументы
и выводит строку s на экран num раз (нет возвращаемого значения)
Например, если в psvm вызвать repeatString("asd",2), то в консоли должно быть "asdasd"
 */
public class HW2 {
    static void repeatString(String s, int num) {
        for (int i = 0; i < num; i++) {
            System.out.print(s);
        }
    }

    public static void main(String[] args) {
        repeatString("asd", 2);
        repeatString("qwe", 0);
    }
}
