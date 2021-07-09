package Archive;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelAverageBinaryTree {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();

        List<List<Integer>> data = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();

            for(int i =0;i< levelSize; i++){
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }

            data.add(level);
        }
        for(List<Integer> list: data){
            double sum = 0;
           for(int e: list){
               sum+=e;
           }
           result.add(sum/list.size());

        }

        return result;
    }
}
