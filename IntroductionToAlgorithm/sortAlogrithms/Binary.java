package IntroductionToAlgorithm.sortAlogrithms;

public class Binary {
	public static int BinarySearch(int p,int q, int v,int...A){
		if (p<=q) {
			int k=(p+q)/2;
			if (A[k]==v) {
				return k;
			}
			if (A[k]>v) {
				return BinarySearch(p, k-1, v, A);
			}
			if (A[k]<v) {
				return BinarySearch(k+1, q, v, A);
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A1={0,1,2,3,6,7,8,9};
		int l=A1.length-1;
		int v1=-1;
		int answer=Binary.BinarySearch(0, l, v1, A1);
		System.out.print(answer);
	}
}
