import java.util.Scanner ;


class ColorHiyoko extends Hiyoko{
	//追加のフィールド
	private String color;
	//コンストラクタ
	ColorHiyoko(String nm, double wt, String cl){
		super(nm,wt);//スーパークラスの引数つきコンストラクタの呼び出し
		color = cl;
	}
	//追加の新メソッド
	String getColor(){
		return color;
	}
	
	//上書き
	void piyo(){
		System.out.print(getName() + "(" + color);
		if(getWeight() >= 1.0){
			System.out.println("): ヾ(・◇・)ﾉピヨ！");
		}else{
			System.out.println("): ～(XθX)ノ ピ...ヨ...");
		}
		decrease(1.0);
	}
}

public class HiyokoTester {

    static void compareWeight(Hiyoko x, Hiyoko y) {
        Hiyoko a ;
        if(x.getWeight()>y.getWeight())
            a = x ;
        else
            if(x.getWeight()<y.getWeight())
                a = y ;
            else {
                System.out.println("どっちも同じ");
                return ;
            }
            System.out.println(a.getName()+"の方が重い．") ;
    }
	
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in) ;

        Hiyoko p1 = new Hiyoko("John", 1.5) ;
        ColorHiyoko p2 = new ColorHiyoko("Karl", 1.1, "white") ;
	
	//クラス型変数の生成
	Hiyoko q1;
	ColorHiyoko q2;
	
	q1 = p1;
	q1 = p2;
	//q2 = p2;

        // まずは重さを比較
        compareWeight(p1,p2) ;
        // p1を鳴かせてみる
        p1.piyo() ;
        // p2を鳴かせてみる
        p2.piyo() ;
        // p1をもう1回鳴かせてみる
        p1.piyo() ;
        // 再度重さを比較
        compareWeight(p1,p2) ;
	System.out.println(p2.getName() + "のお肌は" + p2.getColor());
    }
}
