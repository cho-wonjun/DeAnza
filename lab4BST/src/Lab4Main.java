import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * Lab 4 Team 12
 *
 * @author Won Jun Cho and Shivam Sugandhi
 * This is a driver main class for different Binary Search Tree operations on currency data objects.
 */
public class Lab4Main {
    public static void main(String args[]) {
        try {
            BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("output.txt"));
            System.out.println("Welcome, Shivam Sugandhi and Won Jun Cho");
            BST bst = new BST();
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
            for(int i=0;i<20;i++){
                bst.insert(currencies[i], bufferedWriter);
            }

            Scanner scanner = new Scanner(System.in);
            char op;
            double input;
            BSTNode node;

            while (true) {
                try {
                    op = scanner.next().charAt(0);
                    if (op == 'q') {
                        bst.print(bufferedWriter);
                        bufferedWriter.close();
                        break;
                    }
                    Currency inputCurrency=null;
                    if(op=='a' || op=='s' || op=='d'){
                        if (!scanner.hasNextDouble()) {
                            throw new Exception("Invalid input");
                        }
                        input = scanner.nextDouble();
                        inputCurrency = new Dollar(input);
                    }

                    switch (op) {
                        case 'a':
                            bst.insert(inputCurrency, bufferedWriter);
                            break;

                        case 's':
                            node=bst.search(inputCurrency);
                            if(node!=null){
                                System.out.println("Found " +node.getData());
                                bufferedWriter.write("Found " +node.getData()+"\n");
                            }else{
                                System.out.println("Not found");
                                bufferedWriter.write("Not found "+inputCurrency+"\n");
                            }
                            break;

                        case 'd':
                            bst.delete(inputCurrency);
                            break;

                        case 'p':
                            bst.print(bufferedWriter);
                            break;

                        default:
                            throw new Exception("Invalid input");

                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    bufferedWriter.write(e.getMessage());
                }
            }
            System.out.println("Thank you for executing the program,bye !!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
