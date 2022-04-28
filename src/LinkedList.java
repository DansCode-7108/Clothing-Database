

public class LinkedList {
    Node head;
    Node last;

    public LinkedList() {
        head.next = last;
        last.prev = head;
        last.next = null;
    }

    // Node class for creating nodes
    public class Node {
        Product contents;
        Node next;
        Node prev;

        Node(Product p) {
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
    void delete(int index) {
        if (head == null) return;

        Node temp = head;

        if (index == 0) {
            head = temp.next;
            return;
        }

        // Find the index node to be deleted
        for (int i = 0; temp != null && i < index - 1; i++) {
            temp = temp.next;
        }

        // If the index is not present
        if (temp == null || temp.next == null) return;

        // Remove 
        Node next = temp.next.next;

        temp.next = next;
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
    void sortList() {
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
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.println(current.contents.toString());
            current = current.next;
        }

    }
}