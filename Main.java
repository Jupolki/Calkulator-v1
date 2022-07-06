import java.util.InputMismatchException;
import java.util.Scanner;


 class calculator {
     static char operation;

     public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1, num2;
        int result;

        System.out.println("Enter the expression (2+2) or two Roman numbers from I to X:(V+V) + Enter ");
        String input = sc.nextLine();
        char[] char1 = new char[10];


        for (int a = 0; a < input.length(); a++) {
            char1[a] = input.charAt(a);
            if (char1[a] == '+') {
                operation = '+';
            }
            if (char1[a] == '-') {
                operation = '-';
            }
            if (char1[a] == '*') {
                operation = '*';
            }
            if (char1[a] == '/') {
                operation = '/';
            }
        }
        String under_charString = String.valueOf(char1);
        String[] blacks = under_charString.split("[+-/*]");
        String str0 = blacks[0];
        String str1 = blacks[1];
        String str2 = str1.trim();
        num1 = romanToNumber(str0);
        num2 = romanToNumber(str2);
        if (num1 < 0 && num2 < 0) {
            result = 0;
        } else {
            result = calculated(num1, num2, operation);
            System.out.println("Result Roman numbers");
            String resultRoman = convertNumToRoman(result);
            System.out.println(str0 + " " + operation + " " + str2 + " = " + resultRoman);
        }
        num1 = Integer.parseInt(str0);
        num2 = Integer.parseInt(str2);
        result = calculated(num1, num2, operation);
        System.out.println("Result Arabian numbers");
        System.out.println(num1 + " " + operation + " " + num2 + " = " + result);
    }

    static String convertNumToRoman (int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        final String s = roman[numArabian];
        return s;
    }


    static int romanToNumber (String roman) {
        try {
            if (roman.equals("I")) {
                return 1;
            } else if (roman.equals("II")) {
                return 2;
            } else if (roman.equals("III")) {
                return 3;
            } else if (roman.equals("IV")) {
                return 4;
            } else if (roman.equals("V")) {
                return 5;
            } else if (roman.equals("VI")) {
                return 6;
            } else if (roman.equals("VII")) {
                return 7;
            } else if (roman.equals("VIII")) {
                return 8;
            } else if (roman.equals("IX")) {
                return 9;
            } else if (roman.equals("X")) {
                return 10;
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Error");
        }
        return -1;
    }

    static int calculated (int num1, int num2, char op) {
        int result = 0;
        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                try {
                    result = num1 / num2;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Exception : " + e);

                    break;
                }
                break;
            default:
                throw new IllegalArgumentException("Error");
        }
        return result;
    }
}