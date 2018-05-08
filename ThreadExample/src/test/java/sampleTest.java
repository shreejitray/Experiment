import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@ContextConfiguration(locations = {"classpath:/context.xml"})
public class sampleTest extends AbstractTestNGSpringContextTests {

@Test
    public void test1(){
    System.out.println("running test 1");
}

@Test
    public void test2(){
    System.out.println("running test 2");
}
}
