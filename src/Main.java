import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        int num1;                                           // первое введенное число
        int num2;                                           // второе введенное число
        char mainOperation;                                 // необходимая операция
        int ans;                                            // результат\ответ (answer)

        Scanner userInput = new Scanner(System.in);
        System.out.println("\nВведите выражение:");         // запрашиваем исходные данные в заданном заданием формате

        String mainInput = userInput.nextLine();
        String[] arr = mainInput.split(" ", 3);  // считываем данные массивом с помощью Array
                                                            // и разделяем на 3 переменные типа string
        String firstValue = arr[0];                         // получится 2 операнды и операция
        String operation = arr[1];
        String thirdValue = arr[2];
        mainOperation = operation.charAt(0);                // конвертировал значение операции из "строки" в "символ" для личного удобства, не принципиально
        int operationLength = operation.length();
        if (operationLength > 1) {                          // отсекаем варианты с ++ -- итд
            throw new IOException("Ошибка! Формат математической операции не удовлетворяет заданию. ");
            }

        // Вариант рассчетов для римских цифр
        if ((firstValue.contains("I") || (firstValue.contains("V")) || (firstValue.contains("X"))) &&
                ((thirdValue.contains("I") || (thirdValue.contains("V")) || (thirdValue.contains("X"))))) {
            num1 = convert(firstValue);
            num2 = convert(thirdValue);
            if ( num1 == 0 || num1 > 10 || num2 == 0 || num2 > 10) {            // отсекаем не валидные значения
                throw new IOException("Ошибка! Введенные числа должны быть от I до X.");}
            ans = calculated(num1, num2, mainOperation);
            if ( ans <= 0 ) {
                throw new IOException("Ошибка! Результат не может быть отрицательным."); }
            String resultRoman = NumToRoman(ans);                               // перевод из арабской в римскую систему
            System.out.println(resultRoman); System.exit(0);

        // в противном случае, вариант рассчетов для арабских цифр
        } else
            num1 = Integer.parseInt(firstValue);
            num2 = Integer.parseInt(thirdValue);
            if (num1 > 10 || num1 <= 0 || num2 <= 0 || num2>10) {                   // отсекаем не валидные значения
                throw new IOException("Ошибка! Введенные числа должны быть от 1 до 10.");}
            ans = calculated(num1, num2, mainOperation);
            System.out.println(ans); System.exit(0);
    }

    // функция конвертации римских чисел в арабские, согласно условию задания вводить можно числа от 1 до 10
    public static int convert(String a) {
        if (a.equals("I")) return 1;
        if (a.equals("II")) return 2;
        if (a.equals("III")) return 3;
        if (a.equals("IV")) return 4;
        if (a.equals("V")) return 5;
        if (a.equals("VI")) return 6;
        if (a.equals("VII")) return 7;
        if (a.equals("VIII")) return 8;
        if (a.equals("IX")) return 9;
        if (a.equals("X")) return 10;
        return 0;
    }

    //функция определения операции
    public static int calculated(int num1, int num2, char mainOperation) throws IOException {
        int ans = 0;
        switch (mainOperation) {
            case '+' -> ans = num1 + num2;
            case '-' -> ans = num1 - num2;
            case '*' -> ans = num1 * num2;
            case '/' -> ans = num1 / num2;
            default -> throw new IOException("Ошибка! Формат математической операции не удовлетворяет заданию. ");

        }
        return ans;
    }

    // Функция для перевода арабского числа в римское. Да, решенение не самое элегантное, просто перебрал все варианты,
    // благо их не так уж и много. Гуглил и видел решения через ENUM и всякие компораторы и стрим коллекторы(и прочие
    // непонятные слова). Ради интереса даже вставлял к себе в код и в принципе всё работало. Но для меня субъективно на
    // данном этапе проще было исользовать "брут форс" так как тут я хотя бы понимаю принцип работы. Хотя объективно
    // другие варианты более масштабируемы и удобны в будущем.
    private static String NumToRoman (int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV",
            "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII",
            "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV",
            "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII",
            "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI",
            "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        return roman[numArabian];
    }
}
