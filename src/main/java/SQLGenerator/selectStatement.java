package SQLGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by schaud3 on 8/7/17.
 */
public class selectStatement {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("/Users/schaud3/Documents/personal/Experiments/src/main/java/SQLGenerator/IAMMapping"));
        System.out.print("select * from iam_principal where realm_id in (");
        boolean first = true;
        while(in.hasNext()) {
            String entry[] = in.nextLine().split(",");
            if(entry[1].matches("^.{8}-.{4}-.{4}-.{4}-.{12}$")) {
                if(!first) {
                    System.out.print(",");
                }
                first = false;
                System.out.print("'"+entry[1]+"'");
            }
        }
        System.out.println(")");
    }
}
