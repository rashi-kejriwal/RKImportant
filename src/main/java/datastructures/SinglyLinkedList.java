package datastructures;

public class SinglyLinkedList {
    Node head;  // head of list

    /* Node Class */
    class Node
    {
        int data;
        Node next;

        // Constructor to create a new node
        Node(int d) {data = d; next = null; }
    }

    /* This function is in LinkedList class. Inserts a
   new Node at front of the list. This method is
   defined inside LinkedList class shown above */
    public void push(int new_data)
    {
    /* 1 & 2: Allocate the Node &
              Put in the data*/
        Node new_node = new Node(new_data);

    /* 3. Make next of new Node as head */
        new_node.next = head;

    /* 4. Move the head to point to new Node */
        head = new_node;
    }

    /* Appends a new node at the end.  This method is
   defined inside LinkedList class shown above */
    public void append(int new_data)
    {
    /* 1. Allocate the Node &
       2. Put in the data
       3. Set next as null */
        Node new_node = new Node(new_data);

    /* 4. If the Linked List is empty, then make the
           new node as head */
        if (head == null)
        {
            head = new Node(new_data);
            return;
        }

    /* 4. This new node is going to be the last node, so
         make next of it as null */
        new_node.next = null;

    /* 5. Else traverse till the last node */
        Node last = head;
        while (last.next != null)
            last = last.next;

    /* 6. Change the next of last node */
        last.next = new_node;
        return;
    }

    /* Given a key, deletes the first occurrence of key in linked list */
    void deleteNode(int key)
    {
        // Store head node
        Node temp = head, prev = null;

        // If head node itself holds the key to be deleted
        if (temp != null && temp.data == key)
        {
            head = temp.next; // Changed head
            return;
        }

        // Search for the key to be deleted, keep track of the
        // previous node as we need to change temp.next
        while (temp != null && temp.data != key)
        {
            prev = temp;
            temp = temp.next;
        }

        // If key was not present in linked list
        if (temp == null) return;

        // Unlink the node from linked list
        prev.next = temp.next;
    }

    /* Given a reference (pointer to pointer) to the head of a list
      and a position, deletes the node at the given position */
    void deleteNodeAtPosition(int position)
    {
        // If linked list is empty
        if (head == null)
            return;

        // Store head node
        Node temp = head;

        // If head needs to be removed
        if (position == 0)
        {
            head = temp.next;   // Change head
            return;
        }

        // Find previous node of the node to be deleted
        for (int i=0; temp!=null && i<position-1; i++)
            temp = temp.next;

        // If position is more than number of ndoes
        if (temp == null || temp.next == null)
            return;

        // Node temp->next is the node to be deleted
        // Store pointer to the next of node to be deleted
        Node next = temp.next.next;

        temp.next = next;  // Unlink the deleted node from list
    }

    Node reverse(Node node) {
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }
}
