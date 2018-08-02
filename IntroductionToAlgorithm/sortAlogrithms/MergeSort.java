package IntroductionToAlgorithm.sortAlogrithms;

public class MergeSort {
	public int[] merge(int p,int q,int r,int...A){
		int n1=q-p+1;
		int n2=r-q;
		int[] L=new int[n1+1];
		int[] R=new int[n2+1];
		for (int j = 0; j< n1; j++) {
			L[j]=A[p+j];
		}
		for (int i = 0; i < n2; i++) {
			R[i]=A[q+i+1];
		}
		
		R[n2]=999999999;
		L[n1]=999999999;
		int i=0,j=0;
		for (int k = p; k <r+1; k++) {
			if (L[j]<R[i]) {
				A[k]=L[j];
				j=j+1;
			} else {
				A[k]=R[i];
				i=i+1;
			}
		}
		return A;
	}
	public int[] mergeSort(int begin,int end,int...B){
		if (begin<end) {
			int q=(begin+end)/2;
			mergeSort(begin,q,B);
			mergeSort(q+1, end, B);
			merge(begin, q, end, B);
		}
		return B;
	}
	public static void main(String[] args) {
		MergeSort merge=new MergeSort();
		int[] A1={7,5,4,6,9,8,1,2,3};
		int l=A1.length-1;
		int[] answer=merge.mergeSort(0, l, A1);
		for (int i : answer) {
			System.out.print(i);
		}
	}
	

}
