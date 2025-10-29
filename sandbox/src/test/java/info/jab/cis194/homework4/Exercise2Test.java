package info.jab.cis194.homework4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class Exercise2Test {

    @Test
    public void testFoldTree() {
        Exercise2 exercise2 = new Exercise2();
        
        // Test with empty list
        Tree<String> emptyTree = exercise2.foldTree(Arrays.asList());
        assertTrue(emptyTree instanceof Tree.Leaf, "Empty list should produce a Leaf");
        
        // Test with single element
        Tree<String> singleTree = exercise2.foldTree(Arrays.asList("A"));
        assertTrue(singleTree instanceof Tree.Node, "Single element should produce a Node");
        if (singleTree instanceof Tree.Node<String> node) {
            assertEquals(0, node.height(), "Single node should have height 0");
            assertEquals("A", node.value(), "Single node should contain the element");
        }
        
        // Test with two elements
        Tree<String> twoTree = exercise2.foldTree(Arrays.asList("A", "B"));
        assertTrue(twoTree instanceof Tree.Node, "Two elements should produce a Node");
        if (twoTree instanceof Tree.Node<String> node) {
            assertEquals(1, node.height(), "Two elements should have height 1");
        }
        
        // Test with multiple elements - should be balanced
        Tree<String> multiTree = exercise2.foldTree(Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J"));
        assertTrue(multiTree instanceof Tree.Node, "Multiple elements should produce a Node");
        if (multiTree instanceof Tree.Node<String> node) {
            assertEquals(3, node.height(), "Ten elements should have height 3");
            // Verify the tree is balanced by checking that left and right subtrees
            // have heights that differ by at most 1
            assertTrue(isBalanced(node), "Tree should be balanced");
        }
    }
    
    private boolean isBalanced(Tree<?> tree) {
        if (tree instanceof Tree.Leaf<?>) {
            return true;
        } else if (tree instanceof Tree.Node<?> node) {
            int leftHeight = getHeight(node.left());
            int rightHeight = getHeight(node.right());
            
            return Math.abs(leftHeight - rightHeight) <= 1 && 
                   isBalanced(node.left()) && 
                   isBalanced(node.right());
        }
        return true;
    }
    
    private int getHeight(Tree<?> tree) {
        if (tree instanceof Tree.Leaf) {
            return -1; // Leaf has height -1 (no nodes)
        } else if (tree instanceof Tree.Node<?> node) {
            return node.height();
        }
        return -1;
    }
}