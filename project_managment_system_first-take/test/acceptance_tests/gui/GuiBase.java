package acceptance_tests.gui;

import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.Before;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationTest;
import planner.gui.*;
import java.util.concurrent.TimeoutException;


public abstract class GuiBase extends ApplicationTest {

    @Before
    public void setUp () throws Exception {
        ApplicationTest.launch(Main.class);
    }

    @Override
    public void start (Stage stage) throws Exception {
        stage.show();
    }

    @After
    public void tearDown() throws TimeoutException {
        FxToolkit.hideStage();
        release(new KeyCode[] {});
        release(new MouseButton[] {});
    }

}
