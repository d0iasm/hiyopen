import java.util.Scanner;

public class IntegerCalc{
	public static void main(String[]args){
		Scanner stdIn = new Scanner(System.in);
		int x,y,z;
		System.out.print("最初の整数Xを入力して下さい。=>");
		x = stdIn.nextInt();
		System.out.print("次の整数Yを入力して下さい。=>");
		y = stdIn.nextInt();
		
		System.out.println("和:"+x+"+"+y+"="+(x+y));
		System.out.println("差:"+x+"-"+y+"="+(x-y));
		System.out.println("積:"+x+"*"+y+"="+x*y);
		System.out.println("商:"+x+"/"+y+"="+x/y);
		System.out.println("余:"+x+"%"+y+"="+(x%y));
		System.out.println("です。");
	}
}