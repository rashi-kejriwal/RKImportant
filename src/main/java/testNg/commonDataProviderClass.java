package testNg;

import org.testng.annotations.DataProvider;

public class commonDataProviderClass {
    @DataProvider(name = "Auth")

    public static Object[][] credentials() {

        return new Object[][] { { "testuser_1", "Test@123" }, { "testuser_1", "Test@123" }};

    }
}
