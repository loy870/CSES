import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    };
}
public class ReverseOrderTraversal {
    public static List<List<Integer>> traverse(TreeNode root){
        LinkedList<List<Integer>> result = new LinkedList<>();

        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        nodeQueue.add(root);

        while(!nodeQueue.isEmpty()){
            List<Integer> level = new ArrayList<Integer>();
            int levelSize = nodeQueue.size();
            for(int i = 0; i<levelSize; i++) {
                TreeNode node = nodeQueue.poll();
                level.add(node.val);
                if (node.left != null)
                    nodeQueue.add(node.left);
                if (node.right != null)
                    nodeQueue.add(node.right);
            }
            result.addFirst(level);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<List<Integer>> result = ReverseOrderTraversal.traverse(root);
        System.out.println(result);
    }
}
