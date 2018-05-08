package Factory;

/**
 * Created by schaud3 on 1/16/18.
 */
public class Dummy extends Parent {

    private Dummy(){}
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void print(){
        System.out.println("inside dummy");
    }
}
