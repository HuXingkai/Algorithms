package IntroductionToAlgorithm.findMaxSubArray;
/*������Ҫ������������ʵ�����һ������a[p..r]��͵õ���ֵ����ô����a[p..r+1]�����������϶�������a[p..r+1]����Ϊa[p..r]+a[r+1]<a[r+1].
�����ϳ����У�������sum�洢��ν��a[p..r]��ֻҪa[p..r]������Ǹ�ֵ����ô����һ��a[r+1]ֵ��ʼ��sum���´��㿪ʼ��ͣ�ֻҪsum > MaxSum,
�͸���MaxSum,����������һ�α����󣬾��ܵõ�����MaxSum*/
public class LinerSubArray {
	public SubArray Linerfind(long...A){
		long sum=0L;
		long MaxSum=0L;
		int low=0,high=0;
		for (int i = 0; i < A.length-1; i++) {
			sum+=A[i];
			if (sum>MaxSum) {
				MaxSum=sum;
				high=i;
			}
			if (sum<0) {
				sum=0L;
				low=i+1;
			}
		}
		SubArray array=new SubArray();
		array.setLow(low);
		array.setHigh(high);
		array.setSum(MaxSum);
		return array;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long[] A={-1,2,1};
		SubArray a=new LinerSubArray().Linerfind(A);
		System.out.println(a.getLow()+"-"+a.getHigh()+"|"+a.getSum());
	}

}
