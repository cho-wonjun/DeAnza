import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Lab 4 Team 12
 * @author Won Jun Cho and Shivam Sugandhi
 * This class designed for Binary Search Tree class to build a model that simulates the process of BST.
 */
public class BST {

    private BSTNode root;

    public BST() {
        this.root = null;
    }

    public BST(Currency data) {
        this.root = new BSTNode(data);
    }
    /**
     * Algorithm search(Currency data)
     *
     * This method returns BSTNode or null, depending on if data is found in BST.
     * Pre: Currency data that it is going to find
     * Post:
     * Return: BSTNode or null
     */

    /*
     * BSTNode currentNode = root
     *
     * if (list is empty) return null
     *
     *
     * while (true) {
     *      if (currentNode is equal to data) return currentNode
     *
     *      if (currentNode is greater than the data) {
     *          if (currentNode's left is not null) {
     *              currentNode is set to currentNode's left
     *          } else {
     *              return null
     *          }
     *      } else if (currentNode is not greater than the data) {
     *          if (currentNode's right is not null) {
     *              currentNode is set to currentNode's right
     *          } else {
     *              return null
     *          }
     *      }
     * }
     */
    public BSTNode search(Currency data) {
        BSTNode currentNode = root;

        if (isEmpty()) return null;

        while (true) {
            if (currentNode.getData().isEqual(data)) return currentNode;

            if (currentNode.getData().isGreater(data)) {
                if (currentNode.getLeft() != null) {
                    currentNode = currentNode.getLeft();
                } else {
                    return null;
                }
            } else if (!currentNode.getData().isGreater(data)) {
                if (currentNode.getRight() != null) {
                    currentNode = currentNode.getRight();
                } else {
                    return null;
                }
            }
        }
    }
    /**
     * Algorithm insert(Currency data, BufferedWriter bufferedWriter)
     *
     * This method insert a data into BST.
     * Pre: Currency data that it will going to insert, BufferedWriter bufferedWriter that it is going to write error to file.
     * Post: Currency data inserted into bst.
     * Return: Node that contains data that is going to be inserted
     */

    /*
     * BSTNode currentNode = root
     * BSTNode newNode = new BSTNode(data)
     *
     * if (list is empty) {
     * root = newNode
     * return root
     * }
     * try {
     * while (true) {
     *      if (currentNode is equal to data) throw error
     *      if (currentNode is greater than the data) {
     *          if (currentNode's left is null) {
     *              currentNode's left is set to newNode
     *              return node that contains data that is going to be inserted
     *          } else {
     *              currentNode is set to currentNode's left
     *          }
     *      } else if (currentNode is not greater than the data) {
     *          if (currentNode's right is null) {
     *              currentNode's right is set to newNode
     *              return node that contains data that is going to be inserted
     *          } else {
     *              currentNode is set to currentNode's right
     *          }
     *      }
     * }
     * } catch (Exception) {
     *      print message
     *      try {
     *          write it to buffered writer
     *      } catch {
     *          print error msg
     *      }
     * }
     * return null
     */
    public BSTNode insert(Currency data, BufferedWriter bufferedWriter) {
        BSTNode currentNode = root;
        BSTNode newNode = new BSTNode(data);

        if (isEmpty()) {
            root = newNode;
            return root;
        }

        try {
            while (true) {
                if (currentNode.getData().isEqual(data)) throw new Exception("Data already exists");

                if (currentNode.getData().isGreater(data)) {
                    if (currentNode.getLeft() == null) {
                        currentNode.setLeft(newNode);
                        return newNode;
                    } else {
                        currentNode = currentNode.getLeft();
                    }
                } else if (!currentNode.getData().isGreater(data)) {
                    if (currentNode.getRight() == null) {
                        currentNode.setRight(newNode);
                        return newNode;
                    } else {
                        currentNode = currentNode.getRight();
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            try {
                bufferedWriter.write(e.getMessage() + "\n");
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return null;
    }

    /**
     * Algorithm delete(Currency currency)
     *
     * This method deletes the given currency node if present.
     * Pre: Currency - node with this currency value to be deleted
     * Post: if the given currency value node is found then it is deleted
     * Return:
     */

    /*
     * uses delete recursive function to delete the given currency node and modifies the root if applicable.
     * deleteRecur(root node, currency)
     */
    public void delete(Currency currency) {
        this.root = deleteRecur(this.root, currency);
    }

    /**
     * Algorithm deleteRecur(BSTNode root, Currency currency)
     *
     * This method deletes the given currency node if present searching recursively from the given root.
     * Pre: root - root node of the BST tree.
     *      Currency - node with this currency value to be deleted
     * Post: if the given currency value node is found then it is deleted.
     * Return: root of the new bst tree after deletion
     */

    /*
     * if (root is null)
     *     return null
     * if(root's data is greater than given currency data)
     *      call deleteRecur for left subtree
     * if(root's data is smaller than given currency data)
     *      call deleteRecur for right subtree
     * else
     *      if(root's left is null) then return root's right node
     *      if(root's right is null) then return root's left node
     *      else
     *          get the minimum value or inorder successor in right subtree and update root's data
     *          delete that minimum value from right subtree of root
     * return root
     */
    public BSTNode deleteRecur(BSTNode root, Currency currency) {
        if (root == null) {
            return null;
        }
        if (root.getData().isGreater(currency)) {
            root.setLeft(deleteRecur(root.getLeft(), currency));
        } else if (currency.isGreater(root.getData())) {
            root.setRight(deleteRecur(root.getRight(), currency));
        } else {
            if (root.getLeft() == null) {
                return root.getRight();
            } else if (root.getRight() == null) {
                return root.getLeft();
            }
            root.setData(getMinValue(root.getRight()));
            root.setRight(deleteRecur(root.getRight(), root.getData()));
        }
        return root;
    }

    public Currency getMinValue(BSTNode node) {
        Currency min = node.getData();
        while (node.getLeft() != null) {
            min = node.getLeft().getData();
            node = node.getLeft();
        }
        return min;
    }

    /**
     * Algorithm count()
     *
     * This method returns the number of nodes inside bst.
     * Pre:
     * Post:
     * Return: integer, the amount of nodes inside bst
     */

    /*
     * BSTNode currentNode = root
     * countRecursive(currentNode)
     */
    public int count() {
        BSTNode currentNode = root;
        return countRecursive(currentNode);
    }
    /**
     * Algorithm countRecursive(BSTNode currentNode)
     *
     * This private method returns the number of nodes inside bst recursively. It is used for count method.
     * Pre: BSTNode currentNode
     * Post:
     * Return: integer, the amount of nodes inside bst
     */

    /*
     * if (currentNode is null) return 0
     *
     * return 1 + countRecursive(currentNode.getLeft()) + countRecursive(currentNode.getRight())
     */
    private int countRecursive(BSTNode currentNode) {
        if (currentNode == null) return 0;

        return 1 + countRecursive(currentNode.getLeft()) + countRecursive(currentNode.getRight());
    }
    /**
     * Algorithm isEmpty()
     *
     * This method returns a boolean if a BST is empty or not.
     * Pre:
     * Post:
     * Return: true or false if a BST class is empty or not
     */

    /*
     * return root == null
     */
    public boolean isEmpty() {
        return this.root == null;
    }

    /**
     * Algorithm print(BufferedWriter bufferedWriter)
     *
     * This method prints the tree in the specific sequence of breadth-first, in-order, pre-order, post-order.
     * Pre: BufferedWriter bufferedWriter
     * Post: The four traversal breadth-first, in-order, pre-order, post-order are printed
     * Return:
     */

    /*
     * try {
     * if(tree is empty)
     *     return
     * print sequence name
     * printBreadthFirst(this.root, bufferedWriter)
     * write it to bufferedWriter
     * print sequence name
     * printInOrder(this.root, bufferedWriter)
     * write it to bufferedWriter
     * print sequence name
     * printPreOrder(this.root, bufferedWriter)
     * write it to bufferedWriter
     * print sequence name
     * printPostOrder(this.root, bufferedWriter)
     * write it to bufferedWriter
     * } catch (Exception e) {
     *      print exception msg
     * }
     */
    public void print(BufferedWriter bufferedWriter) {
        try {
            if (isEmpty()) {
                return;
            }
            System.out.print("Breadth First Traversal: ");
            bufferedWriter.write("Breadth First Traversal: ");
            printBreadthFirst(this.root,bufferedWriter);
            System.out.println();
            bufferedWriter.write("\n");
            System.out.print("Inorder Traversal: ");
            bufferedWriter.write("Inorder Traversal: ");
            printInOrder(this.root,bufferedWriter);
            System.out.println();
            bufferedWriter.write("\n");
            System.out.print("Pre-order Traversal: ");
            bufferedWriter.write("Pre-order Traversal: ");
            printPreOrder(this.root,bufferedWriter);
            System.out.println();
            bufferedWriter.write("\n");
            System.out.print("Post-order Traversal: ");
            bufferedWriter.write("Post-order Traversal: ");
            printPostOrder(this.root,bufferedWriter);
            System.out.println();
            bufferedWriter.write("\n");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Algorithm printBreadthFirst(BSTNode node, BufferedWriter bufferedWriter)
     *
     * This method prints the tree in a breadth first manner using queue.
     * Pre: node- the root node of the tree, BufferedWriter bufferedWriter
     * Post: The breadth first traversal is printed
     * Return:
     */

    /*
     * try {
     * if(node is null)
     *     return
     * Queue queue=new Queue()
     * queue.enqueue(root's data)  enqueue the root node data at front.
     * while(queue is not empty){
     *      Currency currency=queue.dequeue() dequeue first element
     *      BSTNode temp = search(currency) get the node containing the dequeued currency object
     *      queue.enqueue(temp.getLeft().getData()) enqueue the left node of the resulted search if not null
     *      queue.enqueue(temp.getRight().getData()) enqueue the right node of the resulted search if not null
     *      print the dequeued element currency.
     *      write it to bufferedWriter
     * }
     * } catch (Exception) {
     *      print exception msg
     * }
     */
    public void printBreadthFirst(BSTNode node,BufferedWriter bufferedWriter) {
        try {
            if (node == null) {
                return;
            }
            Queue queue = new Queue();
            queue.enqueue(this.root.getData());
            while (!queue.isListEmpty()) {
                Currency currency = queue.dequeue();
                BSTNode temp = search(currency);
                if (temp.getLeft() != null) {
                    queue.enqueue(temp.getLeft().getData());
                }
                if (temp.getRight() != null) {
                    queue.enqueue(temp.getRight().getData());
                }
                System.out.print(currency + " ");
                bufferedWriter.write(currency + " ");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Algorithm printInOrder(BSTNode node, BufferedWriter bufferedWriter)
     *
     * This method prints the tree in an inorder fashion using recursion.
     * Pre: node - the root node of the tree, BufferedWriter bufferedWriter
     * Post: The inorder traversal is printed
     * Return:
     */

    /*
     * try {
     * if(node is null)
     *     return
     * printInorder(node's left)
     * print node's data
     * write it to bufferedWriter
     * printInorder(node's right)
     * } catch {
     *      print stack trace
     * }
     */
    private void printInOrder(BSTNode node, BufferedWriter bufferedWriter) {
        try {
            if (node == null) {
                return;
            }
            printInOrder(node.getLeft(), bufferedWriter);
            System.out.print(node.getData() + " ");
            bufferedWriter.write(node.getData() + " ");
            printInOrder(node.getRight(), bufferedWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Algorithm printPreOrder(BSTNode node, BufferedWriter bufferedWriter)
     *
     * This method prints the tree in a pre-order fashion using recursion.
     * Pre: node - the root node of the tree, BufferedWriter bufferedWriter
     * Post: The pre-order traversal is printed
     * Return:
     */

    /*
     * try {
     * if(node is null)
     *     return
     * print node's data
     * write it to bufferedWriter
     * printInorder(node's left)
     * printInorder(node's right)
     * } catch (Exception e) {
     *      print error msg
     * }
     */
    public void printPreOrder(BSTNode node, BufferedWriter bufferedWriter) {
        try {
            if (node == null) {
                return;
            }
            System.out.print(node.getData() + " ");
            bufferedWriter.write(node.getData() + " ");
            printPreOrder(node.getLeft(), bufferedWriter);
            printPreOrder(node.getRight(), bufferedWriter);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Algorithm printPostOrder(BSTNode node, BufferedWriter bufferedWriter)
     *
     * This method prints the tree in a post-order fashion using recursion.
     * Pre: node - the root node of the tree, BufferedWriter bufferedWriter
     * Post: The post-order traversal is printed
     * Return:
     */

    /*
     * try {
     * if(node is null)
     *     return
     * printInorder(node's left)
     * printInorder(node's right)
     * print node's data
     * write it to bufferedWriter
     * } catch (Exception e) {
     *      print error msg
     * }
     */
    public void printPostOrder(BSTNode node, BufferedWriter bufferedWriter) {
        try {
            if (node == null) {
                return;
            }
            printPostOrder(node.getLeft(), bufferedWriter);
            printPostOrder(node.getRight(), bufferedWriter);
            System.out.print(node.getData() + " ");
            bufferedWriter.write(node.getData() + " ");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
