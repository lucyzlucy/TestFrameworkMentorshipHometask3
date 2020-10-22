package tests.simpleFramework;

import com.epam.training.framework.core.DriverWrapper;
import com.epam.training.framework.core.Log;
import org.testng.annotations.*;

import static org.openqa.selenium.remote.server.DefaultSession.createSession;

public class BaseTest {
    @BeforeMethod
    public void setUpDriver() {
        DriverWrapper.setDriver();
        Log.log("driver set");
    }

    @AfterMethod
    public void tearDown() {
        DriverWrapper.killDriverInstance();
        Log.log("driver killed");
    }
}

