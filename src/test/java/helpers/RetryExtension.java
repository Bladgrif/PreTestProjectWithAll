package helpers;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

public class RetryExtension implements TestExecutionExceptionHandler {

    private int retryCount = 3;  // Количество попыток повторного запуска

    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
        if (retryCount > 0) {
            retryCount--;
            System.out.println("Rerunning the test: " + context.getDisplayName() + " (Attempts left: " + retryCount + ")");
            context.getRequiredTestMethod().invoke(context.getRequiredTestInstance());
        } else {
            throw throwable;  // Если количество попыток истекло, тест окончательно провален
        }
    }
}
