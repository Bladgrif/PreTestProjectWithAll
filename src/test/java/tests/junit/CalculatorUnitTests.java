package tests.junit;

import PreTestProjectWithAll.Calculator;
import helpers.RetryExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(RetryExtension.class)
public class CalculatorUnitTests {

    // Initializing a logger for a class
    private static final Logger logger = LoggerFactory.getLogger(CalculatorUnitTests.class);
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        logger.info("Initializing the Calculator object before each test");
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Testing addition of two numbers")
    @Tag("Unit")
    void testAdd() {
        logger.info("Running the test: testAdd");
        int result = calculator.addition(2, 3);
        logger.debug("Addition result: {}", result);
        assertEquals(5, result);
        logger.info("testAdd test completed successfully");
    }

    @Disabled("Some reason for disabled test : JIRA-1234")
    @Test
    @DisplayName("Testing subtraction of two numbers")
    @Tag("Unit")
    void testSubtract() {
        logger.info("Running the test: testSubtract");
        int result = calculator.subtract(3, 2);
        logger.debug("Subtraction result: {}", result);
        assertEquals(1, result);
        logger.info("testSubtract completed successfully");
    }

    @Test
    @DisplayName("Test for exception when dividing by zero")
    @Tag("Unit")
    void testDivideByZero() {
        logger.info("Running the test: testDivideByZero");
        logger.warn("Exception expected when dividing by zero");
        assertThrows(ArithmeticException.class, () -> calculator.division(1, 0));
        logger.info("testDivideByZero test completed: exception caught correctly");
    }

    @Test
    @DisplayName("Test with Mockito")
    @Tag("Unit")
    @Disabled
    void testWithMock() {
        logger.info("Running the test: testWithMock");
        Calculator mockCalculator = mock(Calculator.class);
        when(mockCalculator.addition(1, 2)).thenReturn(3);
        logger.debug("Mockito returned 3 for mockCalculator.addition(1, 2)");
        assertEquals(3, mockCalculator.addition(1, 2));
        logger.info("testWithMock completed successfully");
    }

    @RepeatedTest(5)
    @DisplayName("Repeated test for addition")
    @Tag("Unit")
    void repeatedTest(RepetitionInfo repetitionInfo) {
        int a = repetitionInfo.getCurrentRepetition();
        logger.info("Running a retest: {} of 5", a);
        int b = 2;
        int expectedResult = a + b;
        logger.debug("Add {} and {}, expected result: {}", a, b, expectedResult);
        assertEquals(expectedResult, calculator.addition(a, b));
        logger.info("Retest {} completed successfully", a);
    }

    @Nested
    @DisplayName("Tests for the add method")
    class AddTests {
        @Test
        @DisplayName("Test addition of two positive numbers")
        @Tag("Unit")
        void testAddPositiveNumbers() {
            logger.info("Running the test: testAddPositiveNumbers");
            int result = calculator.addition(2, 3);
            logger.debug("Result of adding positive numbers: {}", result);
            assertEquals(5, result);
            logger.info("testAddPositiveNumbers test completed successfully");
        }

        @Test
        @DisplayName("Test addition of two negative numbers")
        @Tag("Unit")
        void testAddNegativeNumbers() {
            logger.info("Running the test: testAddNegativeNumbers");
            int result = calculator.addition(-2, -3);
            logger.debug("Result of adding negative numbers: {}", result);
            assertEquals(-5, result);
            logger.info("testAddNegativeNumbers completed successfully");
        }
    }
}
