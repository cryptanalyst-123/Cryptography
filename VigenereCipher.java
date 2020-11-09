import java.util.Scanner;
public class VigenereCipher {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        System.out.println("Enter message:");
        String message = stdin.next();
        System.out.println("Enter encryption key:");
        String key = stdin.next();
        stdin.close();
    }
}
