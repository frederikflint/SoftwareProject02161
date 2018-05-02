package acceptance_tests.gui;

import org.junit.Test;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.LabeledMatchers.hasText;

public class GuiLogin extends GuiBase {

    @Test
    public void logInSuccessAdmin() {
        clickOn("#credentials");
        write("admin");
        clickOn("#password");
        write("admin123");
        clickOn("#login");
    }

    @Test
    public void logInSuccessDeveloper() {
        clickOn("#credentials");
        write("test");
        clickOn("#password");
        write("test");
        clickOn("#login");
    }

    @Test
    public void logInFail() {
        clickOn("#credentials");
        write("Wrong");
        clickOn("#password");
        write("Wrong");
        clickOn("#login");
        verifyThat("#error", hasText("Your credentials or password was wrong"));
    }

}
