package stepdefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import io.cucumber.java.en.*;

public class QA {

    WebDriver driver;
    String baseUrl = "https://qamaker-demo.tensai.run/";
    String edgeDriverPath = "C:/Users/2000129914/Downloads/edgedriver_win64/msedgedriver.exe";

    // XPath variables
    String usernameXPath = "//input[@placeholder='Please enter Employee ID']";
    String passwordXPath = "//input[@placeholder='Please enter password']";
    String signInButtonXPath = "//button[text()='Sign In']";
    String fileInputXPath = "//input[@type='file']";
    String uploadButtonXPath = "//button[text() = 'Upload File' and not (@aria-selected = 'true')]";
    String increaseButtonXPath = "//button[text()='+']";
    String level0RadioButtonXPath = "//input[@id='radio-0']";
    String runButtonXPath = "//p[text()='Run']";
    String checkboxXPath = "//input[@type='checkbox']";
    String generateAnswersButtonXPath = "//button[contains(@class, 'MuiButton-containedPrimary') and contains(., 'Generate Answers')]";
    String downloadButtonXPath = "//p[text()='Questions & Answers']//following::*[text()=' Download & Save']";
    String downloadAsExcelXPath = "//li[@role='menuitem']//p[text()='as excel']";
    String closeButtonXPath = "//p[text()='Questions & Answers']//preceding::*[name()='svg'][@data-testid='CloseIcon'][1]";
    String profileMenuButtonXPath = "//button[@aria-controls='profile-menu']";
    String logoutButtonXPath = "//li[@class='MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters MuiMenuItem-root MuiMenuItem-gutters css-1km1ehz']";
    String exitButtonXPath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-colorPrimary MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-colorPrimary css-1hw9j7s'][text()='Yes']";

    @Given("I open the QA Maker demo website")
    public void i_open_the_qa_maker_demo_website() {
        System.setProperty("webdriver.edge.driver", edgeDriverPath);
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @When("I enter the Employee ID and password")
    public void i_enter_the_employee_id_and_password() {
        WebElement usernameField = driver.findElement(By.xpath(usernameXPath));
        usernameField.sendKeys("1000077777");
        WebElement passwordField = driver.findElement(By.xpath(passwordXPath));
        passwordField.sendKeys("Hexaware@123");
    }

    @And("I click on the Sign In button")
    public void i_click_on_the_sign_in_button() {
        WebElement signinbutton = driver.findElement(By.xpath(signInButtonXPath));
        signinbutton.click();
    }

    @And("I upload the Certificate PDF file")
    public void i_upload_the_certificate_pdf_file() throws InterruptedException {
        Thread.sleep(3000);
        String file = System.getProperty("user.dir") + "/src/test/resources/Certificate sexual harrasment.pdf";
        WebElement fileInput = driver.findElement(By.xpath(fileInputXPath));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.display = 'block';", fileInput);
        fileInput.sendKeys(file);
    }

    @And("I click the Upload File button")
    public void i_click_the_upload_file_button() {
        WebElement uploadButton = driver.findElement(By.xpath(uploadButtonXPath));
        uploadButton.click();
    }

    @And("I increase the value by clicking the plus button")
    public void i_increase_the_value_by_clicking_the_plus_button() throws InterruptedException {
        WebElement increasebutton = driver.findElement(By.xpath(increaseButtonXPath));
        for (int i = 0; i < 5; i++) {
            increasebutton.click();
            Thread.sleep(3000);
        }
    }

    @And("I select the level 0 radio button")
    public void i_select_the_level_0_radio_button() {
        WebElement level0RadioButton = driver.findElement(By.xpath(level0RadioButtonXPath));
        level0RadioButton.click();
    }

    @And("I click the Run button")
    public void i_click_the_run_button() {
        WebElement runButton = driver.findElement(By.xpath(runButtonXPath));
        runButton.click();
    }

    @And("I select the checkbox")
    public void i_select_the_checkbox() throws InterruptedException {
        Thread.sleep(10000);
        WebElement checkbox = driver.findElement(By.xpath(checkboxXPath));
        checkbox.click();
    }

    @And("I click the Generate Answers button")
    public void i_click_the_generate_answers_button() throws InterruptedException {
        Thread.sleep(3000);
        WebElement button = driver.findElement(By.xpath(generateAnswersButtonXPath));
        button.click();
    }

    @And("I download the answers as Excel")
    public void i_download_the_answers_as_excel() throws InterruptedException {
        Thread.sleep(20000);
        WebElement downloadButton = driver.findElement(By.xpath(downloadButtonXPath));
        downloadButton.click();
        Thread.sleep(3000);
        WebElement downloadAsExcel = driver.findElement(By.xpath(downloadAsExcelXPath));
        downloadAsExcel.click();
    }

    @And("I close the Questions & Answers section")
    public void i_close_the_questions_answers_section() throws InterruptedException {
        Thread.sleep(6000);
        WebElement closeButton = driver.findElement(By.xpath(closeButtonXPath));
        closeButton.click();
        Thread.sleep(8000);
    }

    @And("I logout from the application")
    public void i_logout_from_the_application() throws InterruptedException {
        WebElement button1 = driver.findElement(By.xpath(profileMenuButtonXPath));
        button1.click();
        Thread.sleep(3000);
        WebElement logoutButton = driver.findElement(By.xpath(logoutButtonXPath));
        logoutButton.click();
        Thread.sleep(3000);
        WebElement exitbutton = driver.findElement(By.xpath(exitButtonXPath));
        exitbutton.click();
    }

    @Then("the script should execute successfully")
    public void the_script_should_execute_successfully() throws InterruptedException {
        Thread.sleep(3000);
        System.out.print("Script ok");
        driver.quit();
    }
}
