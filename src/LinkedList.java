

public class LinkedList {
    Node head = new Node(new Product());
    Node last = new Node(new Product());

    public LinkedList() {
        head.next = last;
        last.prev = head;
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
        Node newNode = new Node(p);
        newNode.next = head.next;
        newNode.next.prev = newNode;
        head.next = newNode;
        newNode.prev = head;
    }

    // Insert after any given node
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

    // Insert at the end node
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

    // Remove a node
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

    // Search a node to see if it exists
    boolean search(Product p) {
        Node currentNode = head.next;
        while (currentNode != null) {
            if (currentNode.contents == p) return true;
            currentNode = currentNode.next;
        }
        return false;
    }

    // Sorts the linked list using bubble sort
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

    // Print the linked list
    public void printFromHead() {
        Node current = head.next.next;
        while (current != null) {
            System.out.println("Gets Here");
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