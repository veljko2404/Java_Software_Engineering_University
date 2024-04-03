package exercises.zad16;

import java.util.Scanner;

/*
Proverite da li je ucitani string palindrom.
*/
public class main {

    public static boolean palindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if (palindrome(str)) {
            System.out.println(STR."String \{str} is palindrome");
        } else {
            System.out.println(STR."String \{str} is not palindrome");
        }
    }
}
