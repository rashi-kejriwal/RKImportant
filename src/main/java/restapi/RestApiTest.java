package restapi;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Headers;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompare;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.post;
import static com.jayway.restassured.RestAssured.when;
import static com.jayway.restassured.authentication.FormAuthConfig.formAuthConfig;
import static com.jayway.restassured.authentication.FormAuthConfig.springSecurity;
import static com.jayway.restassured.path.json.JsonPath.from;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItems;

public class RestApiTest {

    @Test
    public void testEbdpoints(){

        RestAssured.get("/lotto").then().body("lotto.lottoId", equalTo(5));


        when().
                get("/json").
                then().
                body("$", hasItems(1, 2, 3)); // An empty string "" would work as well


        given().
                parameters("firstName", "John", "lastName", "Doe").
                when().
                post("/greetXML").
                then().assertThat().
                body("greeting.firstName", equalTo("John")).
                body("greeting.lastName", equalTo("Doe"));

            //        find – finds the first item matching a closure predicate
            //        collect – collect the return value of calling a closure on each item in a collection
            //        sum – Sum all the items in the collection
            //        max/min – returns the max/min values of the collection

        when().
                get("/store")
                .then()
                .body("store.book.author.collect { it.length() }.sum()", greaterThan(50));

        given().param("x", "y").and().header("z", "w").when().get("/something").then().assertThat().statusCode(200).and().body("x.y", equalTo("z"));

        String json = RestAssured.get("/lotto").asString(); // to get content

        //extracting values
        String nextTitleLink = given()
                .param("param_name", "param_value")
                .when()
                .get("/title")
                .then()
                .extract()
                .path("_links.next.href");

        Response response1 =
                given().
                        param("param_name", "param_value").
                        when().
                        get("/title").
                        then().
                        contentType(ContentType.JSON).
                        body("title", equalTo("My Title")).
                        extract().
                        response();

        int lottoId = from(json).getInt("lotto.lottoId");
        List<Integer> winnerIds = from(json).get("lotto.winners.winnerId");

        JsonPath jsonPath=new JsonPath(json).setRoot("lotto");
        int lottoId1 = jsonPath.getInt("lottoId");
        List<Integer> winnerIds1 = jsonPath.get("winners.winnderId");

        Response response = RestAssured.get("/lotto");

// Get all headers
        Headers allHeaders = response.getHeaders();
// Get a single header value:
        String headerName = response.getHeader("headerName");

// Get all cookies as simple name-value pairs
        Map<String, String> allCookies = response.getCookies();
        response.getDetailedCookie("cokiename");
// Get a single cookie value:
        String cookieValue = response.getCookie("cookieName");

// Get status line
        String statusLine = response.getStatusLine();
// Get status code
        int statusCode = response.getStatusCode();

//                 when()
//                .request("CONNECT", "/somewhere").
//                then().
//                statusCode(200);

        given().
                param("param1", "value1").
                param("param2", "value2").
                when().
                get("/something");  //In case of GET assumes QUERY PARAM

        given().param("myList", "value1", "value2"); //Multi value

        post("/reserve/{hotelId}/{roomNumber}", "My Hotel", 23); //Unamed Path param

        given().
                pathParam("hotelId", "My Hotel").
                pathParam("roomNumber", 23).
                when().
                post("/reserve/{hotelId}/{roomNumber}"); //namedPath Param

        given().cookie("username", "John").when().get("/cookie").then().body(equalTo("username")); //define cookies

        given().header("headerName", "value1", "value2").contentType("application/json"); //define headers

        when().get("/x").then().assertThat().statusCode(200);
        when().get("/x").then().assertThat().body(equalTo("something"));

        //measuring response time
        long timeInMs = when().get("/lotto").time();
        long timeInSeconds = when().get("/lotto").timeIn(SECONDS);

        //Authentication
        given().auth().basic("username", "password");
        given().auth().preemptive().basic("username", "password"); //sends before unauthorized request


        given().
                auth().form("John", "Doe", formAuthConfig().withAutoDetectionOfCsrf()).
                when().
                get("/formAuth").
        then().
                statusCode(200); //enable CSRF token

        given().
                auth().form("John", "Doe", springSecurity().withCsrfFieldName("_csrf")).
                when().
                get("/formAuth").
        then().
                statusCode(200);


        //Upload File
        given().
                multiPart(new File("/path/to/file")).
                when().
                post("/upload");

        given().
                multiPart("controlName", new File("/path/to/file")).
                when().
                post("/upload"); //controlName - name of input tag

        given().relaxedHTTPSValidation().when().get("https://some_server.com");


        given().proxy("localhost", 8888);//proxy config




        String actualJson = null;
        String expectedJson=null;
        try {
            expectedJson = FileUtils.readFileToString(new File("/expectedFile"));
            actualJson = FileUtils.readFileToString(new File("/actualFile"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            JSONAssert.assertEquals(expectedJson, actualJson, JSONCompareMode.STRICT);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestSpecBuilder builder=new RequestSpecBuilder();
        RequestSpecification requestSpecification;
        builder.setBaseUri("http://www.google.com/");
        builder.setContentType(ContentType.JSON);
        requestSpecification=builder.build();
        given().specification(requestSpecification).when().get().then().assertThat().body("ee.sss",equalTo("Sss"));

        try {
            JSONCompare.compareJSON(expectedJson,actualJson,JSONCompareMode.LENIENT);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
