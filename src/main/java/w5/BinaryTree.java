package w5;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    public Node addNode(Node node, int value) {
        if(node == null) {
            node = new Node(value);
            return node;
        }
        if(value < node.value) {
            node.left = addNode(node.left, value);
        } else if(value > node.value) {
            node.right = addNode(node.right, value);
        }
        return node;
    }

    public void bfs(Node node) {
        Queue<Node> queue = new LinkedList();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            System.out.print(currentNode.value + " ");
            if(currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if(currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
    }

    public void dfs(Node node) {
        if(node != null) {
            dfs(node.left);
            System.out.print(node.value + " ");
            dfs(node.right);
        }
    }

}
