package aibank;

/**
 * Created by andy on 2018/11/14.
 */
public class BianrySearch {
    public static int find(int [] arr, int left,int right, int key){
        if (left>right) return -1;
        int mid = (left + right) / 2;
        if (key == arr[mid]) {
            return mid;
        }
        if (key>arr[mid]){
            return find(arr, mid + 1, right, key);
        }
        if (key<arr[mid]){
            return find(arr, left, mid-1, key);
        }
        return -1;
    }
    public static void main(String [] args){
        int [] arr={1,2,3,4,5,6};
        int ans = find(arr, 0, arr.length - 1, 8);
        System.out.println(ans);
    }
}
