package tests.cucumberJava.test;

import com.epam.training.framework.core.DriverWrapper;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.ScenarioType;

@CucumberOptions(format= {"pretty"},features="src\\test\\resources\\cart.feature")
public class UrlFeatureRunner extends AbstractTestNGCucumberTests {

}
