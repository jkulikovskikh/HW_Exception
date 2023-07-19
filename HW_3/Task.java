package HW_Exception.HW_3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Task {

    public static int checkSizeOfInputData(String[] str) {
        if (str.length < 6) {
            System.out.println("Entered less input data");
            return -1;
        } else if (str.length > 6) {
            System.out.println("Entered more input data");
            return -1;
        } else {
            return str.length;
        }
    }

    public static boolean checkStringOnAlphabet(String s) {
        if (s.matches("^[a-zA-Z]*$")) {
            return true;
        } else if (s.matches("^[а-яА-Я]*$")) {
            return true;
        }
        return false;
    }

    public static boolean checkParseOfInputData(String[] str) {
        try {
            String surname = str[0];
            if(!checkStringOnAlphabet(surname)) {
                throw new RuntimeException("Surname consists of more than just letters");
            }
            String name = str[1];
            if(!checkStringOnAlphabet(name)) {
                throw new RuntimeException("Name consists of more than just letters");
            }
            String fathername = str[2];
            if(!checkStringOnAlphabet(fathername)) {
                throw new RuntimeException("Fathername consists of more than just letters");
            }
            Date birthday = new SimpleDateFormat("dd.MM.yyyy").parse(str[3]);
            int numberPhone = Integer.parseInt(str[4]);
            if (numberPhone < 0) {
                throw new RuntimeException("Phone number cannot be negative");
            }
            Character sex = str[5].toLowerCase().charAt(0);
            if (!sex.equals('m') && !sex.equals('f')) {
                throw new RuntimeException("Sex can only be m or f");
            }
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static void writeInputData(String[] str) {
        String nameFile = "HW_Exception/HW_3/" + str[0] + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nameFile, true))) {
            for (int i = 0; i < str.length; i++) {
                writer.write("<" + str[i] + ">");
            }
            writer.write("\n");
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } 
    }

    public static void main(String[] args) {
        String[] input;
        Scanner in = new Scanner(System.in, "Cp866");
        System.out.println("Введите через пробел:" + "\n" +
                "Фамилия" + "\n" + "Имя" + "\n" + "Отчество" + "\n" +
                "Дата рождения" + "\n" + "Номер телефона" + "\n" + "Пол");
        input = in.nextLine().split(" ");
        in.close();

        if (checkSizeOfInputData(input) > 0) {
            if(checkParseOfInputData(input)) {
                writeInputData(input);
            }
        }
    }
}