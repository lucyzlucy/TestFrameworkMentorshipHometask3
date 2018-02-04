package cucumberJava.test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(format= {"pretty"},features="src\\test\\resources\\url.feature")
public class UrlFeatureRunner extends AbstractTestNGCucumberTests {

}
