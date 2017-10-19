import java.util.Scanner ;

//すずめクラスの定義
class Suzume extends Tori{
	//コンストラクタ
	Suzume(double w){
		weight = w;
		subType = "Suzume";
	}
	
	//抽象メソッドのオーバーライド
	void naku(int n){
		for(int i=0; i<n; i++){
			System.out.println("チュン");
			//System.out.println();
		}
	}
		
	//独自のメソッドを追加してもオッケー
	String getName(){
		return "名無し";
	}
	//抽象メソッド以外のメソッドを上書きしてもオッケー
	void food(double x){
		weight += 0.5 * x;
	} //半分残すw
}

//抽象クラスToriの定義
abstract class Tori{
	//フィールドの定義
	String subType = "notype"; //初期値はnotype
	double weight;
	
	//抽象メソッドの定義
	abstract void naku(int n); //n回鳴くメソッド
	
	//抽象メソッド以外のメソッド
	void food(double x){
		weight += x;
	}
}

//ひよこクラスの定義
class Hiyoko extends Tori{
    // フィールド
    String name ;
    //double weight ; 削除する

    // コンストラクタ
    Hiyoko() {
        name = "NO_NAME" ;
        weight = 0 ;
        System.out.println("名前ないけど誕生！") ;
    }
    Hiyoko(String name, double weight) {
        this.name = name ;
        this.weight = weight ;
	subType = "Hiyoko";
        System.out.println(name+"誕生！") ;
    }
    
    //抽象メソッドのオーバーライド
    void naku(int n){
    	System.out.println("ピヨピヨ×" + n);
	}

    // かわゆく鳴く＆体重1gマイナス
    void piyo() {
        if(weight>=1.0)
            System.out.println(name+": ヾ(・◇・)ﾉ ピヨ！") ;
        else
            System.out.println(name+": ～(XθX)ノ ピ...ヨ...") ;
        decrease(1.0) ;
    }

    // 体重を減らすメソッド
    void decrease(double d) {
        weight -= d ;
        // もし0未満なら0gにする
        if(weight<0.0)
            weight = 0.0 ;
    }
    // アクセスメソッド
    String getName() {
        return name ;
    }
    double getWeight() {
        return weight ;
    }
    
    
}
