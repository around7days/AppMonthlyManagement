package rms.selenium.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ユーザ一覧画面クラス
 */
public class UserListPage extends rms.selenium.page.CommonPage {

    /** ロガー */
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(UserListPage.class);

    /** 検索条件_ユーザID */
    @FindBy(id = "condition.userId")
    @CacheLookup
    private WebElement 検索条件_ユーザID;

    /** 検索条件_ユーザ名 */
    @FindBy(id = "condition.userNm")
    @CacheLookup
    private WebElement 検索条件_ユーザ名;

    /** 戻るボタン */
    @FindBy(id = "back")
    @CacheLookup
    private WebElement 戻るボタン;

    /** 検索ボタン */
    @FindBy(id = "search")
    @CacheLookup
    private WebElement 検索ボタン;

    /** 新規ボタン */
    @FindBy(id = "insert")
    @CacheLookup
    private WebElement 新規ボタン;

    /** 検索結果_選択ボタン */
    @FindBy(css = "#resultTable button[name='select']")
    @CacheLookup
    private List<WebElement> 検索結果_選択ボタン;

    /**
     * PageFactoryを使用してWebElementをマッピングする
     * @param driver
     * @return ユーザ一覧画面
     */
    public UserListPage initialize(WebDriver driver) {
        return PageFactory.initElements(driver, this.getClass());
    }

    public WebElement 検索条件_ユーザID() {
        return this.検索条件_ユーザID;
    }

    public WebElement 検索条件_ユーザ名() {
        return this.検索条件_ユーザ名;
    }

    public WebElement 戻るボタン() {
        return this.戻るボタン;
    }

    public WebElement 検索ボタン() {
        return this.検索ボタン;
    }

    public WebElement 新規ボタン() {
        return this.新規ボタン;
    }

    public List<WebElement> 検索結果_選択ボタン() {
        return this.検索結果_選択ボタン;
    }

}
