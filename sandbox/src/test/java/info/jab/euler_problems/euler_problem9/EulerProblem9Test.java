package info.jab.euler_problems.euler_problem9;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EulerProblem9Test {

    @Test
    void shouldFindPythagoreanTripletProduct() {
        // Given
        int sum = 1000;
        
        // When
        long product = EulerProblem9.findPythagoreanTripletProduct(sum);
        
        // Then
        assertThat(product).isEqualTo(31875000L);
    }

    @Test
    void shouldFindPythagoreanTripletProductForKnownExample() {
        // Given: 3? + 4? = 5?, 3 + 4 + 5 = 12
        int sum = 12;
        
        // When
        long product = EulerProblem9.findPythagoreanTripletProduct(sum);
        
        // Then
        assertThat(product).isEqualTo(3 * 4 * 5); // 60
    }
}
