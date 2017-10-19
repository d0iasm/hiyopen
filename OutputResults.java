import java.util.Scanner ;

public class OutputResults {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in) ;
		
		// このままではコンパイルエラーが出るので
		// 【要追加】とある行に必要なコードを追加すること
		
		// 入力その1
		System.out.print("int型の整数a= ") ;
		int a = stdIn.nextInt(); // 【要追加】実行時にキーボードより整数を入力できるようにする
		System.out.print("int型の整数b= ") ;
		int b = stdIn.nextInt(); // 【要追加】実行時にキーボードより整数を入力できるようにする
		
		// インクリメントとデクリメント
		a++ ;
		System.out.println("(1) a="+a) ;
		a-- ;
		System.out.println("(2) a="+a) ;
		++a ;
		System.out.println("(3) a="+a) ;
		--a ;
		System.out.println("(4) a="+a) ;
		System.out.println("(5) a++="+(a++)) ;
		System.out.println("(6) a="+a) ;
		System.out.println("(7) ++a="+(++a)) ;
		System.out.println("(8) a="+a) ;
		
		// 代入
		a += b ;
		System.out.println("(9) a="+a) ;
		a -= b ;
		System.out.println("(10) a="+a) ;
		a *= b ;
		System.out.println("(11) a="+a) ;
		a /= b ;
		System.out.println("(12) a="+a) ;
		a %= b ;
		System.out.println("(13) a="+a) ;

		// 型による違い
		a = 31 ;
		b = 7 ;
		int c = a / b ;
		float d = (float)a / b ;
		System.out.println("(14) c="+c+", d="+d) ;
		
		// 比較演算の結果
		boolean p = a > a ;
		boolean q = a >= a ;
		System.out.println("(15) p="+p+", q="+q) ;
		p = a < b ;
		q = a > b ;
		System.out.println("(16) p="+p+", q="+q) ;
		p = a == b ;
		q = a != b ;
		System.out.println("(17) p="+p+", q="+q) ;

		// 浮動小数点型の入出力
		System.out.print("float型の実数x=") ;
		float x = stdIn.nextFloat(); // 【要追加】実行時にキーボードよりfloat型の実数を入力できるようにする
		System.out.print("double型の実数y=") ;
		double y = stdIn.nextDouble(); // 【要追加】実行時にキーボードよりdouble型の実数を入力できるようにする
		System.out.println("(18) x="+x) ;
		System.out.println("(19) y="+y) ;
		
		// 文字列の入力
		System.out.print("あなたの苗字は？") ;
		String str1 = stdIn.next(); // 【要追加】実行時にキーボードより文字列を入力できるようにする
		System.out.print("あなたの名前は？") ;
		String str2 = stdIn.next(); // 【要追加】実行時にキーボードより文字列を入力できるようにする
		System.out.println("(20) "+str2+" "+str1) ;
		
		// 文字列の比較
		String s1 = new String("abcdefg") ; // 単にString s1 = "abcdefg" ; でもOK
		String s2 = new String("abcdefg") ; // 単にString s2 = "abcdefg" ; でもOK
		p = s1 == s2 ;
		q = s1 != s2 ;
		System.out.println("(21) p="+p+", q="+q) ;
		p = s1.equals(s2) ;
		q = "abc".equals(s1) ;
		System.out.println("(22) p="+p+", q="+q) ;
	}
}
