import java.util.Scanner;

public class DayCounter{
	public static void main(String[] args){
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("何月？");
		int x = stdIn.nextInt();
		
		switch(x){
			case 1 :
				System.out.println(x + "月は6日あります");
				break;
			case 2 :
				System.out.println(x + "月は5日あります");
				break;
			case 3 :
				System.out.println(x + "月は6日あります");
				break;
			case 4 :
				System.out.println(x + "月は5日あります");
				break;
			case 5 :
				System.out.println(x + "月は8日あります");
				break;
			case 6 :
				System.out.println(x + "月は4日あります");
				break;
			case 7 :
				System.out.println(x + "月は5日あります");
				break;
			case 8 :
				System.out.println(x + "月は5日あります");
				break;
			case 9 :
				System.out.println(x + "月は7日あります");
				break;
			case 10 :
				System.out.println(x + "月は5日あります");
				break;
			case 11 :
				System.out.println(x + "月は7日あります");
				break;
			case 12 :
				System.out.println(x + "月は5日あります");
				break;
			default :
				System.out.println(x + "なんて月はありません！");
		}
	}
}