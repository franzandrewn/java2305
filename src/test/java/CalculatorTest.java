import lesson11.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    void init() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Testing basic multiply")
    void testBasicMultiply() {
        assertEquals(6, calculator.mul(2,3), "Assert 2*3=6");
        assertEquals(-6, calculator.mul(-2,3), "Assert -2*3=6");
        assertEquals(-6, calculator.mul(2,-3), "Assert 2*-3=6");
        assertEquals(6, calculator.mul(-2,-3), "Assert -2*-3=6");
    }

    @Test
    @DisplayName("Testing basic division")
    void testBasicDivision() {
        assertEquals(2, calculator.div(7, 3), "Assert 7/3=2");
        assertEquals(0, calculator.div(3, 7), "Assert 3/7=0");
        Throwable t = assertThrows(ArithmeticException.class, () -> calculator.div(5, 0), "Assert 5/0 throws ArithmeticException");
        assertEquals("/ by zero", t.getMessage(), "Arithmetic exception after 5/0 is division by zero");
    }

    @Test
    @DisplayName("Testing constructor")
    void testConstructor() {
        assertNotNull(new Calculator());
    }
}
