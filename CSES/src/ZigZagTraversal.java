import java.util.*;

public class ZigZagTraversal {
    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        nodeQueue.add(root);

        int levelIndex = 0;
        while (!nodeQueue.isEmpty()) {
            levelIndex++;
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

            if (levelIndex % 2 == 0)
                Collections.reverse(level);

            result.add(level);
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
        root.right.left.left = new TreeNode(20);
        root.right.left.right = new TreeNode(17);
        List<List<Integer>> result = ZigZagTraversal.traverse(root);
        System.out.println(result);
    }
}
