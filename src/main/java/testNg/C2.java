package testNg;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class C2 {

    @BeforeSuite
    public void load1(){
        System.out.println("C2 suite");
    }

    @BeforeTest
    public void load(){
        System.out.println("C2 Before");
    }
    @Test
    public void test4(){
        System.out.println("T4");
    }
    @Test
    public void test5(){
        System.out.println("T5");
    }
    @Test
    public void test6(){
        System.out.println("T6");
    }
}
