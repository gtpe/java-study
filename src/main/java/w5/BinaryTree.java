package w5;

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

    }

    public void dfs(Node node) {
        if(node != null) {
            dfs(node.left);
            System.out.println(node.value);
            dfs(node.right);
        }
    }

}
