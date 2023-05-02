import data.Departments;
import data.Languages;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

public class PositionsCounterTest {
    private static Stream<Arguments> careersValidCases() {
        return Stream.of(
                Arguments.of(Departments.RND.getValues(), Languages.EN.getValues(), 8)
        );
    }

    public ChromeDriver driver;

    /**
     * Initialize the WebDriverManager and ChromeDriver.
     * Go to the website under Test and maximize the browser window.
     */
    @BeforeEach
    public void setupUrl() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        CareersPage.getBaseUrl(driver);
    }

    /**
     * Close the browser window.
     */
    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    /**
     * Test to count positions on Careers page.
     */
    @ParameterizedTest
    @MethodSource("careersValidCases")
    @Tag("Career")
    void openPage(String expectedDepartment, String expectedLanguage, int expectedResultsOnPage) {
        var CareersPage = new CareersPage(driver);

        assertThat(driver.getTitle()).isEqualTo(CareersPage.careersTitle);
        CareersPage.declineCookies();
        CareersPage.setDepartment();
        CareersPage.selectLanguage();
        CareersPage.clickLanguage();

        assertSoftly(softly -> {
            softly.assertThat(CareersPage.getDepartment()).isEqualTo(expectedDepartment);
            softly.assertThat(CareersPage.getLanguage()).isEqualTo(expectedLanguage);
            softly.assertThat(CareersPage.cardSize()).isEqualTo(expectedResultsOnPage);
        });
    }
}