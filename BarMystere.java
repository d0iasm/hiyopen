import java.util.Scanner;

public class BarMystere{
	public static void main(String[] args){
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("ようこそBar de Mystereへ(_ _)");
		System.out.print("お客さん、お名前は？(・・)");
		String name = stdIn.next();
		System.out.print("何歳ですか？(・・)");
		int age = stdIn.nextInt();
		System.out.print("ご予算は？(・・)");
		int budget = stdIn.nextInt();
		System.out.println("少々お待ちを…|_・)");
		
		if(age >= 20){
			if(budget >= 1500){
				System.out.println(name + "様、カクテルでございます〜(^o^)_Y");
			}else{
				if(budget >= 200){
					System.out.println(name + "様、ビールでございます〜(^_^)_c[]");
				}else{
					System.out.println(name + "様、お水をどうぞ(-_-)_[]");
				}
			}
		}else{
			if(budget >= 600){
				System.out.println(name + "様、オレンジジュースをどうぞ(^_・)_U");
			}else{
				if(budget >= 200){
					System.out.println(name + "様、コーラをどうぞ(・_・)_U");
				}else{
					System.out.println(name + "様、お水をどうぞ(-_-)_[]");
				}
			}
		}
		
		System.out.println("…こうして夜は更けていった…<おしまい>");
	}
}