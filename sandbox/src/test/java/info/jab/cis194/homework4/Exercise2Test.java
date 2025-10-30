package info.jab.cis194.homework4;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import java.util.List;

class Exercise2Test {

    @Test
    void foldTree_buildsBalancedHeightAnnotatedTree() {
        var tree = Exercise2.foldTree(List.of('A','B','C','D','E','F','G','H','I','J'));
        assertThat(tree).isNotNull();
        assertThat(tree.isBalanced()).isTrue();
        assertThat(tree.height()).isGreaterThanOrEqualTo(0);
    }

    @Test
    void foldTree_handlesEmptyAndSingleton() {
        var empty = Exercise2.foldTree(List.<Character>of());
        assertThat(empty.isLeaf()).isTrue();

        var singleton = Exercise2.foldTree(List.of('Z'));
        assertThat(singleton.isLeaf()).isFalse();
        assertThat(singleton.height()).isEqualTo(0);
    }
}
