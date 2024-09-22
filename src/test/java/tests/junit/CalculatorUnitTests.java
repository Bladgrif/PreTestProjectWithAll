package tests.junit;



import PreTestProjectWithAll.Calculator;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class CalculatorUnitTests {

    private Calculator calculator;

    @BeforeEach
    void setUp(){
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Testing addition of two numbers")
    @Tag("unit")
    void testAdd() {
        assertEquals(5, calculator.addition(2, 3));
    }

    @Disabled("Some reason for disabled test : JIRA-1234")
    @Test
    @DisplayName("Testing subtraction of two numbers")
    @Tag("unit")
    void testSubtract() {
        assertEquals(1, calculator.subtract(3, 2));
    }

    @Test
    @DisplayName("Test for exception when dividing by zero")
    @Tag("unit")
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.division(1, 0));
    }

    @Test
    @DisplayName("Test with Mockito")
    @Tag("unit")
    void testWithMock() {
        Calculator mockCalculator = mock(Calculator.class);
        when(mockCalculator.addition(1, 2)).thenReturn(3);

        assertEquals(3, mockCalculator.addition(1, 2));
    }

    @RepeatedTest(5)
    @DisplayName("Repeated test for addition")
    @Tag("unit")
    void repeatedTest(RepetitionInfo repetitionInfo) {
        int a = repetitionInfo.getCurrentRepetition();
        int b = 2;
        int expectedResult = a + b;
        assertEquals(expectedResult, calculator.addition(a, b));
    }

    @Nested
    @DisplayName("Tests for the add method")
    class AddTests {
        @Test
        @DisplayName("Test addition of two positive numbers")
        @Tag("unit")
        void testAddPositiveNumbers() {
            assertEquals(5, calculator.addition(2, 3));
        }

        @Test
        @DisplayName("Test addition of two negative numbers")
        @Tag("unit")
        void testAddNegativeNumbers() {
            assertEquals(-5, calculator.addition(-2, -3));
        }
    }

}


