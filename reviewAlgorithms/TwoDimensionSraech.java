package reviewAlgorithms;

/**
 * Created by andy on 2018/7/29.
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 */
public class TwoDimensionSraech {
    public boolean Find(int target, int [][] array) {
        int len=array.length;
        for(int i=0;i<len;i++){
            if(binarySearch(target,0,array[i].length-1,array[i])!=-1){
                return true;
            }
        }
        return false;
    }
    public int binarySearch(int target, int p, int r, int [] array1){
        if(p<=r){
            int q=(p+r)/2;
            if(array1[q]==target){
                return q+1;
            }
            else if(array1[q]>target) {
                return binarySearch(target,p,q,array1);
            }
            else{
                return binarySearch(target,q+1,r,array1);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {2,3,4},
                {4,5,6},
                {7,8,9},
                {7,8,9}
        };
        System.out.println(new TwoDimensionSraech().Find(1,arr));
    }
}
