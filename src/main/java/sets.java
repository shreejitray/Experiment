import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by schaud3 on 8/31/17.
 */
public class sets {
    public static void main(String[] args) {
        Set<Long> example =  new HashSet<Long>(Arrays.asList(1L, 2L,null));
        Long test = null;
        System.out.println(example.contains(test));
    }
}
