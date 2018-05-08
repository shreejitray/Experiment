import org.apache.cxf.aegis.type.xml.SourceType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

@ContextConfiguration(locations = "classpath:/context.xml")
public class sampleTests extends AbstractTestNGSpringContextTests {
    @Test(groups = {"b"},dependsOnGroups = {"a"})
    public void test1(){
        System.out.println("running test 1");
    }

    @Test(groups = {"a"})
    public void test2(){
        System.out.println("running test 2");
    }

    @Test(dependsOnMethods = {"test2"},groups = {"c"})
    public void cleanup(){
        System.out.println("cleaning up");
    }

    @Test(groups = {"c"})
    public void textC() {
        System.out.println("test 3");
    }

    @Test(groups={"d"})
    public void threadTest() throws InterruptedException {
        for(int i=0;i<10;i++) {
            Runnable runner = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep((long)(Math.random() * 1000));
                    } catch (Exception e) {
                        System.out.println("Error in "+Thread.currentThread().getId());
                    }
                    Long id = Thread.currentThread().getId();
                    System.out.println("Currently running thread " + id);
                    Assert.assertEquals(true,false);
                }

            };
            Thread thread = new Thread(runner);
            thread.start();
            thread.join();
        }
    }
}
