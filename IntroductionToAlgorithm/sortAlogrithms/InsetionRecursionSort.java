package IntroductionToAlgorithm.sortAlogrithms;

public class InsetionRecursionSort {
	public int[] insertion(int p, int r,int...A){
		int key=A[r];
		int i=0;
		for (i = r-1; i>=p; i--) {
			if (A[i]>key) {
				A[i+1]=A[i];
			}
			else {
				break;
			}
		}
		A[i+1]=key;
		return A;	
	}
	
	public int[] recursionInsertionSort(int p, int r,int...A){
		if (p<r) {
			r=r-1;
			recursionInsertionSort(p, r, A);
			insertion(p, r, A);
		}
		return A;
		
	}
	public static void main(String[] args) {
		InsetionRecursionSort insertionSort= new InsetionRecursionSort();
		int[] A1={7,5,4,6,9,8,1,2,3,0,12};
		int l=A1.length;
		int[] answer=insertionSort.recursionInsertionSort(0, l, A1);
		for (int i : answer) {
			System.out.print(i+",");
		}
	}

}
