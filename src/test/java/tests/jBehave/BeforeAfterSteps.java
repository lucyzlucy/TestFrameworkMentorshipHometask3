package tests.jBehave;

import com.epam.training.framework.core.DriverWrapper;
import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.ScenarioType;


public class BeforeAfterSteps {
    @BeforeScenario(uponType = ScenarioType.ANY)
    public void beforeAnyScenario() {
        DriverWrapper.setDriver();
    }

    @AfterScenario(uponType = ScenarioType.ANY)
    public void afterAnyScenario() {
        DriverWrapper.killDriverInstance();
    }
}