import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CareersPage {
    public WebDriver driver;

    @FindBy(css = ".form-group [type='search']")
    private WebElement keywords;

    @FindBy(css = "div.form-group:nth-child(2)")
    private WebElement departments;

    @FindBy(css = "div.form-group:nth-child(3)")
    private WebElement languages;

    @FindBy(css = "[id='lang-option-0']")
    private WebElement english;

    @FindBy(css = "div.form-group:nth-child(4)")
    private WebElement experience;

    @FindBy(css = "[id='cookiescript_injected']")
    private WebElement cookiesPopup;

    @FindBy(css = "[id='cookiescript_reject']")
    private WebElement declineBtn;

    @FindBy(css = "[class='display-1 header-custom-spacer']")
    private WebElement header;

    @FindBy(css = "[class='card card-sm card-no-hover']")
    private List<WebElement>  positionCards;

    public CareersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String careersTitle = "Career at Veeam Software – Czech Republic";

    static String url = "https://cz.careers.veeam.com/vacancies";

    /**
     * Initialize the WebDriver instance.
     * Get the current URL and set it as the base URL.
     */
    static void getBaseUrl(WebDriver driver) {
        driver.get(url);
    }

    public void setDepartment() {
        departments.click();
        driver.findElement(By.linkText("Research & Development")).click();
    }

    public void selectLanguage() {
        languages.click();
        english.click();
    }

    public void clickLanguage() {
        languages.click();
    }

    public String getDepartment() {
        return departments.getText();
    }

    public String getLanguage() {
        return languages.getText();
    }

    public void declineCookies() {
        declineBtn.click();
    }

  public int cardSize(){
      return   positionCards.size();
  }
}
