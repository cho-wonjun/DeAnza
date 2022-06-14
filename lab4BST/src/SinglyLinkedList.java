/**
 * Lab 3 Team 12
 * @author Won Jun Cho and Shivam Sugandhi
 * This class is designed to create Singly Linked list by using LinkNode class
 * and support different insertion,removal operations.
 */
public class SinglyLinkedList {

    private int count;
    private LinkNode start;
    private LinkNode end;

    public SinglyLinkedList() {
        count = 0;
        start = null;
        end = null;
    }

    /**
     *
     * Algorithm setStart(LinkNode start)
     * Algorithm setEnd(LinkNode end)
     * Algorithm setCount(int count)
     *
     * The setter methods sets one of the properties of the class on which it is called using the input parameter .
     * Pre:  setStart, setEnd, or setCount - int or linknode value of the respective property.
     * Post: the class property start, end, or count is set to the given input value for this object.
     * Return:
     */

    /*
     * set the one of the property of this class to the given input value.
     */
    public void setCount(int count) {
        this.count = count;
    }
    public void setStart(LinkNode start) {
        this.start = start;
    }
    public void setEnd(LinkNode end) {
        this.end = end;
    }

    /**
     *
     * Algorithm getCount()
     * Algorithm getStart()
     * Algorithm getEnd()
     *
     * The getter methods gets one of the requested properties of the SinglyLinkedList class on which it is called.
     * Pre:
     * Post:
     * Return: int or link node properties of the LinkNode class.
     */

    /*
     * return count, start, or end
     */
    public int getCount() {
        return count;
    }

    public LinkNode getStart() {
        return start;
    }
    public LinkNode getEnd() {
        return end;
    }


    /**
     * Algorithm addCurrency(Currency currency, int index)
     *
     * This method takes a Currency object and a node index value as parameters to add the Currency to the list at that
     * index.
     * Pre: Currency currency value that it is going to be add and int index value that it wants to add currency at.
     * Post: currency value is added at a given index
     * Return:
     */

    /*
     * try {
     *      if (checkIndexBound(index) is true) {
     *          throw exception
     *      }
     *      LinkNode newNode = new LinkNode(currency), set the newNode to given currency
     *      if (index is equal to 0) {
     *          set newNode's next node to start
     *          set start to newNode
     *
     *       } else {
     *          LinkNode currentNode = start, set currentNode to start
     *       for (int i = 0; i < index - 1; i++) {
     *          set currentNode to next node
     *        }
     *          set newNode's next node to currentNode's next node
     *          set currentNode's next node to newNode
     *      }
     *      increment count
     * } catch Exception{
     *      print out exception message
     * }
     *
     */
    public void addCurrency(Currency currency, int index) {
        try {
            if (checkIndexBound(index)) {
                throw new Exception("Invalid index");
            }
            LinkNode newNode = new LinkNode(currency);

            if (index == 0) {
                newNode.setNext(start);
                start = newNode;
            } else {
                LinkNode currentNode = start;

                for (int i = 0; i < index - 1; i++) {
                    currentNode = currentNode.getNext();
                }

                newNode.setNext(currentNode.getNext());
                currentNode.setNext(newNode);
            }
            count++;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



    /**
     * Algorithm removeCurrency(Currency currency)
     *
     * This method takes a Currency object as parameter and removes that Currency object from the list.
     * Pre: Currency currency that is going to be removed from the list.
     * Post: Given currency is removed from the list if it exists
     * Return:
     */

    /*
     * int index = findCurrency(currency)
     * call removeCurrency(index) at a index
     */
    public void removeCurrency(Currency currency) {
        int index = findCurrency(currency);
        removeCurrency(index);
    }


    /**
     * Algorithm removeCurrency(int index)
     *
     * This method overload removeCurrency which takes a node index as parameter and removes the Currency object at that
     * index.
     * Pre: int index where it is going to be removed
     * Post: linknode is removed at a given index
     * Return:
     */

    /*
     * try {
     *      if (isListEmpty is true) {
     *          throw new exception
     *      } else if (checkIndexBound(index) is true) {
     *          throw new exception
     *      }
     *
     *      if (index is equal to 0) {
     *          set start to start's next value
     *      } else {
     *          Linknode node = start;
     *          for (int i = 0; i < index -1; i++){
     *              set node to next node
     *          }
     *          set node's next node to node's next next value(two nodes after the current node)
     *      }
     *      decrement count by 1
     * } catch exception {
     *      print message
     * }
     *
     */
    public void removeCurrency(int index) {
        try {
            if (isListEmpty()) {
                throw new Exception("List is empty");
            } else if (checkIndexBound(index)) {
                throw new Exception("Invalid index");
            }

            if (index == 0) {
                start = start.getNext();
            } else {
                LinkNode node = start;

                for (int i = 0; i < index - 1; i++) {
                    node = node.getNext();
                }

                node.setNext(node.getNext().getNext());
            }
            count--;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * ALgorithm findCurrency(Currency currency)
     *
     * This method takes a Currency object as parameter and returns the node index at which the Currency is found in the
     * list.
     * Pre: Currency currency that it wants to find.
     * Post:
     * Return: index of currency or -1 if the currency is not in the list.
     */

    /*
     * LinkNode node = start
     * int index = 0
     *
     * while (node's next value is not equal to null) {
     *      if (node's value is equal to currency, input) {
     *          return index
     *      } else {
     *          set node to next value
     *          increment index by 1
     *      }
     * }
     * return -1
     */
    public int findCurrency(Currency currency) {
        if (isListEmpty()) {
            return -1;
        }
        LinkNode node = start;
        int index = 0;

        while (node.getNext() != null) {
            if (node.getData().isEqual(currency)) {
                return index;
            }

            node = node.getNext();
            index++;
        }
        return -1;
    }
    /**
     * Algorithm getCurrency(int index)
     *
     * This method takes an index values as a parameter and returns the Currency object.
     * Pre: int index at where currency value will be drawn from singlylinkedlist
     * Post:
     * Return: currency
     */

    /*
     * LinkNode node = start
     * for (int i = 0; i < index; i++) {
     *      set node to next node
     * }
     *
     * return node's value
     */
    public Currency getCurrency(int index) {
        LinkNode node = start;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }

        return node.getData();
    }
    /**
     *
     * Algorithm printList()
     *
     * This method returns a string of all the Currency objects in the list in the order of index, tab spaced.
     * Pre:
     * Post:
     * Return: String of all currency objects in the list in the order of index.
     */

    /*
     * LinkNode node = start
     * String list = "" - string where it will hold all currency value
     *
     * for (int i = 0; i < count; i++) {
     *      add string representation of currency in each node
     *      if (i is not equal to count - 1) add tab space to list
     *      set node to next node
     * }
     * return list
     */
    public String printList() {
        LinkNode node = start;
        String list = "";

        for (int i = 0; i < count; i++) {
            list += node.getData();

            if (i != count - 1) list += "   ";
            node = node.getNext();
        }

        return list;
    }


    /**
     *
     * Algorithm isListEmpty()
     *
     * This method returns boolean if a list is empty or not.
     * Pre:
     * Post:
     * Return: true or false, if a SinglyLinkedList class is empty or not
     */

    /*
     * if (count is equal to 0){
     *      return true
     * } else {
     *      return false
     * }
     */
    public boolean isListEmpty() {
        return this.count==0;
    }
    /**
     *
     * Algorithm countCurrency()
     *
     * This method returns a count of Currency nodes in the list.
     * Pre:
     * Post:
     * Return: total count of LinkNode of SinglyLinkedList class
     */
    public int countCurrency() {
        return count;
    }

    /**
     * Algorithm checkIndexBound(int index)
     *
     * This method checks if index given in method is out of bound in the SinglyLinkedList.
     * Pre: int index
     * Post:
     * Return: true or false
     */

    /*
     * if (index is greater than count) return true
     * return false
     */
    public boolean checkIndexBound(int index) {
        if (index > count || index < 0) return true;
        return false;
    }

}