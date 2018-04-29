package testNg;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class C1 {

    @BeforeSuite
    public void load1(){
        System.out.println("C1 suite");
    }

    @BeforeTest
    public void load(){
        System.out.println("C1 Before");
    }
    @Test
    public void test1(){
        System.out.println("T1");
    }
    @Test
    public void test2(){
        System.out.println("T2");
    }
    @Test
    public void test3(){
        System.out.println("T3");
    }
}
