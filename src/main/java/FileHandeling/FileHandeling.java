package FileHandeling;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by schaud3 on 9/2/16.
 */
public class FileHandeling {
    public static void main(String[] args) {

        FileHandeling fileHandeling = new FileHandeling();
        ClassLoader classLoader = fileHandeling.getClassLoader();
        URL ur = classLoader.getResource("text");
        DataSource pdfSource = new FileDataSource(classLoader.getResource("text").getFile());
        File file = new File(classLoader.getResource("text").getFile());
        Scanner in = null;
        try {
            in = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(in.next());

    }
    public ClassLoader getClassLoader(){
        ClassLoader classLoader = getClass().getClassLoader();
        return classLoader;
    }
}
