

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
        // insert the data
        Node newNode = new Node(p);
        newNode.next = head.next;
        newNode.next.prev = newNode;
        head.next = newNode;
        newNode.prev = head;

        if (head.next == last) {
            last = newNode;
        }
    }

    // Insert after any given node
    public void insert(Node refNode, Product p) {
        if (null == refNode) {
            System.out.println("The reference node cannot be null");
            return;
        }

        Node newNode = new Node(p);
        newNode.next = refNode.next;
        newNode.next.prev = newNode;
        refNode.next = newNode;
        newNode.prev = refNode;

        if (refNode == last) {
            last = newNode;
        }
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
        newNode.next = null;
        last = newNode;
    }

    // Delete a node
   //public void delete(Product p) {
   //    if ((last.contents == p) && (last.next == null)) return;

   //    Node current = head;

   //    if (index == 0) {
   //        head = current.next;
   //        return;
   //    }

   //    // Find the index node to be deleted
   //    for (int i = 0; null != current.next && i < index - 1; i++) {
   //        current = current.next;
   //    }

   //    // If the index is not present
   //    if (current == null || current.next == null) return;

   //    // Remove
   //    Node next = current.next.next;

   //    current.next = next;
   //}

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
        Node index = null;
        double temp;

        if (head.next == null) return;

        else {
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