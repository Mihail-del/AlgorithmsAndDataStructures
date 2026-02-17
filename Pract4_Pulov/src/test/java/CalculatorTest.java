import org.junit.jupiter.api.Test;
import ua.univercity.Calculator;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void shouldDivideCorrectly() {
        int result = calculator.divide(10, 2);

        assertEquals(5, result, "10/2 must be 5");
    }

    @Test
    void shouldThrowExceptionWhenDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10, 0);
        }, "Must be an exception");
    }
}