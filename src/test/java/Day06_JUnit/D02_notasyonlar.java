package Day06_JUnit;

import org.junit.*;

public class D02_notasyonlar {

    @BeforeClass
    public static void setupClass(){

        System.out.println("Before Class Calisti");

    }

    @AfterClass
    public static void tearDownClass (){
        System.out.println("After Class Calisti");

    }

    @Before
    public void setupMethod(){
        System.out.println("Before Calisti");
    }

    @After
    public void afterMethod(){
        System.out.println("After Calisti");

    }

    @Test
    public void test1(){
        System.out.println("Test1 Calisti");
    }

    @Test @Ignore
    public void test2(){
        System.out.println("Test2 Calisti");
    }

    @Test
    public void test3(){
        System.out.println("Test3 Calisti");
    }

}
