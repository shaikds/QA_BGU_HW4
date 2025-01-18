import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrestaShopGetInItem {
    private WebDriver driver;

    public PrestaShopGetInItem() {
        System.getProperty("/Users/shaikds/Downloads/QA_HW4/2025-mbt-ar-main/Selenium/chromedriver.exe");

        this.driver = new ChromeDriver();
    }

    public void navigateToItem() throws InterruptedException {
        // Navigate to PrestaShop website
        driver.get("http://localhost:8080/");

        WebElement firstProductItem = driver.findElement(By.xpath("//section[1]/div[1]/div[1]/article[1]/div[1]/div[2]/h3[1]/a[1]\n"));
        firstProductItem.click();
        Thread.sleep(1000);
    }

    public void openCommentDialog() throws InterruptedException {

        WebElement commentBtn = driver.findElement(By.xpath("//section[1]/div[3]/button[1]\n"));
        commentBtn.click();
        Thread.sleep(1000);

    }

    public void writeComment(String title, String name, String review) throws InterruptedException {
        // fill review form
        WebElement titleElement = driver.findElement(By.xpath("//*[@id='comment_title']\n"));
        titleElement.sendKeys(title);
        WebElement guestNameElement = driver.findElement(By.xpath("//*[@id='customer_name']\n"));
        guestNameElement.sendKeys(name);
        WebElement reviewElement = driver.findElement(By.xpath("//*[@id='comment_content']\n"));
        reviewElement.sendKeys(review);
        Thread.sleep(1000);

        /// send review
        WebElement sendReviewBtn = driver.findElement(By.xpath("//div[3]/div[2]/button[2]\n"));
        sendReviewBtn.click();
        Thread.sleep(1000);
    }

    public void adminLogin() throws InterruptedException {
        // navigate to admin panel
        driver.get("http://localhost:8080/admina");

        // login
        WebElement email = driver.findElement(By.xpath("//*[@id='email']\n"));
        email.sendKeys("check@check.check");
        WebElement password = driver.findElement(By.xpath("//*[@id='passwd']\n"));
        password.sendKeys("12345678");

        WebElement btnLogin = driver.findElement(By.xpath("//form[1]/div[3]\n"));
        btnLogin.click();
        Thread.sleep(1000);
    }

    public void performSearch() {
        // Locate the search input field by its ID
        WebElement searchInput = driver.findElement(By.id("bo_query"));

        // Enter the search query into the input field
        searchInput.sendKeys("Comment");

        // submit the query
        searchInput.sendKeys(Keys.ENTER);

    }

    public void toggleComments(boolean isOn) throws InterruptedException {
        WebElement commentsSection = driver.findElement(By.xpath("//strong[1]/span[1]\n"));
        commentsSection.click();

        WebElement productCommentsModule = driver.findElement(By.xpath("//div[4]/div[2]/a[1]\n"));
        productCommentsModule.click();

        WebElement reviewValidationBtn = driver.findElement(By.xpath("//*[@id='PRODUCT_COMMENTS_MODERATE_on']\n"));
        reviewValidationBtn.click();

        WebElement allowComments = driver.findElement(By.xpath("//*[@id='PRODUCT_COMMENTS_ALLOW_GUESTS_off']\n"));
        allowComments.isSelected();
        boolean isToggleActive = allowComments.isDisplayed(); // Check if the 'on' button is displayed or not

        WebElement saveBtn = driver.findElement(By.xpath("//*[@id='productcomments_form_submit_btn']\n"));
        saveBtn.click();
        Thread.sleep(1000);

    }

}
