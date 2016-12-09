package cucumberJava.test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/**
 * Created by Andrii_Valkovskyi on 12/7/2016.
 */

@CucumberOptions(format= {"pretty"},features="src\\test\\resources\\url.feature")
public class UrlFeatureRunner extends AbstractTestNGCucumberTests {

}
