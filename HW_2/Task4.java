/*
Разработайте программу, которая выбросит Exception, когда пользователь
вводит пустую строку. Пользователю должно показаться сообщение, 
что пустые строки вводить нельзя
*/

package HW_Exception.HW_2;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) { 
        String input = "";
        Scanner in = new Scanner(System.in);
        do {
            input = in.nextLine();
            if (input.isEmpty()) {
                in.close();
                throw new RuntimeException ("Empty lines are not allowed");
            } 
        } while (!input.equals("Q"));
        in.close();
    }
}


