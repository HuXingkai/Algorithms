package IntroductionToAlgorithm.findMaxSubArray;
public class ConquerSubArray {
	public SubArray findMaxCrossingSubarray(int low,int mid, int high,long...A){
		long leftSum=-1000000000L;
		long sum=0;
		int maxLeft=0,maxRight=0;
		for (int i = mid; i>=low; i--) {
			sum+=A[i];
			if (sum>leftSum) {
				leftSum=sum;
				maxLeft=i;
			}
		}
		long righttSum=-1000000000L;
		long sum1=0;
		for (int i = mid+1; i<=high; i++) {
			sum1+=A[i];
			if (sum1>righttSum) {
				righttSum=sum1;
				maxRight=i;
			}
		}
		SubArray subArray=new SubArray();
		subArray.setLow(maxLeft);
		subArray.setHigh(maxRight);
		subArray.setSum(leftSum+righttSum);
		return subArray;
	}
	
	public SubArray findMaxSubArray(int low,int high,long...A){
		if (low==high) {
			SubArray array=new SubArray();
			array.setLow(low);
			array.setHigh(high);
			array.setSum(A[low]);
			return array;
		}
		else{
			int mid=(low+high)/2;
			SubArray ArrayLeft=findMaxSubArray(low, mid, A);
			SubArray ArrayRight=findMaxSubArray(mid+1, high, A);
			SubArray ArrayCross=findMaxCrossingSubarray(low, mid, high, A);
			if ((ArrayLeft.getSum()>ArrayRight.getSum())&&(ArrayLeft.getSum()>ArrayCross.getSum())) {
				return ArrayLeft;
			}
			else if((ArrayRight.getSum()>ArrayLeft.getSum())&&(ArrayRight.getSum()>ArrayCross.getSum())){
				return ArrayRight;
			}
			else return ArrayCross;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long[] A={13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
		SubArray a=new ConquerSubArray().findMaxSubArray(0, A.length-1, A);
		System.out.println(""+a.getLow()+"-"+a.getHigh()+"="+a.getSum());
	}
}
