

public class LinkedList {
    Node head = new Node(new Product());
    Node last = new Node(new Product());

    public LinkedList() {
        head.next = last;
        last.prev = head;
        last.next = null;
    }

    // Node class for creating nodes
    public static class Node {
        Product contents;
        Node next;
        Node prev;

        public Node(Product p) {
            contents = p;
            next = null;
            prev = null;
        }
    }

    // Insert node in the beginning
    public void insertBeginning(Product p) {
        insert(this.head, p);
    }

    // Insert after any given node
    public void insert(Node refNode, Product p) {
        if (refNode == last){
            insertEnd(p);
            return;
        }
        if (null == refNode) {
            System.out.println("The reference node cannot be null");
            return;
        }

        Node newNode = new Node(p);
        newNode.next = refNode.next;
        newNode.next.prev = newNode;
        refNode.next = newNode;
        newNode.prev = refNode;
    }

    // Insert at the end node
    public void insertEnd(Product p) {

        if (head.next == last) {
            insertBeginning(p);
            return;
        }

        Node newNode = new Node(p);
        last.next = newNode;
        newNode.prev = last;
        last = newNode;
    }

    // Remove a node
   public void remove(Product p) {
       if (null == head.next) return;
       if (last.contents == p){
           last = last.prev;
           last.next = null;
           return;
       }

       Node front = head.next;
       Node back = last;

       while (front != back) {
           if (front.contents == p) {
               front.prev.next = front.next;
               front.next.prev = front.prev;
               return;
           } else if (null != front.next){
               front = front.next;
           }

           if (back.contents == p){
               back.prev.next = back.next;
               back.next.prev = back.prev;
               return;
           } else if (null != back.prev){
               back = back.prev;
           }
       }
   }

    // Search a node to see if it exists
    boolean search(Product p) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.contents == p) return true;
            currentNode = currentNode.next;
        }
        return false;
    }

    // Sorts the linked list using bubble sort
    public void sortList() {
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

    // Print the linked list
    public void printFromHead() {
        Node current = head;
        while (current != null) {
            System.out.println(current.contents.toString() + "\n");
            current = current.next;
        }
    }

    public void printFromLast(){
        Node current = last;
        while (current != head) {
            System.out.println(current.contents.toString() + "\n");
            current = current.prev;
        }
    }
}