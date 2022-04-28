class LinkedList {
    Node head;

    // Node class for creating nodes
    class Node {
        int val;
        Node next;

        Node(int x) {
            val = x;
            next = null;
        }
    }

    // Insert node in the beginning
    public void insertBeginning(int data) {
        // insert the data
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Insert after any given node
    public void insert(Node prevNode, int data) {
        if (prevNode == null) {
            System.out.println("The previous node cannot be null");
            return;
        }
        Node newNode = new Node(data);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
    }

    // Insert at the end node
    public void insertEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = new Node(data);
            return;
        }

        newNode.next = null;

        Node last = head;
        while (last.next != null) {
            last = last.next;
        }

        last.next = newNode;
        return;
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
    boolean search(Node head, int key) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.val == key) return true;
            currentNode = currentNode.next;
        }
        return false;
    }

    // Sorts the linked list using bubble sort
    void sortList(Node head) {
        Node currentNode = head;
        Node index = null;
        int temp;

        if (head == null) return;
        
        else {
            while (currentNode != null) {
                // Index points to the next node
                index = currentNode.next;

                while (index != null) {
                    if (currentNode.val > index.val) {
                        temp = currentNode.val;
                        currentNode.val = index.val;
                        index.val = temp;
                    }
                    index = index.next;
                }
                currentNode = currentNode.next;
            }
        }
    }

    // Print the linked list
    public void printList() {
        Node node = head;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }

    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insertEnd(1);
        list.insertBeginning(2);
        list.insertBeginning(3);
        list.insertEnd(4);
        list.insert(list.head.next, 5);

        System.out.println("Linked list: ");
        list.printList();
        
        System.out.println("After deleting: ");
        list.delete(3);
        list.printList();

        list.sortList(list.head);
        System.out.println("Sorted List: ");
        list.printList();
    }
}
