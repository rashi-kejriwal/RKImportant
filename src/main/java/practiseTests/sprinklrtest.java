package practiseTests;

import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.specification.RequestSpecification;
import org.apache.http.client.methods.RequestBuilder;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class sprinklrtest<T> {

    public static void main(String args[]){
        Object[] arr ={"aaa",2,3};
        sprinklrtest s=new sprinklrtest();
        s.print(arr);

    }
    public void print(Object[] arr){
        for(Object t:arr){
            System.out.println(t);
        }
    }
}
