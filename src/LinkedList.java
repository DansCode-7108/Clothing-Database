
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
         *
         * @param p
         */
        public Node(Product p) {
            contents = p;
            next = null;
            prev = null;
        }
    }

    /**
     *
     * @param p
     */
    public void insertBeginning(Product p) {
        Node newNode = new Node(p);
        newNode.next = head.next;
        newNode.next.prev = newNode;
        head.next = newNode;
        newNode.prev = head;
    }

    /**
     *
     * @param refNode
     * @param p
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
     *
     * @param p
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
     *
     * @param p
     * @return
     */
    public boolean remove(Product p) {
       if (null == head.next) return false;
       if (last.contents == p){
           last = last.prev;
           last.next = null;
           return true;
       }

       Node front = head.next;
       Node back = last;

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
     *
     * @param p
     * @return
     */
    boolean search(Product p) {
        Node currentNode = head.next;
        while (currentNode != null) {
            if (currentNode.contents == p) return true;
            currentNode = currentNode.next;
        }
        return false;
    }

    /**
     *
     */
    public void sortByPrice() {
        Node current = this.head;
        Node index;
        double temp;

        while (current != null) {
            // Index points to the next node
            index = current.next;

            while (index != null) {
                if (current.contents.price > index.contents.price) {
                    temp = current.contents.price;
                    current.contents.price = index.contents.price;
                    index.contents.price = temp;
                }
                index = index.next;
            }
            current = current.next;
        }
    }

    /**
     *
     */
    public void printFromHead() {
        Node current = head.next.next;
        while (current != null) {
            System.out.println("Gets Here");
            System.out.println(current.contents.toString() + "\n");
            current = current.next;
        }
    }

    /**
     *
     */
    public void printFromLast(){
        Node current = last;
        while (current != head) {
            System.out.println(current.contents.toString() + "\n");
            current = current.prev;
        }
    }
}