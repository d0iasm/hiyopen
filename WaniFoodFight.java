import java.util.Scanner;

public class WaniFoodFight{
	public static void main(String[] args){
		Scanner stdIn = new Scanner(System.in);
		
		int n; //ワニの数
		double sum = 0.0; //合計
		double ave = 0.0; //平均
		
		System.out.print("何頭？: ");
		n = stdIn.nextInt();
		
		String [] name = new String[n]; //ワニの名前
		double [] weight = new double[n]; //ワニの食べた量
		int num = 0; //食いしん坊ワニの数
		
		for(int i=0; i<n; i++){
			System.out.print((i+1) + "頭目の名前: ");
			name[i] = stdIn.next();
			
			System.out.println("--n==n^< ∈=(;;:;::;)=3");
			System.out.println(">~n==n-- ∈===========3");
			
			System.out.print("何kg食べた？: ");
			weight[i] = stdIn.nextDouble();
			
			sum += weight[i];
			ave = sum / i;
			
		}
		
		System.out.println("食された生肉の合計は" + sum + "です。");
		System.out.println("平均は" + ave +"/頭です。");
		
		System.out.println("食いしん坊ワニさんは…");
		for(int i=0; i<n; i++){
			if(weight[i] > ave){
				System.out.println(name[i] + "(" + weight[i] + "[kg])");
				num++;
			}
		}
		System.out.println(num + "頭でした。^^/");
		
	}
}