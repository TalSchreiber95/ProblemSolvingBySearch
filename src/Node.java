public class Node implements Comparable<Node>{
    private Node parent;
    private int depth;
    private char letter;

    public Node(int x, int y, Node parent,char letter) {
        this.parent = parent;
        this.letter=letter;
    }

    @Override
    public int compareTo(Node o) {
        return 0;
    }
}