
/**
 * LinkedList Class
 * This class is used to create, maintain, and edit
 * linked lists holding Product Class objects.
 * Authors: Dan Lorenzo, Matthew Sirois, Sebastian Arreola
 */
public class LinkedList {
    Node head = new Node(new Product());
    Node last = new Node(new Product());

    /**
     * LinkedList Constructor
     */
    public LinkedList() {
        head.next = last;
        last.prev = head;
    }

    /**
     * Node Class
     * Nested class in LinkedList designed to handle the creation of linked list nodes
     * Node store a Product type object with next and previous pointers
     */
    public static class Node {
        Product contents;
        Node next;
        Node prev;

        /**
         * Node Constructor
         * @param p
         * Product type object to be stored as the node contents
         */
        public Node(Product p) {
            contents = p;
            next = null;
            prev = null;
        }
    }

    /**
     * insertBeginning method
     * Inserts a new node containing a product just after the head node
     * @param p
     * Product type object to be inserted
     */
    public void insertBeginning(Product p) {
        Node newNode = new Node(p);
        newNode.next = head.next;
        newNode.next.prev = newNode;
        head.next = newNode;
        newNode.prev = head;
    }

    /**
     * insert() method
     * Inserts a product into any position in the linked list
     * @param refNode
     * Reference node which is given by the
     * @param p
     * Product type object to be inserted
     */
    public void insert(Node refNode, Product p) {
        if (refNode == last){
            insertEnd(p);
        } else if (null == refNode) {
            System.out.println("The reference node cannot be null");
        } else {
            Node newNode = new Node(p);
            newNode.next = refNode.next;
            newNode.next.prev = newNode;
            refNode.next = newNode;
            newNode.prev = refNode;
        }
    }

    /**
     * insertEnd() method
     * Inserts a product after the last node in the linked list
     * @param p
     * Product type object to be inserted
     */
    public void insertEnd(Product p) {
        if (last.contents != null) {
            Node newNode = new Node(p);
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
        } else {
            last.contents = p;
        }
    }

    /**
     * remove() method
     * Removed a product from the linked list
     * @param p
     * Product to be removed
     * @return
     * Returns TRUE if the product has been successfully removed
     */
    public boolean remove(Product p) {
       if (null == head.next) return false;
       if (last.contents == p){
           last = last.prev;
           last.next = null;
           return true;
       }

       // Starts one pointer from either end of the linked list
       Node front = head.next;
       Node back = last;

       // Moves pointers one at a time until either pointer meets the
       // node to be removed or until the pointers meet one another.
       while (front != back) {
           if (front.contents == p) {
               front.prev.next = front.next;
               front.next.prev = front.prev;
               return true;
           } else if (null != front.next){
               front = front.next;
           }

           if (back.contents == p){
               back.prev.next = back.next;
               back.next.prev = back.prev;
               return true;
           } else if (null != back.prev){
               back = back.prev;
           }
       }
       return false;
   }

    /**
     * search() method
     * Searches for a particular product stored within the linked list.
     * Can be used to cross-check contents of the linked list.
     * @param p
     * Product being seeked
     * @return
     * Returns TRUE if the product exists
     */
    public boolean search(Product p) {
        Node currentNode = head.next;
        while (currentNode != null) {
            if (currentNode.contents == p) return true;
            currentNode = currentNode.next;
        }
        return false;
    }

    /**
     * sortByPrice() method
     * Sorts the entire linked list from lowest to highest price
     * using the bubble-sort sorting algorithm
     */
    public void sortByPrice() {
        Node current = this.head.next;
        Node index;
        Product temp;

        while (current != null) {
            // Index points to the next node
            index = current.next;

            while (index != null) {
                if (current.contents.price > index.contents.price) {
                    temp = current.contents;
                    current.contents = index.contents;
                    index.contents = temp;
                }
                index = index.next;
            }
            current = current.next;
        }
    }

    /**
     * printFromHead() method
     * Prints contents of entire linked list starting at head node
     * Contents of a sorted list should read from lowest to highest in value
     */
    public void printFromHead() {
        Node current = head.next.next;
        while (current != null) {
            System.out.println(current.contents.toString() + "\n");
            current = current.next;
        }
    }

    /**
     * printFromLast()
     * Prints contents of entire linked list starting at last node
     * Contents of a sorted list should read from highest to lowest value
     */
    public void printFromLast(){
        Node current = last;
        while (current != head) {
            System.out.println(current.contents.toString() + "\n");
            current = current.prev;
        }
    }
}