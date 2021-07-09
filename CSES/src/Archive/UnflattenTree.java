package Archive;

import java.util.Collections;
import java.util.List;

public class UnflattenTree {

    public  Node unflattenTree(List<Node> nodes) {
        // your code here

        Node root = new Node("/");
        Node rootPointer = root;

        Collections.sort(nodes); //parent level nodes first

        for(Node node: nodes){
            StringBuilder subPath = new StringBuilder();
            if(node.getPath() != null){
                String[] paths = node.getPath().split("/");
                for(int i = 0;i< paths.length; i++ ) {
                    String path = paths[i];
                    if (!path.equals("")) {
                        subPath.append("/" + path);
                        Node child = root.findChildByPath(subPath.toString());
                        if (child == null) {
                            if(i == paths.length-1){
                                root.addChild(node);
                                root = node;
                            }
                            else{
                                Node newNode = new Node(subPath.toString());
                                root.addChild(newNode);
                                root = newNode;
                            }

                        } else {
                            root = child;
                        }
                    }
                }
            }
           root = rootPointer;
        }

        return rootPointer;
    }


}
