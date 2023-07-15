/*
Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), 
и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению 
приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.
*/

package HW_Exception.HW_2;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        boolean flag = false;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("Enter the number");
            String input = in.nextLine();
            try {
                float number = Float.parseFloat(input);
                System.out.println(number);
                flag = true;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        } while (!flag);
        in.close();
    }
}