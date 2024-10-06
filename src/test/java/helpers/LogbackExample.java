package helpers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackExample {

    // Logger initialization
    private static final Logger logger = LoggerFactory.getLogger(LogbackExample.class);

    public static void main(String[] args) {
        // Logging messages at different levels
        logger.info("Logging example using SLF4J + Logback");
        logger.debug("This is a DEBUG message - it will not be displayed due to the INFO logging level");
        logger.warn("This is a WARN message");
        logger.error("This is an ERROR message");

        // Exception logging example
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            logger.error("Error when dividing by zero: ", e);
        }
    }
}