package cucumberJava.test2;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/**
 * Created by Andrii_Valkovskyi on 12/7/2016.
 */

@CucumberOptions(format= {"pretty"},features="src\\test\\resources\\url.feature")
public class UrlFeatureRunner2 extends AbstractTestNGCucumberTests {

}
