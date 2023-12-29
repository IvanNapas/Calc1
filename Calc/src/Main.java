import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String[] data = init();

        checkLength(data);

        String operation = data[1];
        int num1 =rimToArab(data[0]);
        int num2 =rimToArab(data[2]);
        boolean isRim = false;
        if (num1 != -100 && num2 != -100){
            isRim = true;
        }else {
            try {
                num1 = Integer.parseInt(data[0]);
                num2 = Integer.parseInt(data[2]);
            }catch (Exception e){
                throw new RuntimeException("throws Exception");
            }
        }

        checkRange (num1, num2);

        int result = switch (operation) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            default -> throw new RuntimeException("throws Exception");
        };
        if (isRim){
            System.out.println(arabToRim(result));
        }else{
            System.out.println(result);
        }

    }
    static String[] init() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите два числа (арабских или римских): ");
        String expression = scanner.nextLine();
        return expression.split(" ");
    }
    static void checkLength(String[] data){
        if (data.length != 3){
            throw new RuntimeException("throws Exception");
        }
    }
    static void checkRange(int num1, int num2){
        if((num1 < 1 || num1 >10) || (num2 < 1 || num2 >10) ){
            throw new RuntimeException("throws Exception");
        }
    }
    static int rimToArab(String number){
        for (int i=0; i<=10; i++){
            if (Objects.equals(rimNumbers[i], number)){
                return i;
            }
        }
        return -100;
    }
    static String arabToRim(int number){
        if (number <1){
            throw new RuntimeException("throws Exception");
        }
        return rimNumbers[number];

    }
    static String[] rimNumbers = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
            "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV",
            "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI",
            "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
            "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII",
            "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV",
            "LXXV", "LXXVI", "LXXVII", "LXXV III", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
            "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII",
            "XCVIII", "XCIX", "C"};
}