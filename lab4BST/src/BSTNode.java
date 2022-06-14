/**
 * Lab 4 Team 12
 * @author Won Jun Cho
 * This class designed for BST node that BST class uses to build a model that simulates BST.
 */
public class BSTNode {

    private Currency data;
    private BSTNode right, left;

    public BSTNode(Currency data) {
        this.data = data;
        this.right = this.left = null;
    }
    /**
     *
     * Algorithm getData()
     * Algorithm getRight()
     * Algorithm getLeft()
     *
     * The getter methods gets one of the requested properties of the BSTNode class on which it is called.
     * Pre:
     * Post:
     * Return: dollar or bstnode properties of the BSTNode class.
     */

    /*
     * return data, right, or left
     */
    public Currency getData() {
        return data;
    }
    /**
     *
     * Algorithm setData(Currency data)
     * Algorithm setRight(BSTNode right)
     * Algorithm setLeft(BSTNode left)
     *
     *
     * The setter methods sets one of the properties of the class on which it is called using the input parameter .
     * Pre:  setData, setRight, setLeft - currency or bstnode value of the respective property.
     * Post: the class property data, left, or right is set to the given input value for this object.
     * Return:
     */

    /*
     * set the one of the property of this class to the given input value.
     */
    public void setData(Currency data) {
        this.data = data;
    }

    public BSTNode getRight() {
        return right;
    }

    public void setRight(BSTNode right) {
        this.right = right;
    }

    public BSTNode getLeft() {
        return left;
    }

    public void setLeft(BSTNode left) {
        this.left = left;
    }
}
