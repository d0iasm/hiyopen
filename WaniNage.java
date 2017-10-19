import java.util.Scanner;

public class WaniNage{
	public static void main(String[] args){
		Scanner stdIn = new Scanner(System.in);
		
		int n; //ワニの数
		int m; //現在の数
		String name; //ワニの名前
		double result; //距離
		double best = 0; //最大距離
		double worst = 0; //最小距離
		String bestname = ""; //最大距離のワニ
		String worstname = ""; //最小距離のワニ
		
		System.out.print("How many ?: ");
		n = stdIn.nextInt();
		
		if (n != 0){
		//n=0以外のときだけ開始
			for(m=1; m<n+1; m++){
				System.out.print("Name: ");
				name = stdIn.next();
				
				System.out.println(m + "/" + n +">^n==n--(-.-) (-.-)--n==n^<");
				
				System.out.print("Result [m]: ");
				result = stdIn.nextDouble();
				
				if(m==1){
					//1回だけは距離がそのまま最大距離、最小距離になる
					best = result;
					bestname = name;
					worst = result;
					worstname = name;
				}
				
				
				if(result > best){
					//最大距離と名前更新
					best = result;
					bestname = name;
				}
				
				if(result < worst){
					//最小距離と名前更新
					worst = result;
					worstname = name;
				}
			}
			System.out.println("Best record! ^ ^v : " + best + "[m] by " + bestname);
			System.out.println("Worst record! orz : " + worst + "[m] by " + worstname);
		}
	}
}