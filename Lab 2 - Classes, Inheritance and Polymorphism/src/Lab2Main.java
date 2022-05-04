/**
 * Lab 2 Team 12
 * @author Won Jun Cho
 * This class is designed for lab assignment 2 to build a currency simulator using classes,inheritance and polymorphism.
 */

import java.util.Scanner;

public class Lab2Main {
    public static void main(String args[]) {

        Currency currency[] = new Currency[2];
        currency[0] = new Pound();
        currency[1] = new Dollar();

        print(currency);

        Scanner scanner = new Scanner(System.in);
        char op;
        char symbol;
        double input;
        String name;

        while (true) {
            try {
                op = scanner.next().charAt(0);
                if (op == 'q') break;
                symbol = scanner.next().charAt(0);
                if (!scanner.hasNextDouble()) {
                    throw new Exception("Invalid input");
                }
                input = scanner.nextDouble();
                name = scanner.next();
                Currency inputCurrency = null;

                if (name.equalsIgnoreCase("pound")) {
                    inputCurrency = new Pound(input);
                } else if (name.equalsIgnoreCase("dollar")) {
                    inputCurrency = new Dollar(input);
                } else {
                    throw new Exception("Invalid input");
                }

                switch (op) {
                    case 'a':
                        if (symbol == 'p') {
                            currency[0].add(inputCurrency);
                            print(currency);
                        } else if (symbol == 'd') {
                            currency[1].add(inputCurrency);
                            print(currency);
                        } else {
                            throw new Exception("Invalid input");
                        }
                        break;

                    case 's':
                        if (symbol == 'p') {
                            currency[0].subtract(inputCurrency);
                            print(currency);
                        } else if (symbol == 'd') {
                            currency[1].subtract(inputCurrency);
                            print(currency);
                        } else {
                            throw new Exception("Invalid input");
                        }
                        break;
                    default:
                        throw new Exception("Invalid input");

                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Algorithm print (currency array)
     * <p>
     * This algorithm prints all the currency values.
     * Pre: currency[] - the input currency array to be printed
     * Post: print the currency values using the print methods of respective currency objects.
     * Return:
     */
    public static void print(Currency currency[]) {
        for (int i = 0; i < currency.length; i++) {
            currency[i].print();
        }
        System.out.println();
    }
}
