import java.util.Scanner;

public class StatCalc{
	public static void main(String[]args){
		Scanner stdIn = new Scanner(System.in);
		double a,b,c,d,e;
		System.out.print("実数を５個入力して下さい。");
		a = stdIn.nextDouble();
		b = stdIn.nextDouble();
		c = stdIn.nextDouble();
		d = stdIn.nextDouble();
		e = stdIn.nextDouble();
		
		double ave = a+b+c+d+e;
		ave = ave/5;
		
		double v;
		v = ((a-ave)*(a-ave) + (b-ave)*(b-ave) + (c-ave)*(c-ave) + (d-ave)*(d-ave) + (e-ave)*(e-ave))/5.0;
		
		System.out.println("平均は"+ave);
		System.out.println("分散は"+v);
		System.out.println("です。");
	}
}