import java.util.Scanner;

public class NumCount{
	public static void main(String[] args){
		Scanner stdIn = new Scanner(System.in);
		
		int n = 1; //入力回数
		int x; //キーボードから入力された整数
		int neg_num = 0; //負の整数の個数
		int sum = 0; //絶対値の合計
		double ave; //絶対値の平均
		
		do{
			System.out.print("Input data " + n + " => ");
			x = stdIn.nextInt();
			n++;
			sum += x;
			
			if(x<0){
				neg_num++;
			}
			
		}while(x!=0);
		
		ave = sum/n;
		System.out.println("Negative number : " + neg_num);
		System.out.println("Average : " + ave);
		
	}
}
