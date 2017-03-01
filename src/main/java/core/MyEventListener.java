package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;



public class MyEventListener extends AbstractWebDriverEventListener {

    @Override
    public void afterClickOn(WebElement arg0, WebDriver arg1) {
        // TODO Auto-generated method stub      
    }
    @Override
    public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
        // TODO Auto-generated method stub      
    }
    @Override
    public void afterNavigateBack(WebDriver driver) {
        //System.out.println("After clicking back  "+ driver.getCurrentUrl());        
    }
    @Override
    public void afterNavigateForward(WebDriver arg0) {
        // TODO Auto-generated method stub      
    }
    @Override
    public void afterNavigateTo(String arg0, WebDriver arg1) {
        // TODO Auto-generated method stub      
    }
    @Override
    public void afterScript(String arg0, WebDriver arg1) {
       
        // TODO Auto-generated method stub      
    }

    @Override
    public void beforeClickOn(WebElement arg0, WebDriver arg1) {
        // TODO Auto-generated method stub      
    }
    @Override
    public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
        // TODO Auto-generated method stub      
    }
    @Override
    public void beforeNavigateBack(WebDriver driver) {
        //System.out.println("Before clicking Back"+driver.getCurrentUrl());      
    }
    @Override
    public void beforeNavigateForward(WebDriver arg0) {
        // TODO Auto-generated method stub      
    }
    @Override
    public void beforeNavigateTo(String arg0, WebDriver arg1) {
        // TODO Auto-generated method stub      
    }
    @Override
    public void beforeScript(String arg0, WebDriver arg1) {
        // TODO Auto-generated method stub      
    }
    @Override
    public void onException(Throwable arg0, WebDriver arg1) {
        // TODO Auto-generated method stub      
//        ScreenshotUtils.getScreenshot(arg1, );
//        File scrFile = ((TakesScreenshot)arg1).getScreenshotAs(OutputType.FILE);
//     // Now you can do whatever you need to do with it, for example copy somewhere
//        String screenName = StringGenerateUtils.getRandomStringStartsWith("Screenshot", 5);
//        try {
//            FileUtils.copyFile(scrFile, new File("..\\tmp\\"+screenName));
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
    }
}
