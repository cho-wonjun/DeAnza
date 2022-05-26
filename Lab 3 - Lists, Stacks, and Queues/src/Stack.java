/**
 * Lab 3 Team 12
 * @author Won Jun Cho and Shivam Sugandhi
 * This stack class is designed for list operations behaving as a stack which follows LIFO order.
 */
public class Stack extends SinglyLinkedList {
    Stack() {
        super();
    }

    /**
     * ALgorithm push(Currency currency)
     * <p>
     * This method takes a Currency object as parameter and adds it at the top of the current list.
     * Pre: currency object to be pushed.
     * Post: currency object is pushed to the top of the list.
     * Return:
     */

    /*
     * adds currency at index 0 using base class singly linked list method.
     * addCurrency(currency,0)
     *
     */
    public void push(Currency currency) {
        super.addCurrency(currency, 0);
    }

    /**
     * ALgorithm pop()
     * <p>
     * This method pops or removes a currency object from the top of the current list.
     * Pre:
     * Post: currency object at the top is removed from the current list.
     * Return: currency object that is removed/popped from the top.
     */

    /*
     * Get currency obj at index 0 and remove that currency obj using base class singly linked list method.
     * currency = getCurrency(0)
     * removeCurrency(0)
     * return currency
     *
     */
    public Currency pop() {
        try {
            if (isListEmpty()) {
                throw new Exception("Stack is empty");
            }
            Currency currency = super.getCurrency(0);
            super.removeCurrency(0);
            return currency;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * ALgorithm peek()
     * <p>
     * This method gets or returns the top currency object without removing it from the current list.
     * Pre:
     * Post:
     * Return: currency obj from top of the list.
     */

    /*
     * get currency at index 0 using base class singly linked list method.
     * return getCurrency(0)
     *
     */
    public Currency peek() {
        try{
            if(isListEmpty()){
                throw new Exception("Stack is empty");
            }
            return super.getCurrency(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * ALgorithm printStack()
     * <p>
     * This method returns the string representation of the currency objects added using stack along with their indexes.
     * Pre:
     * Post:
     * Return: return string representation of current stack.
     */

    /*
     * return current list string representation using base class singly linked list method.
     * return printList()
     *
     */
    public String printStack() {
        return super.printList();
    }

    @Override
    public void addCurrency(Currency currency, int index) {
        try {
            throw new UnsupportedOperationException("Invalid operation");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void removeCurrency(int index) {
        try {
            throw new UnsupportedOperationException("Invalid operation");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public int findCurrency(Currency currency) {
        try {
            throw new UnsupportedOperationException("Invalid operation");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }

    @Override
    public Currency getCurrency(int index) {
        try {
            throw new UnsupportedOperationException("Invalid operation");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String printList(){
        try {
            throw new UnsupportedOperationException("Invalid operation");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "";
    }

}

