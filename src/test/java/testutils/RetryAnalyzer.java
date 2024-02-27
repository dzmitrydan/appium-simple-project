package testutils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import static utils.PropertyFileReader.getProperty;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int counter = 0;

    @Override
    public boolean retry(ITestResult result) {
        int retryLimit = Integer.parseInt(getProperty("retry.run.limit"));
        if (counter < retryLimit) {
            counter++;
            return true;
        }
        return false;
    }
}
