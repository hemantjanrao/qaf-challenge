package com.ui.framework.base;

import com.ui.framework.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

public class BaseUITest extends BaseTest {
    protected WebDriver wd = null;
    protected final Logger log = getLogger(lookup().lookupClass());

    @BeforeClass(alwaysRun = true)
    public void initializeDriver() {
        log.info("Start initializing the driver");
        try {
            wd = DriverManager.getWebDriver();
            wd.manage().window().maximize();
        } catch (Exception e) {
            Assert.fail("Error creating driver", e);
        }

        log.info("Finish initializing the driver");
    }

    @AfterClass(alwaysRun = true)
    public void destroyDriver() {
        try {
            log.info("Destroying the driver");
            wd.quit();
        } catch (UnhandledAlertException e) {
            wd.switchTo().alert().accept();
        }
    }

    public void takeScreenShot(String testName) {
        if (Objects.isNull(wd)) {
            log.warn("WebDriver is null, unable to save screenshot");
        }
        try {
            TakesScreenshot shot = (TakesScreenshot) this.wd;
            File file = (File) shot.getScreenshotAs(OutputType.FILE);
            String fileName = String.format("snapshot_%s.png", testName);
            Path path = Paths.get("target/screenshot", testName, fileName);
            Files.createDirectories(path.getParent());
            Files.copy(file.toPath(), path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            log.error("Screenshot saving failed", e);
        }
    }
}
