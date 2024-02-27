package testutils;

import driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener implements ITestListener {
    private final Logger log = LogManager.getRootLogger();

    @Override
    public void onTestFailure(ITestResult result) {
        saveScreenshot(result.getName());
    }

    private void saveScreenshot(String testName) {
        File screenshotFile = ((TakesScreenshot) DriverManager.getDriver())
                .getScreenshotAs(OutputType.FILE);
        try {
            String destinationPath = "./target/screenshots/" + testName + "_" + getCurrentTimeAsString() + ".png";
            Files.copy(screenshotFile.toPath(), new File(destinationPath).toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            log.error("Failed to save screenshot: " + e.getLocalizedMessage());
        }
    }

    private String getCurrentTimeAsString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm-ss");
        return LocalDateTime.now().format(formatter);
    }
}