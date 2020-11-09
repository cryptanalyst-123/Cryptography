import java.util.Scanner;

public class SubstitutionCipher {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        System.out.println("Enter message:");
        String str = stdin.nextLine();
        System.out.println("Encrypt or Decrypt?");
        String instr = stdin.next();
        if (instr.toLowerCase().equals("encrypt")) {
            System.out.println("Shift:");
            int shift = stdin.nextInt();
            if (shift > 26)
                shift %= 26;
            System.out.println(encrypt(str.toLowerCase(), shift));
        } else if (instr.toLowerCase().equals("decrypt")) {
            System.out.println("Enter 'A' if shift is known. Otherwise, enter 'B'.");
            char c = stdin.next().charAt(0);
            if (c == 'A' || c == 'a') {
                System.out.println("Shift:");
                int shift = stdin.nextInt();
                if (shift > 26)
                    shift %= 26;
                System.out.println(decrypt(str.toLowerCase(), shift));
            }
            else if (c == 'B' || c == 'b')
                useAllShifts(str);
        }
        main(args);
        stdin.close();
    }

    public static String encrypt(String str, int num) {
        char[] arr = str.toCharArray();
        String newStr = "";
        char c = 'a';
        int remainder = 0;
        for (int i = 0; i < arr.length; i++) {
            char newChar = (char) (arr[i] + num);
            if (newChar > 'z') {
                remainder = newChar - 'z';
                c = (char) ('a' + remainder - 1);
            } else
                c = newChar;
            newStr += c;
        }
        for (int i = 0; i < newStr.length(); i++) {
            if (!Character.isLetter(newStr.charAt(i))) {
                newStr = newStr.replace(newStr.charAt(i), str.charAt(i));
            }
        }
        return newStr;
    }

    public static String decrypt(String str, int num) {
        char[] arr = str.toCharArray();
        char c = 'a';
        int remainder = 0;
        String newStr = "";
        for (int i = 0; i < arr.length; i++) {
            char newChar = (char) (arr[i] - num);
            if (newChar < 'a') {
                remainder = 'a' - newChar;
                c = (char) ('z' - remainder + 1);
            } else
                c = newChar;
            newStr += c;
        }
        for (int i = 0; i < newStr.length(); i++) {
            if (!Character.isLetter(newStr.charAt(i))) {
                newStr = newStr.replace(newStr.charAt(i), str.charAt(i));
            }
        }
        return newStr;
    }

    public static void useAllShifts(String str) {
        for (int i = 1; i < 26; i++)
            System.out.println(decrypt(str, i));
    }
}