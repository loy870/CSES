public class SquareRoot {

    public int mySqrt(int x) {

        if(x ==0)
            return 0;
        if(x==1)
            return 1;

        int[] arr = new int[x];
        for(int i=1;i<x;i++){
            arr[i] = i;
        }

        int left = 0;
        int right = x-1;
        int result = 0;
        while(left <= right){
            int mid = left + ((right - left)/2);
            if(arr[mid] * arr[mid] == x)
                return arr[mid];
            else if(arr[mid] * arr[mid] < x){
                left = mid+1;
            }
            else {
                right = mid-1;
            }
            result = arr[mid];
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(new SquareRoot().mySqrt(8));
    }
}
