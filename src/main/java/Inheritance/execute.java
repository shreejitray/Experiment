package Inheritance;
import Inheritance.base;
/**
 * Created by schaud3 on 12/16/16.
 */
public class execute {
    public static void main(String[] args) {
        base b1 = new child("12","13","14");
        base b2 = new base("12","13");
        print(b1);
        print(b2);
    }
    public static void print (base b){
        System.out.println(b);
    }
}

