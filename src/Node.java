public class Node implements Comparable<Node>{
    private Node parent;
    private int[][] mat;

    public Node(Node parent,int[][] mat) {
        this.parent = parent;
        this.mat= mat;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getParent() {
        return parent;
    }

    public void setMat(int[][] mat) {
        this.mat = mat;
    }

    public int[][] getMat() {
        return mat;
    }

    @Override
    public int compareTo(Node o) {
        return 0;
    }
}