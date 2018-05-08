package AsyncExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by schaud3 on 1/15/18.
 */
public class MainRun {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(12);
        List<Callable<String>> execs = new ArrayList<>();
         for (int i=0;i<11;i++) {
             execs.add(()->{
                return (Thread.currentThread().getName());
             });
         }
        try {
            List<Future<String>> futures = exec.invokeAll(execs);
            int count = 1;
            for(Future<String> future: futures) {
                try {
                    System.out.println("Case number "+count+" "+future.get());
                    count++;

                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
            exec.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
