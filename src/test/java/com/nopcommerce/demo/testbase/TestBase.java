package com.nopcommerce.demo.testbase;

import com.nopcommerce.demo.propertyreader.PropertyReader;
import com.nopcommerce.demo.utility.Utility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Created by Bhavesh
 */
public class TestBase extends Utility {

    String browser = PropertyReader.getInstance().getProperty("browser");

    @BeforeMethod
    public void setUp(){
        selectBrowser(browser);
    }

    @AfterMethod
    public void tearDown(){
       // closeBrowser();
    }

}
