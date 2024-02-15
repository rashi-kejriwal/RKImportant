package testNg;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

@Listeners(testNgListner.class)
public class TestAnnotations {

    @BeforeTest
    public void setup(){

    }

    @Test(groups = {"smoke","regression"}, priority = 1,dataProvider = "Authentication")
    public void test1(String usr,String pwd){

    }

    @Test(dependsOnMethods = {"test1"}, priority = 2, dataProviderClass = commonDataProviderClass.class, dataProvider = "Auth")
    public void test2(String usr,String pwd){

        //In selenium there are two types of logging. High level logging and Low level logging.
        // In low level logging you try to produce logs for the every step you take or every action you make in your automation script.
        // In high  level logging you just try to capture main events of your test.

        Assert.assertTrue(1==2);
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertAll();
    }

    //to skip test
    @Test(enabled = false, description = "Appears in html report")
    public void test3(){

    }

    @Test(dependsOnGroups = {"g1,g2"})
    public void test4(){
/**
 * The list of groups this method depends on.  Every method
 * member of one of these groups is guaranteed to have been
 * invoked before this method.  Furthermore, if any of these
 * methods was not a SUCCESS, this test method will not be
 * run and will be flagged as a SKIP.
 */
    }

    @Test(timeOut = 5000, invocationCount = 2, threadPoolSize = 10)
    public void test5(){
        //no of times this method should be called
        //time to complete in millisec, if greated it fails
    }

    @Parameters({ "sUsername", "sPassword" })
    @Test(sequential = true, singleThreaded = true)
    public void test4(@Optional("rk") String sUsername, @Optional("1235")String sPassword) {

    }


    @DataProvider(name = "Authentication")
    public static Object[][] credentials() {

        return new Object[][] { { "testuser_1", "Test@123" }, { "testuser_1", "Test@123" }};

    }
}
