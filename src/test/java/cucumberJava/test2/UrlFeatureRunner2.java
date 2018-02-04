package cucumberJava.test2;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(format= {"pretty"},features="src\\test\\resources\\url.feature")
public class UrlFeatureRunner2 extends AbstractTestNGCucumberTests {

}
