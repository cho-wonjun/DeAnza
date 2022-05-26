/**
 * Lab 3 Team 12
 * @author Won Jun Cho and Shivam Sugandhi
 * This Queue class is designed for the list operations behaving as a queue which follows FIFO order.
 */
public class Queue extends SinglyLinkedList {
    Queue() {
        super();
    }

    /**
     * ALgorithm enqueue(Currency currency)
     *
     * This method takes a Currency object as parameter and appends it at the last/rear end of the current list.
     * Pre: currency object to be pushed.
     * Post: currency object is enqueued at the rear end of the list.
     * Return:
     */

    /*
     * adds currency at last using base class singly linked list method.
     * addCurrency(currency, getCount())
     *
     */
    public void enqueue(Currency currency) {
        super.addCurrency(currency, getCount());
    }

    /**
     * ALgorithm dequeue()
     *
     * This method removes a Currency object from the front of the current list.
     * Pre:
     * Post: currency object is from the front of the current list.
     * Return: currency object from front.
     */

    /*
     * get currency obj at index 0 and then remove that obj using base class singly linked list method.
     * currency = getCurrency(0)
     * removeCurrency(0)
     * return currency
     *
     */
    public Currency dequeue() {
        try {
            if(isListEmpty()){
                throw new Exception("Queue is empty");
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
     * ALgorithm peekFront()
     *
     * This method returns the currency obj from the front without removing from the current list.
     * Pre:
     * Post:
     * Return: currency obj from front end.
     */

    /*
     * get currency obj at index 0 using base class singly linked list method and returns that currency object.
     * return getCurrency(0)
     *
     */
    public Currency peekFront() {
        try{
            if(isListEmpty()){
                throw new Exception("Queue is empty");
            }
            return super.getCurrency(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * ALgorithm peekRear()
     *
     * This method returns the currency obj from the rear end without removing from the current list.
     * Pre:
     * Post:
     * Return: currency obj from rear end.
     */

    /*
     * get currency obj at last index using base class singly linked list method and returns that currency object.
     * return getCurrency(count-1)
     *
     */
    public Currency peekRear() {
        try{
            if(isListEmpty()){
                throw new Exception("Queue is empty");
            }
            return super.getCurrency(getCount()-1);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }


    /**
     * ALgorithm printQueue()
     *
     * This method returns the string representation of the currency objects added using queue along with their indexes.
     * Pre:
     * Post:
     * Return: return string representation of current queue.
     */

    /*
     * return current list string representation using base class singly linked list method.
     * return printList()
     *
     */
    public String printQueue() {
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

