*Задание 2*

try { 

    int d = 0;  
    double catchedRes1 = intArray[8] / d;  
    System.out.println("catchedRes1 = " + catchedRes1);  
} catch (ArithmeticException e) {
    
    System.out.println("Catching exception: " + e);  
}

**Ошибки** 
 
**int intArray[8]** - не объявлен. 

*Задание 3*

public static void main(String[] args) throws Exception {  

    try {  
       int a = 90;  
       int b = 3;  
       System.out.println(a / b);  
       printSum(23, 234);  
       int[] abc = { 1, 2 };  
       abc[3] = 9;  
    } catch (Throwable ex) {  
       System.out.println("Что-то пошло не так...");  
    } catch (NullPointerException ex) {  
       System.out.println("Указатель не может указывать на null!");  
    } catch (IndexOutOfBoundsException ex) {  
       System.out.println("Массив выходит за пределы своего размера!");  
    }  
}  

public static void printSum(Integer a, Integer b) throws FileNotFoundException { 

    System.out.println(a + b);   
}  

**Ошибки**  
+ **throws Exception** - избыточно, т.к. программа обрабатывает исключения в блоках try-catch.  
+ **Throwable ex** должно быть обработано в самом последнем catch, иначе до других catch программа не дойдет.  
+ **throws FileNotFoundException** - избыточно. Это не ошибка из-за которой упадет программа, но в данном коде это иключение бессмысленно.