public class Mark1 extends Thread{
    private String name;
    private Line line;

    Mark1(String name, Line line){
        this.name=name;
        this.line = line;
    }

    @Override
    public void run() {
        System.out.println("Starting"+this.name);
        line.getLine(this.name);
    }

    public static void main(String[] args) {
        Line line = new Line();
        for(int i=0;i<5;i++){
            Mark1 mark1 = new Mark1("Thread: "+i,line);
            mark1.start();
        }
    }
}
