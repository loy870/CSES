package Archive;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MinimumDistanceBetweenNodes {

    public int minDiffInBST(TreeNode root) {
        Set<Integer> diffSet = new HashSet<>();
        if (root == null) {
            return 0;
        }

        dfs(diffSet, root);
        List<Integer> list = diffSet.stream().distinct().sorted().collect(Collectors.toList());
        int result = list.get(list.size()-1) - list.get(0);
        for(int i = 0; i <list.size()-1; i++){
            if(list.get(i+1) - list.get(i) < result)
                result = list.get(i+1) - list.get(i);
        }
        return result;
    }

    private void dfs(Set<Integer> diffSet, TreeNode root) {
        if(root != null){
            diffSet.add(root.val);
            dfs(diffSet, root.left);
            dfs(diffSet, root.right);
        }

    }
}
