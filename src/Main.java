public class Main {
    // psvm - аббревиатура для создания точки входа
    public static void main(String[] args) {
        // Комментарии - часть кода, которая не выполняется
        /* Многострочный комментарий
        Весь текст до звездочки+черты не выполняются
         */
        // Вывод на экран, аббревиатура sout
//        System.out.println("Hello java2305");
//        System.out.println("123");
//        System.out.println(1 + 3);

        // Арифметические операции с целыми числами
//        System.out.println(7 + 3);
//        System.out.println(7 - 3);
//        System.out.println(7 * 3);
//        System.out.println(7 / 3); // целочисленное деление
//        System.out.println(7 % 3); // взятие остатка от деления

        // Арифметические операции с дробными числами
//        System.out.println(7.0 + 3.0);
//        System.out.println(7.0 - 3.0);
//        System.out.println(7.0 * 3.0);
//        System.out.println(7.0 / 3.0); // полное деление
//        System.out.println(7.0 % 3.0); // взятие остатка от деления

        // Операция склеивания строк
//        System.out.println("Hello " + "java2305");

        // task1
        /*
        Человек положил на вклад 120 000 у.е. под 17.0% годовых
        Вывести на экран сколько у человека будет через год
        Формула для рассчета: сумма_после = сумма_до * (1 + проценты/100)
         */
//        System.out.println(120000 * (1 + 17.0 / 100));
//        System.out.println(120000 * (1 + 17 / 100)); // 17 / 100 = 0, поэтому ответ неверный

        // Переменная - именованное значение
        // Создание переменной
        // тип_данных имя_переменной;
        int number;
        // Инициализация переменной
        number = 4;
//        System.out.println(number);
//        System.out.println(number + 100);

        // Создание и инициализация в одну строку
        int number2 = 4;

        // Создание переменной для суммы вклада
        int sum = 120000;
        // Создание переменной для процента
        double percent = 17.0;

        // Расчёт суммы после года и создание переменной с этим значением
        double sumAfterYear = sum * (1 + percent / 100);
//        System.out.println(sumAfterYear);

        // Имена переменных - начинаются на букву (обычно на маленькую),
        // после первого символа можно использовать цифры и нижнее подчеркивание
        // Для сложных имен действует camelCase - все пишется слитно, слова выделяются большими буквами
        // Если есть аббревиатура, обычно её пишут как другие слова (не жесткое правило, можно нарушать)
        int ageOfMsu;
//        System.out.println("Возраст МГУ = 200+ лет");


        // Ctrl + Alt + L - приведение к "правильному" формату

        // Типы данных
        // Две группы типов данных: примитивные и ссылочные
        // Примитивные типы данных
        // Целые числа
        // byte, 1 байт, [-128..127]
        byte b = 126;

        // short, 2 байта, [-32768..32767]
        short s = -32768;

        // int, 4 байта, [-2^31..2^31-1]
        int i = 2_000_000_000;

        // long, 8 байт, [-2^63..2^63-1]
        long l = 3_000_000_000L;

        // Дробные числа
        // double, 8 байт
        double d = 0.0000000001;

        // float, 4 байта
        float f = 0.0000000001f;

        // Дробные числа подчиняются IEEE 754
        // Дробные числа хранятся с определенной точностью, поэтому операции над ними тоже имеют точность
//        System.out.println(0.2 + 0.3);
//        System.out.println(0.5 + 0.25);

        // Символьный тип
//        char, 4 байта
        char c = 'b';
//        System.out.println(c);
//        System.out.println((int) c);
//        System.out.println((char) 33);
//        System.out.println(c + 1);
//
//        System.out.println('Ц');
//        System.out.println((int) 'Ц');
//
//        System.out.println('语');
//        System.out.println((int) '语');

        // Логический тип данных
        // Два значения - true и false
        boolean bool = false;
//        System.out.println(bool);

        // Сравнения
//        System.out.println(5 > 3); // больше
//        System.out.println(5 < 3); // меньше
//        System.out.println(5 >= 5); // больше-равно
//        System.out.println(5 <= 5); // меньше-равно
//
//        System.out.println(5 == 5); // равно
//        System.out.println(5 != 4); // не равно

        // Ссылочный тип данных
        // Строковый тип
        String str = "Это строка - текстовый тип";
//        System.out.println(str);
//        System.out.println(str.length());
//
//        System.out.println(str.toUpperCase());
//        System.out.println(str.toLowerCase());
//
//        System.out.println(str.indexOf('с')); // порядковый номер (индекс) начинается с 0
//        System.out.println(str.indexOf('Э'));
//
//        System.out.println(str.lastIndexOf('с'));
//        System.out.println(str.indexOf('s'));
//
//        System.out.println(str.indexOf("строка"));
//
//        System.out.println(str.charAt(0));
//        System.out.println(str.charAt(4));
        str = "";
//        System.out.println(str.isEmpty());

        // Ветвление
        // Оператор if (условный оператор)
        if (5 > 0) {
            System.out.println("Условние выполнилось");
        } else {
            // блок кода else
            System.out.println("Условние не выполнилось");
        }

        System.out.println("Действие после оператора if");

        // task2
        /*
        Человек положил на счёт 88888 у.е. под 12.0% годовых
        Расчитать сумму после года на счету и если сумма > 100000, вывести "Накоплено 100000"
        Сумма_до, проценты и сумма_после - переменные типа double
        Формула для рассчета: сумма_после = сумма_до * (1 + проценты/100)
         */
        double sumBefore = 88_888;
        double p = 13;
        double sumAfter = sumBefore * (1 + p / 100);

        if (sumAfter > 100_000) {
            System.out.println("Накоплено 100000");
        } else {
            System.out.println("Не накоплено 100000");
        }

        // Преобразование типов
        // Восходящее преобразование - тип данных меньшей длины преобразуем в тип данных большей длины
        // Автоматически выполняется
        int n = 1000;
        long longN = n;

        // Нисходящее преобразование - тип данных большей длины преобразуем в тип данных меньшей длины
        // Автоматически не может быть выполнено
        longN = 3_000_000_000L;
        n = (int) longN;
        System.out.println(n);

        longN = 10000;
        n = (int) longN;
        System.out.println(n);

        short shortS = 32767;
        byte byteB = (byte) shortS;
        System.out.println(byteB);

        System.out.println(Byte.MAX_VALUE);
        System.out.println(Byte.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
    }
}
