import java.util.Scanner;

public class GeomSec{
	public static void main(String[] args){
		Scanner stdIn = new Scanner(System.in);
		
		double a; //初項
		double r; //公比
		int n = 2; //入力回数
		double x = 1; //結果
		
		System.out.print("Start value : ");
		a = stdIn.nextDouble();
		System.out.print("Common ratio : ");
		r = stdIn.nextDouble();
		
		System.out.println("A_1 = " + a); //初項のみ最初に表示
		
		x = a;
		
		for(; n<11; n++){
			x = x * r; //等比数列
			
			System.out.println("A_" + n + "=" + x);
		}
	}
}