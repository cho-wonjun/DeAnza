package exception;

import java.util.Scanner;

public class Fix100to600 extends Exception{
    public String fix () {
        System.out.printf("An error occured, please re-enter your information below:\n");
        Scanner ss = new Scanner(System.in);
        String s = ss.nextLine();
        return s;
    }
}
