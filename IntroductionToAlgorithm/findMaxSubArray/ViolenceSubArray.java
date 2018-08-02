package IntroductionToAlgorithm.findMaxSubArray;

public class ViolenceSubArray {

	public SubArray getSubarrayByViolent(long...A){
		long MaxProfit=-1000000L;
		int Buydate=0,Selldate=0;
		for (int i = 0; i < A.length-2; i++) {
			for (int j = i+1; j < A.length-1; j++) {
				long RealProfit=A[j]-A[i];
				if (RealProfit>MaxProfit) {
					MaxProfit=RealProfit;
					Buydate=i;
					Selldate=j;
				}
			}
		}
		SubArray array=new SubArray();
		array.setLow(Buydate);
		array.setHigh(Selldate);
		array.setSum(MaxProfit);
		return array;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long []A={100,113,110,85,105,102,86,63,81,101,94,106,101,79,94,90,97};
		SubArray a=new ViolenceSubArray().getSubarrayByViolent(A);
		System.out.println(""+a.getLow()+"-"+a.getHigh()+":"+a.getSum());
	}

}
