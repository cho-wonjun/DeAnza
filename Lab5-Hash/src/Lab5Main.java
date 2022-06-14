import java.util.Scanner;

/**
 * Lab 5 Team 12
 *
 * @author Won Jun Cho and Shivam Sugandhi
 * This is a driver main class for different Hash Table operations on currency data objects.
 */
public class Lab5Main {
    public static void main(String args[]) {
        try {
            System.out.println("Welcome, Shivam Sugandhi and Won Jun Cho");

            Currency currencies[] = new Currency[20];
            currencies[0] = new Dollar(57.12);
            currencies[1] = new Dollar(23.44);
            currencies[2] = new Dollar(87.43);
            currencies[3] = new Dollar(68.99);
            currencies[4] = new Dollar(111.22);
            currencies[5] = new Dollar(44.55);
            currencies[6] = new Dollar(77.77);
            currencies[7] = new Dollar(18.36);
            currencies[8] = new Dollar(543.21);
            currencies[9] = new Dollar(20.21);
            currencies[10] = new Dollar(345.67);
            currencies[11] = new Dollar(36.18);
            currencies[12] = new Dollar(48.48);
            currencies[13] = new Dollar(101.00);
            currencies[14] = new Dollar(11.00);
            currencies[15] = new Dollar(21.00);
            currencies[16] = new Dollar(51.00);
            currencies[17] = new Dollar(1.00);
            currencies[18] = new Dollar(251.00);
            currencies[19] = new Dollar(151.00);

            int HASH_TABLE_SIZE = 29;

            HashTable hashTable = new HashTable(HASH_TABLE_SIZE);

            for (int i = 0; i < 20; i++) {
                hashTable.add(currencies[i]);
            }
            System.out.println("Number of data items loaded: " + hashTable.getNumOfItems());
            System.out.println("Load Factor: " + hashTable.getLoadFactor());
            System.out.println("Number of collisions: " + hashTable.getNumOfCollisions());

            Scanner scanner = new Scanner(System.in);
            char op;
            double input;

            while (true) {
                try {
                    System.out.println("Enter a Dollar to search...");
                    if (!scanner.hasNextDouble()) {
                        throw new Exception("Invalid input");
                    }
                    Currency inputCurrency;
                    input = scanner.nextDouble();
                    inputCurrency = new Dollar(input);

                    int index = hashTable.search(inputCurrency);
                    if (index != -1) {
                        System.out.println("Found at index: " + index);
                    } else {
                        System.out.println("Invalid Data");
                    }

                    System.out.println("Do you want to continue? (Y/N)");
                    op = scanner.next().charAt(0);
                    if (op == 'Y' || op == 'y') {
                        continue;
                    } else {
                        break;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            System.out.println("Thank you for executing the program,bye !!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
