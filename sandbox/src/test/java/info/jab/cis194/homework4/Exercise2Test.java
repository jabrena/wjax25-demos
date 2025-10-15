package info.jab.cis194.homework4;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class Exercise2Test {

    @Test
    public void testFoldTreeEmptyList() {
        List<String> empty = Arrays.asList();
        Tree<String> result = Exercise2.foldTree(empty);
        assertNull(result);
    }

    @Test
    public void testFoldTreeSingleElement() {
        List<String> list = Arrays.asList("A");
        Tree<String> result = Exercise2.foldTree(list);
        
        assertNotNull(result);
        assertTrue(result.isLeaf());
        assertEquals("A", result.getValue());
        assertEquals(0, result.getHeight());
    }

    @Test
    public void testFoldTreeTwoElements() {
        List<String> list = Arrays.asList("A", "B");
        Tree<String> result = Exercise2.foldTree(list);
        
        assertNotNull(result);
        assertFalse(result.isLeaf());
        assertEquals(1, result.getHeight());
        // For 2 elements, one subtree will be null and the other will be a leaf
        assertTrue(result.getLeft() != null || result.getRight() != null);
    }

    @Test
    public void testFoldTreeThreeElements() {
        List<String> list = Arrays.asList("A", "B", "C");
        Tree<String> result = Exercise2.foldTree(list);
        
        assertNotNull(result);
        assertFalse(result.isLeaf());
        assertEquals(1, result.getHeight());
    }

    @Test
    public void testFoldTreeFourElements() {
        List<String> list = Arrays.asList("A", "B", "C", "D");
        Tree<String> result = Exercise2.foldTree(list);
        
        assertNotNull(result);
        assertFalse(result.isLeaf());
        assertEquals(2, result.getHeight());
    }

    @Test
    public void testFoldTreeTenElements() {
        List<String> list = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J");
        Tree<String> result = Exercise2.foldTree(list);
        
        assertNotNull(result);
        assertFalse(result.isLeaf());
        assertEquals(3, result.getHeight());
        
        // Verify the tree is balanced
        assertTrue(isBalanced(result));
    }

    @Test
    public void testFoldTreeWithIntegers() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Tree<Integer> result = Exercise2.foldTree(list);
        
        assertNotNull(result);
        assertFalse(result.isLeaf());
        assertTrue(isBalanced(result));
    }

    @Test
    public void testTreeHeightCalculation() {
        List<String> list = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J");
        Tree<String> result = Exercise2.foldTree(list);
        
        // Verify height is calculated correctly
        verifyHeight(result);
    }

    @Test
    public void testFoldTreeWithCharacters() {
        List<Character> list = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J');
        Tree<Character> result = Exercise2.foldTree(list);
        
        assertNotNull(result);
        assertFalse(result.isLeaf());
        assertEquals(3, result.getHeight());
        assertTrue(isBalanced(result));
    }

    @Test
    public void testFoldTreeLargeList() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        Tree<Integer> result = Exercise2.foldTree(list);
        
        assertNotNull(result);
        assertFalse(result.isLeaf());
        assertTrue(isBalanced(result));
        verifyHeight(result);
    }

    // Helper method to check if a tree is balanced
    private boolean isBalanced(Tree<?> tree) {
        if (tree == null || tree.isLeaf()) {
            return true;
        }
        
        int leftHeight = tree.getLeft() != null ? tree.getLeft().getHeight() : -1;
        int rightHeight = tree.getRight() != null ? tree.getRight().getHeight() : -1;
        
        return Math.abs(leftHeight - rightHeight) <= 1 
            && isBalanced(tree.getLeft()) 
            && isBalanced(tree.getRight());
    }

    // Helper method to verify height calculation
    private void verifyHeight(Tree<?> tree) {
        if (tree == null || tree.isLeaf()) {
            return;
        }
        
        int leftHeight = tree.getLeft() != null ? tree.getLeft().getHeight() : -1;
        int rightHeight = tree.getRight() != null ? tree.getRight().getHeight() : -1;
        int expectedHeight = Math.max(leftHeight, rightHeight) + 1;
        
        assertEquals(expectedHeight, tree.getHeight());
        
        if (tree.getLeft() != null) {
            verifyHeight(tree.getLeft());
        }
        if (tree.getRight() != null) {
            verifyHeight(tree.getRight());
        }
    }
}