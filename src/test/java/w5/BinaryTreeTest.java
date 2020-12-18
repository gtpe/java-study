package w5;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream printStream = System.out;

    BinaryTree binaryTree = new BinaryTree();
    Node node = new Node(5);

    @BeforeEach
    void before() {
        System.setOut(new PrintStream(outputStream));

        binaryTree.addNode(node, 3);
        binaryTree.addNode(node, 7);
        binaryTree.addNode(node, 2);
        binaryTree.addNode(node, 4);
        binaryTree.addNode(node, 6);
        binaryTree.addNode(node, 8);
    }

    @AfterEach
    void after() {
        System.setOut(printStream);
    }

    @Test
    void bfs() {
        binaryTree.bfs(node);
        assertEquals("5 3 7 2 4 6 8 ", outputStream.toString());
    }

    @Test
    void dfs() {
        binaryTree.dfs(node);
        assertEquals("2 3 4 5 6 7 8 ", outputStream.toString());
    }

}