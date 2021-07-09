package Archive;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.searchRange(new int[]{1}, 1)[0]);
    }
    public int[] searchRange(int[] nums, int target) {
        int left = leftMostBinarySearch(nums, target);
        int right = leftMostBinarySearch(nums, target+1) - 1;

        if(left <= right)
            return new int[]{left, right};
        else
            return new int[]{-1, -1};
    }

    private int leftMostBinarySearch(int[] arr, int target){
        int l = 0;
        int r = arr.length-1;
        int result = arr.length;
        while(l<=r){
            int mid = l+((r-l)/2);
            if(arr[mid] >= target){
                result = mid;
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return result;
    }
}