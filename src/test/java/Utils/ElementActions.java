package Utils;

import org.openqa.selenium.WebElement;

public class ElementActions {

    public static void clickWithRetry(WebElement element) {
        int attempts = 0;
        while (attempts < 3) {
            try {
                element.click();
                return;
            } catch (Exception e) {
                attempts++;
                if (attempts == 3) throw e;
            }
        }
    }

}
