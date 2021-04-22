import java.util.HashMap;

public class algorithms {

    protected String path;
    protected int cost;
    protected char[][] mat;
    protected Node start;
    protected Node finish;

    public algorithms(Node start,Node finish) {
        this.start=start;
        this.finish=finish;
    }

    static String getState(Node state , HashMap<String, Node> closedList,int numberOfEmpty){
        if(numberOfEmpty==1){
            String a = null;
        }
        return null;
    }
}
