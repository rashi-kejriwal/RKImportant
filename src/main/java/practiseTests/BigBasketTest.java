package practiseTests;

import com.jayway.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import static com.jayway.restassured.RestAssured.when;

public class BigBasketTest {

    @Test(dataProvider = "cities")
    public void getFilters(String cityId){
        Response response=  when().get("https://www.bigbasket.com/auth/get_footer/?city_id="+cityId).then().assertThat().statusCode(200).extract().response();
        String json=response.asString();

   }

    @DataProvider(name = "cities")
    public Object[][] cities(){
        return new Object[][] {{"1"},{"4"}};
    }

}
