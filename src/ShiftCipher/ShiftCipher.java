package ShiftCipher;

import java.util.Scanner;

public class ShiftCipher {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str1 = scan.nextLine();
        Scanner scanNum = new Scanner(System.in);
        int shiftValue = scanNum.nextInt();
        char[] ch1 = str1.toCharArray();

        for (int i = 0; i < ch1.length; i++) {
            int newCharValue = ch1[i] + shiftValue;
            if (65 <= ch1[i] && ch1[i] <= 90) { // Upper-case letters
                if (newCharValue > 90) {
                    ch1[i] = (char) (newCharValue % 90 + 64);
                } else if (newCharValue < 65) {
                    ch1[i] = (char) (newCharValue % 65 + 26);
                } else {
                    ch1[i] = (char) newCharValue;
                }
            } else if (97 <= ch1[i] && ch1[i] <= 122) { // Lower-case letters
                if (ch1[i] + shiftValue > 122) {
                    ch1[i] = (char) (newCharValue % 122 + 96);
                } else if (newCharValue < 97) {
                    ch1[i] = (char) (newCharValue % 97 + 26);
                } else {
                    ch1[i] = (char) newCharValue;
                }
            }
        }

        str1 = String.valueOf(ch1);
        System.out.println(str1);
    }

}
