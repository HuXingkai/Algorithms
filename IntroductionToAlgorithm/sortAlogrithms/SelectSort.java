package IntroductionToAlgorithm.sortAlogrithms;

public class SelectSort {
	public static int key;
	public static int[] sort(int...args){
		for (int j = 0; j < args.length-1; j++){
			key=args[j];
			for (int j2 = j+1; j2 < args.length; j2++) {
				if (args[j2]<key) {
					int box=key;
					key=args[j2];
					args[j2]=box;
				}
			}
			args[j]=key;
		}
		return args;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] answer=SelectSort.sort(7,5,4,6,9,8,1,2,3);
		for (int i : answer) {
			System.out.print(i);
		}
	}

}
