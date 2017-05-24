package Inheritance;

/**
 * Created by schaud3 on 12/16/16.
 */
public class child extends base {
    private String c;
    public child(String a, String b, String c){
        super(a,b);
        this.c = c;
    }
    public String toString(){
        return "Inside child"+getA()+" "+getB()+" "+c;
    }
}
