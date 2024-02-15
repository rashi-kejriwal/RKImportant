package datastructures;

import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversal {

    // Java program to construct BST from given preorder traversal

    // A binary tree node
    class Node {

        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    void printInorder(Node node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    void printPreorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    void printPostorder(Node node) {
        if (node == null) {
            return;
        }
        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.data + " ");
    }

    static void printLevelOrder(Node root) {
        // Base Case
        if (root == null)
            return;

        // Create an empty queue for level order tarversal
        Queue<Node> q = new LinkedList<Node>();

        // Enqueue Root and initialize height
        q.add(root);


        while (true) {

            // nodeCount (queue size) indicates number of nodes
            // at current level.
            int nodeCount = q.size();
            if (nodeCount == 0)
                break;

            // Dequeue all nodes of current level and Enqueue all
            // nodes of next level
            while (nodeCount > 0) {
                Node node = q.peek();
                System.out.print(node.data + " ");
                q.remove();
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
                nodeCount--;
            }
            System.out.println();
        }
    }
}
