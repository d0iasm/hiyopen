import java.util.Scanner;

public class CopyArrayR{
	public static void main(String[] args){
		Scanner stdIn = new Scanner(System.in);
		
		int n = 0; //要素数
		
		System.out.print("要素数: ");
		n = stdIn.nextInt();
		
		int [] x = new int[n];
		int [] y = new int[n];
		
		for(int i=0; i<n; i++){
			System.out.print("x[" + i + "] = ");
			x[i] = stdIn.nextInt();
		}
		
		System.out.println("コピー完了！");
		
		for(int i=0; i<n; i++){
			y[i] = x[n-1-i];
			System.out.println("y[" + i + "] = " + y[i]);
		}
		
		int p = 0;
		for(int i=0; i<n; i++){
			p += x[i] * y[i];
		}
		
		System.out.println("p = " + p);
	}
}