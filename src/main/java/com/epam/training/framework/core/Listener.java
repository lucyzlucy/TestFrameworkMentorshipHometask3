package com.epam.training.framework.core;


import com.epam.training.framework.enums.LogType;
import org.apache.commons.lang.time.DateFormatUtils;
import org.testng.*;
import com.epam.training.framework.utils.Propertiator;
import com.epam.training.framework.utils.ScreenshotUtils;

import java.util.LinkedList;
import java.util.List;
 
public class Listener implements ITestListener, ISuiteListener, IInvokedMethodListener {
    protected List<String> suiteResult = new LinkedList<String>();
    // This belongs to ISuiteListener and will execute before the Suite start
 
    //@Override
     public void onStart(ISuite arg0) {

        //Reporter.log("About to begin executing Suite " + arg0.getName(), true);
 
    }
 
    // This belongs to ISuiteListener and will execute, once the Suite is finished
 
    //@Override
     public void onFinish(ISuite arg0) {
       
        //Reporter.log("About to end executing Suite " + arg0.getName(), true);
     }
 
    // This belongs to ITestListener and will execute before starting of Test set/batch 
 
    public void onStart(ITestContext arg0) {

        
       // Reporter.log("About to begin executing Test " + arg0.getName(), true);
 
    }
 
    // This belongs to ITestListener and will execute, once the Test set/batch is finished
 
    public void onFinish(ITestContext arg0) {
        String type = Propertiator.getPropertie("email");
        if(Boolean.parseBoolean(type)) {
            StringBuilder result = new StringBuilder();
            for(String res : suiteResult) {
                result.append(res);
            }
            Log.log(result.toString(), LogType.ERROR);
        }
            DriverWrapper.getDriver().quit();
       // Reporter.log("Completed executing test " + arg0.getName(), true);
    }
 
    // This belongs to ITestListener and will execute only when the test is pass
 
    public void onTestSuccess(ITestResult arg0) {
        String temp = String.format("\r\n %s has passed on %s \r\n", arg0.getMethod().getMethodName(), DateFormatUtils.format(arg0.getEndMillis(),"yyyy-MM-dd hh:mm"));
        suiteResult.add(temp);
        Log.log(String.valueOf(arg0.getEndMillis()-arg0.getStartMillis()));//milliseconds of running
        // This is calling the printTestResults method
 
      //  printTestResults(arg0);
 
    }
 
    // This belongs to ITestListener and will execute only on the event of fail test
 
    public void onTestFailure(ITestResult arg0) {
      //don't send email when executed in debug mod
       // if(java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments().toString().indexOf("-agentlib:jdwp") <= 0) {
           // Log.log("Error has occured in test"+ arg0.getMethod().getMethodName() + " on " + DateFormatUtils.format(arg0.getEndMillis(),"yyyy-MM-dd hh:mm") + " " + arg0.getThrowable().getMessage(), LogType.ERROR);
       // }
        String temp = String.format("\r\n %s has passed on %s \r\n %s \r\n", arg0.getMethod().getMethodName(), DateFormatUtils.format(arg0.getEndMillis(),"yyyy-MM-dd hh:mm"), arg0.getThrowable().getMessage());
        suiteResult.add(temp);
         ScreenshotUtils.getScreenshot(DriverWrapper.getDriver(), arg0.getMethod().getMethodName());
         //printTestResults(arg0);
     }
 
    // This belongs to ITestListener and will execute before the main test start (@Test)
 
    public void onTestStart(ITestResult arg0) {
      //Log.log(String.valueOf(arg0.getStartMillis()));
       // System.out.println("The execution of the main test starts now");
 
    }
 
    // This belongs to ITestListener and will execute only if any of the main test(@Test) get skipped
 
    public void onTestSkipped(ITestResult arg0) {
        
      //  printTestResults(arg0);
 
    }
 
    // This is just a piece of shit, ignore this
 
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
 
    }
 
    // This is the method which will be executed in case of test pass or fail

    // This belongs to IInvokedMethodListener and will execute before every method including @Before @After @Test
 
    public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {
        String testName = returnMethodName(arg0.getTestMethod());
        Log.setName(testName);
// 
//        String textMsg = "About to begin executing following method : " + returnMethodName(arg0.getTestMethod());
// 
//        Reporter.log(textMsg, true);
 
    }
 
    // This belongs to IInvokedMethodListener and will execute after every method including @Before @After @Test
 
    public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {
 
        
//        String textMsg = "Completed executing following method : " + returnMethodName(arg0.getTestMethod());
// 
//        Reporter.log(textMsg, true);
 
    }
 
    // This will return method names to the calling function
 
    private String returnMethodName(ITestNGMethod method) {
 
        return method.getRealClass().getSimpleName() + "." + method.getMethodName();
 
    }
}