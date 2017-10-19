import java.util.Scanner;

public class StringCompare{
	public static void main(String[] args){
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("1個目");
		String x =stdIn.next();
		System.out.print("2個目");
		String y =stdIn.next();
		System.out.print("3個目");
		String z =stdIn.next();
		
		if(x.equals(y)){
			if(x.equals(z)){
				System.out.println("3個すべて同じ文字列です。");
			}else{
				System.out.println("2個が同じ文字列です。");
			}
		}else{
			if(x.equals(z) || y.equals(z)){
				System.out.println("2個が同じ文字列です。");
			}else{
				System.out.println("すべて異なる文字列です。");
			}
		}
	}
}
