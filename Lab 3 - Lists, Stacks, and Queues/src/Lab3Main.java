/**
 * Lab 3 Team 12
 *
 * @author Won Jun Cho
 * This is a driver main class for different operations on Single Linked List, Stack and Queue.
 */
public class Lab3Main {
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

            SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
            Stack stack = new Stack();
            Queue queue = new Queue();

            // singly linked list operations
            int index = 0;
            for (int i = 6; i >=0; i--) {
                singlyLinkedList.addCurrency(currencies[i], index);
                index++;
            }
            System.out.println(singlyLinkedList.findCurrency(new Dollar(87.43)));
            System.out.println(singlyLinkedList.findCurrency(new Dollar(44.56)));
            singlyLinkedList.removeCurrency(new Dollar(111.22));
            singlyLinkedList.removeCurrency(2);
            System.out.println(singlyLinkedList.printList());
            index = 8;
            for (int i = 0; i < 4; i++) {
                singlyLinkedList.addCurrency(currencies[index], index % 5);
                index++;
            }
            singlyLinkedList.removeCurrency(singlyLinkedList.getCount() % 6);
            singlyLinkedList.removeCurrency(singlyLinkedList.getCount() / 7);
            System.out.println(singlyLinkedList.printList());

            // stack operations
            index = 13;
            for (int i = 0; i < 7; i++) {
                stack.push(currencies[index]);
                index++;
            }
            System.out.println(stack.peek());
            stack.pop();
            stack.pop();
            stack.pop();
            System.out.println(stack.printStack());
            for (int i = 0; i < 5; i++) {
                stack.push(currencies[i]);
            }
            stack.pop();
            stack.pop();
            System.out.println(stack.printStack());

            // queue operations
            index = 5;
            for (int i = 0; i < 7; i++) {
                queue.enqueue(currencies[index]);
                index = index + 2;
            }
            System.out.println(queue.peekFront());
            System.out.println(queue.peekRear());
            queue.dequeue();
            queue.dequeue();
            System.out.println(queue.printQueue());
            index = 10;
            for (int i = 0; i < 5; i++) {
                queue.enqueue(currencies[index]);
                index++;
            }
            queue.dequeue();
            queue.dequeue();
            queue.dequeue();
            System.out.println(queue.printQueue());


            System.out.println("Thank you for executing the program,bye !!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}