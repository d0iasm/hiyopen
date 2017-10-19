import java.util.Scanner;

public class FlagDraw{
	public static void main(String[] args){
		Scanner stdIn = new Scanner(System.in);
		
		int w = 0; //幅の数
		int h = 0; //高さの数
		int x; //幅
		int y; //高さ
		
		System.out.print("Width: ");
		w = stdIn.nextInt();
		System.out.print("Height: ");
		h = stdIn.nextInt();
		
		
		for(y=0; y<h; y++){
			
			if(y % 2 == 0){
				//高さの列の偶数判定
				for(x=0; x<w; x++){
					if(x % 2 == 0){
						//幅の列の偶数判定
						System.out.print("#");
					}else{
						System.out.print("+");
					}
				}
			}else{
				for(x=0; x<w; x++){
					if(x % 2 == 0){
						System.out.print("+");
					}else{
						System.out.print("#");
					}
				}
			}
			System.out.println(); //改行
		}
	}
}