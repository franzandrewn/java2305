package lesson7;

/*
Создать класс Customer
с 3 полями:
    целое число id
    строка name
    целое число age
конструктор, задающий все три поля
два метода:
    String customerType(),
        который вернет "deny" для возраста <14,
        "teen" для 14<=age<21
        "regular" для 21<=age<65
        "retiree" для age>=65
    переопределить toString(), для вывода в формате "name[customerType()]{id}"
Создать класс Account
с 3 полями:
    целое число id
    объект класса Customer с именем customer
    дробное число balance
два конструктора:
    один принимает целое число для id и ссылку на объект Customer (balance при этом будет 0.0)
    другой принимает целое число для id, ссылку на объект Customer и дробное число для balance
четыре метода:
    double put(double sum), который увеличивает balance на sum и возвращает balance
    double withdraw(double sum), который при возможноcти (balance - sum >= 0) уменьшает balance на sum и возвращает balance
    double deposit(int yearsNum, double percent), который расчитывает сколько будет денег через yearsNum лет
     под определенным количеством процентов
    переопределить toString(), для вывода в формате "name[customerType()]{id}: balance"
 */
public class HW3 {
    public static void main(String[] args) {

    }
}
