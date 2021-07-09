package Archive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public  class Node implements Comparable<Node>{

    private String id = null;
    private String path;
    private List<Node> children = new ArrayList<>();

    public Node(String path) {
        this.path = path;
    }

    public Node(String id, String path) {
        this(path);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getPath() {
        return path;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public void addChild(Node child) {
        this.children.add(child);
    }

    public void sort() {
        Collections.sort(this.children);
        for (Node c: this.children) {
            c.sort();
        }
    }

    public Node findChildByPath(String path) {
        for (Node child: this.children) {
            if (path.equals(child.getPath())) {
                return child;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "{" +
                (id == null || id == "" ? "" : "id='" + id + "\', ") +
                "path='" + path + '\'' +
                ", children=" + children +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return path.compareTo(o.getPath());
    }

}