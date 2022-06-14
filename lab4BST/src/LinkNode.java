/**
 * Lab 3 Team 12
 * @author Won Jun Cho and Shivam Sugandhi
 * This class is designed to create a list node, which is used to create SinglyLinkedList.
 */
public class LinkNode {

    private Currency data;
    private LinkNode next;

    LinkNode(Currency data) {
        this.data = data;
        next = null;
    }
    /**
     *
     * Algorithm getData()
     * Algorithm getNext()
     *
     * The getter methods gets one of the requested properties of the LinkNode class on which it is called.
     * Pre:
     * Post:
     * Return: currency or linknode properties of the LinkNode class.
     */

    /*
     * return data or next
     */
    public Currency getData() {
        return data;
    }

    public LinkNode getNext() {
        return next;
    }

    /**
     *
     * Algorithm setData(Currency data)
     * Algorithm setNext(LinkNode next)
     *
     *
     * The setter methods sets one of the properties of the class on which it is called using the input parameter .
     * Pre:  setData or setNext - currency or linknode value of the respective property.
     * Post: the class property data or next is set to the given input value for this object.
     * Return:
     */

    /*
     * set the one of the property of this class to the given input value.
     */
    public void setData(Currency data) {
        this.data = data;
    }

    public void setNext(LinkNode next) {
        this.next = next;
    }
}