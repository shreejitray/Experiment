package Inheritance;

/**
 * Created by schaud3 on 12/16/16.
 */
public class base {
    private String a;
    private String b;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public base(String a, String b){
        this.a = a;
        this.b= b;
    }
    public String toString(){
        return "Inside base"+a+" "+b;
    }
}
