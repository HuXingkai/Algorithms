package IntroductionToAlgorithm.sortAlogrithms;

public class InsertionSort {
	public int key;
	public int[] sort(int...args){
		for (int j = 1; j < args.length; j++){
			int i=j-1;
			key=args[j];
			//key>args[i]Ϊ�������У�����Ϊ��������
			while (i>=0&&key>args[i]) {
				args[i+1]=args[i];
				i=i-1;
			}
			args[i+1]=key;
		}
		return args;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InsertionSort insert=new InsertionSort();
		int[] answer=insert.sort(7,5,4,6,9,8,1,2,3);
		for (int i : answer) {
			System.out.print(i);
		}
		
	}

}
